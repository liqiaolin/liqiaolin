package com.itheima.crm.dao;

import java.util.List;

import com.itheima.crm.pojo.BasicDict;

public interface BasicDao {

	//查下拉列表
	public List<BasicDict> selectDictByCode(String s);//把code传过来

	//public List<BasicDict> selectList();
}
