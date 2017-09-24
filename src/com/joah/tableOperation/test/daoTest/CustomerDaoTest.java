package com.joah.tableOperation.test.daoTest;

import com.joah.tableOperation.dao.CustomerDao;
import com.joah.tableOperation.entity.Customer;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CustomerDaoTest {

    @Test
    public void getSqlTest(){
        Customer customer= new Customer();
        customer.setId("1234");
        customer.setDescription("hello");

        List<String> list = new ArrayList<>();
        String sql0="SELECT * FROM Customer WHERE 1=1  ";
        String sql = CustomerDao.getSql(sql0, customer, list);
        System.out.println(sql);
        for (String s : list) {
            System.out.print(s + "  ");
        }
    }

    @Test
    public void getSql2Test(){
        Customer customer= new Customer();
        customer.setId("1234");
        customer.setDescription("hello");

        List<String> list = new ArrayList<>();
        String sql0="SELECT * FROM Customer WHERE 1=1 ";
        String sql = CustomerDao.getSql(sql0,customer, list);
        System.out.println(sql);
        for (String s : list) {
            System.out.print(s + "  ");
        }
    }
    @Test
    public void findCustomerTest() throws SQLException {
        Customer customer= new Customer();
//        customer.setId("1234");
        customer.setId("1324");
//        customer.setDescription("hello");

        Customer customer1 = CustomerDao.findCustomer(customer);
        System.out.println(customer1);

    }

    @Test
    public void insertCustomerTest() throws SQLException {
        Customer customer= new Customer();
        customer.setId("111");
        customer.setName("joah");
        customer.setSex("male");
        customer.setPhoneNumber("12345678900");
        CustomerDao.insertCustomer(customer);
    }

    @Test
    public void deleteCustomerTest() throws SQLException {
        Customer customer = new Customer();
        customer.setId("111");
        customer.setName("joah");
        customer.setSex("male");
        customer.setPhoneNumber("12345678900");

        CustomerDao.deleteCustomer(customer);
    }
}
