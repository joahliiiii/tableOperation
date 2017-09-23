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
        String sql = CustomerDao.getSql(customer, list);
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
}
