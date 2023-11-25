package com.neo.service;

import java.util.List;

import com.neo.dao.LoginLogDao;
import com.neo.entity.LoginLog;

public class LoginLogService {
	public void addLoginLog(String userName,String logContent,String ipAdress){
		LoginLogDao dao = new LoginLogDao();
		
		dao.add(userName, logContent, ipAdress);
	}
	
	public List<LoginLog> findAll() {
		LoginLogDao dao = new LoginLogDao();
		
		return dao.findAll();
	}
}
