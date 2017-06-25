package com.itheima.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.crm.dao.BasicDao;
import com.itheima.crm.pojo.BasicDict;
import com.itheima.crm.service.BasicService;
@Service
public class BasicServiceImpl implements BasicService {
	//注入dao
	@Autowired
	private BasicDao basicDao;

	@Override
	public List<BasicDict> selectDictByCode(String s) {
		// TODO Auto-generated method stub
		return basicDao.selectDictByCode(s);
	}


	
}
