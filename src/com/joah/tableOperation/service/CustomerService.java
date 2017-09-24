package com.joah.tableOperation.service;

import com.joah.tableOperation.dao.CustomerDao;
import com.joah.tableOperation.entity.Customer;

import java.sql.SQLException;

public class CustomerService {

    /**
     * 添加一个新用户
     * @param customer Customer 对象
     * @throws SQLException 返回SQL操作异常
     */
    public static void insert(Customer customer) throws SQLException {

        if(CustomerDao.findCustomer(customer) == null){
            CustomerDao.insertCustomer(customer);
        }else{
            // 在这里写个自定义异常最好了
        }
    }

    public static void delete(Customer cus) throws SQLException {
        CustomerDao.deleteCustomer(cus);
    }

    public static void update(Customer cus, Customer sessionCus){



    }
}
