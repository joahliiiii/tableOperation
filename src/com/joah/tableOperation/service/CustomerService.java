package com.joah.tableOperation.service;

import com.joah.tableOperation.Utils.jdbc.JDBCUtils;
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

    /**
     * 删除方法
     * @param cus 用户对象
     * @throws SQLException 抛出sql操作异常
     */
    public static void delete(Customer cus) throws SQLException {
        CustomerDao.deleteCustomer(cus);
    }

    /**
     * 更新/修改方法
     * @param cus 从表单获取的用户对象
     * @param sessionCus 存方在session 里面的用户对象
     * @throws SQLException 抛出sql操作异常
     */
    public static void update(Customer cus, Customer sessionCus) throws SQLException {
        CustomerDao.updateCustomer(cus,sessionCus);
    }

    // 查方法就不写了直接调用就好了.( JDBCUtils.query()就可以了 ),算了还是写一下

    /**
     * 查询方法
     * @param cus 从表单获取的用户信息的对象
     * @return 返回查询到的用户的对象
     * @throws SQLException 抛出数据库操作异常
     */
    public static Customer query(Customer cus) throws SQLException {
        // 需要判断一下是否为空,然后在返回/抛出异常 ?
        return  CustomerDao.findCustomer(cus);
    }
}
