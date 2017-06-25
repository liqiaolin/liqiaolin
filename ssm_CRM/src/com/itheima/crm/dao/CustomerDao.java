package com.itheima.crm.dao;

import java.util.List;

import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

public interface CustomerDao {
//查询总记录数
	int countCustomer(QueryVo vo);
//查询结果集
	List<Customer> selectCustomerList(QueryVo vo);
	Customer selectCustomerById(Integer id);
	void updateCustomer(Customer customer);
	void deleteCustomer(Integer id);

}
