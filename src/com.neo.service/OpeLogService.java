package com.neo.service;

import java.util.List;

import com.neo.dao.OpeLogDao;
import com.neo.entity.OpeLog;

public class OpeLogService {
	public void addOpeLog(String userName,String changeUser,String logContent){
		OpeLogDao dao = new OpeLogDao();
		
		dao.add(userName,changeUser ,logContent);
	}
	
	public List<OpeLog> findAll() {
		OpeLogDao dao = new OpeLogDao();
		
		return dao.findAll();
	}
}
