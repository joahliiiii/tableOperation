package com.joah.tableOperation.test.jdbcTest;

import com.joah.tableOperation.Utils.jdbc.JDBCUtils;
import com.joah.tableOperation.Utils.jdbc.ResultsetHandler;
import com.joah.tableOperation.entity.Customer;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcUtilsTest {

    @Test
    public void getConnectionTest() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        System.out.println("getConnection: "+connection);
    }
    @Test
    public void updateTest() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        JDBCUtils.beginTransaction();
        String sql="INSERT  INTO Customer(id, name, sex, birthday, phoneNumber, email, description) \n" +
                "              VALUES(?,?,?,?,?,?,?);";

        String id="123567";
        String name="joah";
        String sex="male";
        String birth="19960803";
        String phone="12398765432";
        String email="1234567@请求.com";
        String des="jkl";

        JDBCUtils.update(sql,id,name,sex,birth,phone,email,des);

        JDBCUtils.commitTransaction();
        JDBCUtils.realse(connection);
    }

    @Test
    public void selectTest() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        JDBCUtils.beginTransaction();
        String sql="SELECT name FROM Customer WHERE id=?";
        String id="1324";
        ResultSet res = JDBCUtils.select(sql, id);
        while(res.next()){
            String string = res.getString(1);
            System.out.println(string);
        }
        JDBCUtils.commitTransaction();
        JDBCUtils.realse(connection);
    }

    /**
     * 只适合结果集为一行的
     */
    private ResultsetHandler<Customer> defaultH = new ResultsetHandler<Customer>() {
        @Override
        public Customer handle(ResultSet resultSet) throws SQLException {
            Customer cus=null;
            if(resultSet.next()){
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
    @Test
    public void queryTest() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        JDBCUtils.beginTransaction();
        String sql="SELECT * FROM Customer WHERE id=?";
        String id="13245";
        Customer cus = JDBCUtils.query(sql, defaultH, id);
        System.out.println(cus);

        JDBCUtils.commitTransaction();
        JDBCUtils.realse(connection);
    }

    /*public void query2Test() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        JDBCUtils.beginTransaction();

        String sql = "";

        JDBCUtils.commitTransaction();
        JDBCUtils.realse(connection);
    }*/
}
