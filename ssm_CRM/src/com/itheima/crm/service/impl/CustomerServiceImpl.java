package com.itheima.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.crm.dao.CustomerDao;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.CustomerService;
import com.itheima.crm.utils.Page;
@Service
public class CustomerServiceImpl implements CustomerService{
//注入dao
	@Autowired
	private CustomerDao customerDao;
	//查询
	@Override
	public Page<Customer> selectCustomerByQueryVo(QueryVo vo) {
		//page对象
		Page<Customer> page=new Page<Customer>();
		//设置当前页数
			//第一次的时候有可能是null,给他初始值
		if(vo.getPage()==null){
			vo.setPage(1);
		}
		//给page设置当前页
		page.setPage(vo.getPage());
		//设置每页个数
		page.setSize(5);	
			//要给vo也设置上[因为要根据它取开始索引]
		vo.setNubersize(5);
		//总记录数[这个条件下的]
		page.setTotal(customerDao.countCustomer(vo));
		//结果集[这个条件下的][因为要分页查,所以vo中要有开始索引和个数]
		vo.setStrat((vo.getPage()-1)*vo.getNubersize());//索引=(当前页-1)*每页个数
		List<Customer> list = customerDao.selectCustomerList(vo);
		page.setRows(list);
		return page;
	}
//根据id查
	@Override
	public Customer selectCustomerById(Integer id) {
		// TODO Auto-generated method stub
		return customerDao.selectCustomerById(id);
	}
	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
		
	}
	@Override
	public void deleteCustomer(Integer id) {
		customerDao.deleteCustomer(id);
		
	}

}
