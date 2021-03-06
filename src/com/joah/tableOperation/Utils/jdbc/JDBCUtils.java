package com.joah.tableOperation.Utils.jdbc;

import com.joah.tableOperation.entity.Customer;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JDBCUtils {
    private static DataSource dataSource=new ComboPooledDataSource("c3p0config");

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    /**
     * 获取到当前的dataSource
     * @return dataSource
     */
    public static DataSource getDataSource(){
        return dataSource;
    }

    /**
     *  获取数据库连接(支持事务)
     * @return 返回数据库连接
     * @throws SQLException 跑出数据库异常
     */
    public static Connection getConnection() throws SQLException {
        // 先从ThreadLocal里面获取链接,
        Connection connection = threadLocal.get();
        // 如果可以获取到的话那么就说明是开启了事务
        if(connection != null){
            return connection;
        }
        // 如果不是事务的话就返回新建的连接
        return dataSource.getConnection();
    }

    /**
     * 开启事务
     * @throws SQLException 抛出数据库异常
     */
    public static void beginTransaction() throws SQLException {
        // 从ThreadLocal里面获取connection
        Connection connection = threadLocal.get();
        // 如果说链接不为空,那么就说明事务已经开启了,还么有关闭
        if(connection != null){
            throw new SQLException("事务已经开启了,还未结束请不要重复开启事务!!");
        }
        // 没有connection的话就要新获取一个connenction
        connection= getConnection();
        // 开启事务
        connection.setAutoCommit(false);
        // 吧当前线程的链接传入ThreadLocal
        threadLocal.set(connection);

    }

    /**
     * 提交事务
     * @throws SQLException 抛出数据库操作异常
     */
    public static void commitTransaction() throws SQLException {
        // 先从ThreahLocal 里面获取链接
        Connection connection = threadLocal.get();
        if(connection == null){
            throw new SQLException("事务还未开启,请先开启一个事务!!");
        }
        // 提交事务
        connection.commit();
        // 吧已经提交的事务的链接释放了
        threadLocal.remove();

    }

    /**
     * 回滚事务
     * @throws SQLException 抛出数据库操作异常
     */
    public static void rollbackTransaction() throws SQLException {
        // 先从ThreadLocal里面获取数据库链接
        Connection connection = threadLocal.get();
        if(connection == null){
            throw new SQLException("事务还未开启,请先开启一个事务!!");
        }
        // 回滚事务
        connection.rollback();
        // 移除ThreahLocal的数据库连接
        threadLocal.remove();
    }

    /**
     * 关闭数据库链接
     * @param con 需要关闭的数据库链接
     * @throws SQLException 抛出数据库操作异常
     */
    public static void realse(Connection con) throws SQLException {
        Connection connection = threadLocal.get();
        if(connection == null){
            if(con != null && !con.isClosed()){
                con.close();
            }
        }else{
            throw new SQLException("事务还未提交,请先提交事务");
        }
    }

    /**
     * 增删改查操作
     */

    /**
     * 可以进行 update / insert 操作,
     * @param sql SQL语句
     * @param args 不定参数
     * @throws SQLException 抛出SQL异常
     */
    public static void update(String sql,String ...args) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            preparedStatement.setObject(i+1,arg);
        }
        preparedStatement.executeUpdate();
    }

    /**
     * 可以进行 update / insert 操作,但是参数是 list形式的
     * @param sql sql语句
     * @param list 参数的list
     * @throws SQLException 抛出数据库操作异常
     */
    public static void update(String sql, ArrayList<String> list) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            preparedStatement.setObject(i+1,s);
        }
        preparedStatement.executeUpdate();
    }

    public static ResultSet select(String sql,String ...args) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            preparedStatement.setObject(i+1,arg);
        }
        return preparedStatement.executeQuery();
    }

    public static <T> T query(String sql,ResultsetHandler<T> rsh,String ...args) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            preparedStatement.setObject(i+1,arg);
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        return rsh.handle(resultSet);
    }

    public static <T> T query(String sql, ResultsetHandler<T> rsh, ArrayList<String> list) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            preparedStatement.setObject(i+1,s);
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        return rsh.handle(resultSet);
    }


}
