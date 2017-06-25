package com.itheima.crm.service;

import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.utils.Page;

public interface CustomerService {
//因为是分页查,所以返回pagebean
	public Page<Customer> selectCustomerByQueryVo(QueryVo vo);

	public Customer selectCustomerById(Integer id);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(Integer id);
}
