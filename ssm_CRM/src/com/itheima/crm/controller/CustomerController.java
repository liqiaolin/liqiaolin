package com.itheima.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.crm.pojo.BasicDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.BasicService;
import com.itheima.crm.service.CustomerService;
import com.itheima.crm.utils.Page;

@Controller
public class CustomerController {

	//注入service
	@Autowired
	private BasicService basicService;
	@Autowired
	private CustomerService customerService;
	
	//获取resource.properties中的值
	@Value(value="${laiyuan}")
	private String laiyuan;
	@Value(value="${hangye}")
	private String hangye;
	@Value(value="${jibie}")
	private String jibie;
	
	/*
	 * 因为有分页,所以点击客户列表和点击查询按钮和点击分页按钮都应该走一个方法
	 * 
	 * */
	
	//到列表页面
		@RequestMapping(value="/customer/list.action")
	public String list(Model model,QueryVo vo){//vo的属性和name一样就可以接到
		//让下拉列表显示[放数据用model]
		//要从dict表查,返回list集合,所以要写一个类,和表对应上
		//客户来源code=009
	/*	
	 * 
	 * 	basicService.selectDictByCode("009");我们可以看到后面的这个数字是写死的,万一以后换呢就得改代码存在硬编码问题
			解决:写一个resource.properties文件,然后再springmvc.xml加载一下,然后再这用@Vaule=(value="${名字}"),获取给了变量就可以
			以后改配置文件即可
		*/
			List<BasicDict> list1 = basicService.selectDictByCode(laiyuan);
		//所属行业code=001
			List<BasicDict> list2 = basicService.selectDictByCode(hangye);
			
		//客户级别code=006
			List<BasicDict> list3 = basicService.selectDictByCode(jibie);
		
	//要显示数据,必须放在model里,然后看页面上name的名字必须一致
			model.addAttribute("fromType",list1);
			model.addAttribute("industryType", list2);
			model.addAttribute("levelType",list3);
		
		
	/***************************************当在框子写上那些点击查询时,想要让那个框子还回显.就把他的数据接上放到model里,接的时候可以是string一个一个接,也可以写到一个类中,用类接
	 * 	但是记得model存是的name要和页面上的一样
	 * 	********************************/		
		
		//想让它点了查询后,还要显示自己写的是什么,就在页面上value获取值${},然后再controller层存数据就可以
			model.addAttribute("custName", vo.getCustName());
			model.addAttribute("custSource", vo.getCustSource());//把自己要查询的放进去
			model.addAttribute("custSource", vo.getCustSource());
			model.addAttribute("custIndustry", vo.getCustIndustry());
			model.addAttribute("custLevel", vo.getCustLevel());
			//为了想让那些来源不是数字而是名字,就用上面查的那些去循环判断,相等则显示名称
			
			
			
			
		//当他点击查询的时候,走的也是这个方法,现在查的是customer所以要注入customerservice	
				Page<Customer> page = customerService.selectCustomerByQueryVo(vo);
				//存数据
				model.addAttribute("page", page);
		return "customer";
	}
		
	//去修改页面,回显数据
		@RequestMapping(value="/customer/edit.action")
		public @ResponseBody Customer toupdate(Integer id){
			//id接收传过来的id
			Customer customer=customerService.selectCustomerById(id);
			//因为是ajax数据,要返回ajax数据
			return customer;
			
		}
//当修改了数据之后,点保存[也是ajax,虽然不需要返回数据,但是也必须返回一个东西,这样才型]
		@RequestMapping(value="/customer/update.action")
		public @ResponseBody String update(Customer customer){
			//customer已经接收了
			customerService.updateCustomer(customer);
			return "ok";
		}
//当点击删除时,删除,还是ajax
		@RequestMapping(value="/customer/delete.action")
		public @ResponseBody String delete(Integer id){
			customerService.deleteCustomer(id);
			return "ok";
		}
}
