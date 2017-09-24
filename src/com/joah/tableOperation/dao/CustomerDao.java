package com.joah.tableOperation.dao;

import com.joah.tableOperation.Utils.jdbc.JDBCUtils;
import com.joah.tableOperation.Utils.jdbc.ResultsetHandler;
import com.joah.tableOperation.entity.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class CustomerDao {


    /**
     * 默认的处理结果集的方法
     * 只适合结果集为一行的
     */
    private static ResultsetHandler<Customer> defaultHandler = new ResultsetHandler<Customer>() {
        @SuppressWarnings("Duplicates")
        @Override
        public Customer handle(ResultSet resultSet) throws SQLException {
            Customer cus = null;
            if (resultSet.next()) {
                cus = new Customer();
                cus.setId(resultSet.getString("id"));
                cus.setName(resultSet.getString("name"));
                cus.setSex(resultSet.getString("sex"));
                cus.setEmail(resultSet.getString("email"));
                cus.setBirthday(resultSet.getString("birthday"));
                cus.setPhoneNumber(resultSet.getString("phoneNumber"));
                cus.setDescription(resultSet.getString("description"));
                cus.setIsDelete(resultSet.getInt("isDelete"));
            }
            return cus;
        }
    };
    /**
     * 在添加客户的时候使用,添加用户之前的校验
     * @param customer 用户对象
     * @return 返回查询出的对象,如果没有则为null
     */
    public static Customer findCustomer(Customer customer) throws SQLException {
        /*
         * 先生成sql
         * 执行 query() 方法得到Customer
         */
        ArrayList<String> list = new ArrayList<>();
        String sql0="SELECT * FROM Customer WHERE 1=1 and isDelete = 0";
        String sql = getSql(sql0, customer, list);

        Connection connection = JDBCUtils.getConnection();
        JDBCUtils.beginTransaction();

        Customer query = JDBCUtils.query(sql, defaultHandler, list);

        JDBCUtils.commitTransaction();
        JDBCUtils.realse(connection);
        return query;

    }

    /**
     * 插入一个新用户
     * @param customer 用户对象
     * @throws SQLException 抛出数据库处理异常
     */
    public static void insertCustomer(Customer customer) throws SQLException {
        /*
         * 先生成 sql
         * 执行 update 方法
         */
        String sql="INSERT  INTO Customer(id, name, sex, birthday, phoneNumber, email, description) \n" +
                "              VALUES(?,?,?,?,?,?,?);";
        ArrayList<String> list = new ArrayList<>();
        list.add(customer.getId());
        list.add(customer.getName());
        list.add(customer.getSex());
        list.add(customer.getBirthday());
        list.add(customer.getPhoneNumber());
        list.add(customer.getEmail());
        list.add(customer.getDescription());

        Connection connection = JDBCUtils.getConnection();
        JDBCUtils.beginTransaction();

        JDBCUtils.update(sql,list);

        JDBCUtils.commitTransaction();
        JDBCUtils.realse(connection);

    }

    /**
     * 删除一个用户
     * @param customer Customer 对象
     * @throws SQLException 抛出SQL操作异常
     */
    public static void deleteCustomer(Customer customer) throws SQLException {
        /*
        得到sql
        调用JDBCUtils.update()修改 isDelete 的值
         */
        String sql0 = "update Customer set isDelete = 1 where 1=1 ";
        ArrayList<String> list = new ArrayList<>();

        String sql = getSql(sql0, customer, list);
        System.out.println(sql);
        for (String s : list) {
            System.out.print(s + "  ");
        }

        Connection connection = JDBCUtils.getConnection();
        JDBCUtils.beginTransaction();

        JDBCUtils.update(sql,list);

        JDBCUtils.commitTransaction();
        JDBCUtils.realse(connection);

    }

/*    public static Customer advancedSelect(Customer cus){
        *//*
         *先生成sql
         *//*

    }*/

    public static void updateCustomer(Customer cus,Customer sessionCus) throws SQLException {

        String sex = Objects.equals(cus.getSex(), sessionCus.getSex()) ? null : cus.getSex();
        cus.setSex(sex);
        String name = Objects.equals(cus.getName(), sessionCus.getName()) ? null : cus.getName();
        cus.setName(name);

        String email = Objects.equals(cus.getEmail(), sessionCus.getEmail()) ? null : cus.getEmail();
        cus.setEmail(email);
        String phone = Objects.equals(cus.getPhoneNumber(), sessionCus.getPhoneNumber()) ? null : cus.getPhoneNumber();
        cus.setPhoneNumber(phone);
        String birth = Objects.equals(cus.getBirthday(), sessionCus.getBirthday()) ? null : cus.getBirthday();
        cus.setBirthday(birth);
        String desc = Objects.equals(cus.getDescription(), sessionCus.getDescription()) ? null : cus.getDescription();
        cus.setDescription(desc);

        System.out.println(cus);

        String sql0 = "update Customer set isDelete = 0 ";
        ArrayList<String> list = new ArrayList<>();
        String sql = getSql(sql0, cus, list);
//        sql.concat(" where 1 = 1 ");
        sql = sql + " where 1 = 1 ";
        sql = sql.replaceAll(" and",",");
//        System.out.println(sql);

        String finalSql = getSql(sql, sessionCus, list);

        /*System.out.println(finalSql);
        for (String s : list) {
            System.out.print(s + "  ");
        }*/

        Connection connection = JDBCUtils.getConnection();
        JDBCUtils.beginTransaction();

        JDBCUtils.update(finalSql,list);

        JDBCUtils.commitTransaction();
        JDBCUtils.realse(connection);
    }

    /**
     * 传入一个 sql 语句然后根据Customer 的参数名生成对应的 sql
     * @param sql sql
     * @param cus Customer 对象
     * @param list 参数list
     * @return 返回生成的sql
     */
    public static String getSql(String sql,Customer cus,List<String> list){
        if (cus.getId()!=null && !cus.getId().equals("")){
            sql=sql.concat(" and id=? ");
            list.add(cus.getId());
        }
        if (cus.getName()!=null && !cus.getName().equals("")){
            sql=sql.concat(" and name=? ");
            list.add(cus.getName());
        }
        if (cus.getSex()!=null && !cus.getSex().equals("")){
            sql=sql.concat(" and sex=? ");
            list.add(cus.getSex());
        }
        if (cus.getBirthday()!=null && !cus.getBirthday().equals("")){
            sql=sql.concat(" and birthday=? ");
            list.add(cus.getBirthday());
        }
        if (cus.getPhoneNumber()!=null && !cus.getPhoneNumber().equals("")){
            sql=sql.concat(" and phoneNumber=? ");
            list.add(cus.getPhoneNumber());
        }
        if (cus.getEmail()!=null && !cus.getEmail().equals("")){
            sql=sql.concat(" and email=? ");
            list.add(cus.getEmail());
        }
        if (cus.getDescription()!=null && !cus.getDescription().equals("")){
            sql=sql.concat(" and description=? ");
            list.add(cus.getDescription());
        }
        return sql;
    }
}
