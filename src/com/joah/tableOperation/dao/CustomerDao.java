package com.joah.tableOperation.dao;

import com.joah.tableOperation.Utils.jdbc.JDBCUtils;
import com.joah.tableOperation.Utils.jdbc.ResultsetHandler;
import com.joah.tableOperation.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CustomerDao {


    /**
     * 默认的处理结果集的方法
     * 只适合结果集为一行的
     */
    private static ResultsetHandler<Customer> defaultHandler = new ResultsetHandler<Customer>() {
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

    /**
     * 在添加客户的时候使用,添加用户之前的校验
     * @param customer 用户对象
     * @return 返回查询出的对象
     */
    public static Customer findCustomer(Customer customer) throws SQLException {
        /*
         * 先生成sql
         * 执行 query() 方法得到Customer
         */
        ArrayList<String> list = new ArrayList<>();
        String sql = getSql(customer, list);

        return JDBCUtils.query(sql, defaultHandler, list);

    }

    public static void insertCustomer(Customer customer){

    }

    public static Customer advancedSelect(Map<String,String[]> map){
        return null;
    }

    /**
     * 根据参数的个数的变化生成sql 和 参数列表
     * @param cus 对象
     * @param list 参数的list
     * @return 返回生成之后的sql
     */
    public static String getSql(Customer cus,List<String> list){
        StringBuilder sql=new StringBuilder("SELECT * FROM Customer WHERE 1=1  ");
//        List<String> list = new ArrayList<>();
        // 添加一个参数就在list里面添加一个参数值
        // 在这里需要注意 一定要在初始化sql 里面加一个一定成立的条件.使得单独一个初始sql也可以进行查询
        if (cus.getId()!=null && !cus.getId().equals("")){
            sql.append(" and id=? ");
            list.add(cus.getId());
        }
        if (cus.getName()!=null && !cus.getName().equals("")){
            sql.append(" and name=? ");
            list.add(cus.getName());
        }
        if (cus.getSex()!=null && !cus.getSex().equals("")){
            sql.append(" and sex=? ");
            list.add(cus.getSex());
        }
        if (cus.getBirthday()!=null && !cus.getBirthday().equals("")){
            sql.append(" and birthday=? ");
            list.add(cus.getBirthday());
        }
        if (cus.getPhoneNumber()!=null && !cus.getPhoneNumber().equals("")){
            sql.append(" and phoneNumber=? ");
            list.add(cus.getPhoneNumber());
        }
        if (cus.getEmail()!=null && !cus.getEmail().equals("")){
            sql.append(" and email=? ");
            list.add(cus.getEmail());
        }
        if (cus.getDescription()!=null && !cus.getDescription().equals("")){
            sql.append(" and description=? ");
            list.add(cus.getDescription());
        }
        return sql.toString();
    }
}
