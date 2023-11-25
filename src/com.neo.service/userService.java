package com.neo.service;

import java.util.List;

import com.neo.dao.ArtDao;
import com.neo.dao.UserDao;
import com.neo.entity.User;
//import com.neo.service.LogService;

public class userService {
	public boolean loginVerify(String userName, String password, String ipAdress){
		User user = findByUserName(userName);
		System.out.println("�û���1��"+userName);
		
		System.out.println("�û���2��"+user.getUserName());
		
		LoginLogService logService = new LoginLogService();
		
		if (user == null)
			return false; 
		
		if (!user.getPassword().equals(password)){
			String logContent = "��¼ʧ��";
			logService.addLoginLog(userName, logContent, ipAdress);
			return false; }
		
		//�ж��Ƿ����
		if(!(user.getAvailable().equals("1"))){
			String logContent = "��¼ʧ��";
			logService.addLoginLog(userName, logContent, ipAdress);
			return false; }
		
		//��¼��־
		//String ipAdress = request.getRemoteAddr();
		String logContent = "��¼�ɹ�";
		logService.addLoginLog(userName, logContent, ipAdress);
		
		return true;
	}
	
	public boolean RegistVerify(String password, String sure_passwo){
		
		if (!password.equals(sure_passwo)){
			return false; }
		
		return true;
	}
	
	public User findByUserName(String userName){
		UserDao dao = new UserDao();
		
		return dao.findByUserName(userName);
	}
	
	public User userRegister(User user){
		UserDao userDao=new UserDao();

		if(exists(user.getUserName()))
			return null;
		
		return userDao.add(user);
		}
	
	public boolean exists(String userName){
		User oldUser = findByUserName(userName);
		if(oldUser != null)
			return true;
		else
			return false;
	}
	
	public User alterPassword(User user){
		UserDao dao = new UserDao();
		
		System.out.println("����");
		
		return dao.alterPassword(user);
	}
	
	public User alterPasswordByAdmin(User user,String userName){
		UserDao dao = new UserDao();
		
		OpeLogService opeService = new OpeLogService();
		
		String logContent = "�޸��û�����";
		
		opeService.addOpeLog(userName,user.getUserName(),logContent);
		
		return dao.alterPassword(user);
	}
	
	public User update(User user){
		UserDao dao = new UserDao();
		
		return dao.update(user);
	}
	
	public List<User> findAll() {
		UserDao dao = new UserDao();
		
		return dao.findAll();
	}
	
	public List<User> findAllAvail() {
		UserDao dao = new UserDao();
		
		return dao.findAllAvail();
	}
	
	public List<User> findUser(String find) {
		UserDao dao = new UserDao();
		
		return dao.findUser(find);
	}
	
	public User AlterAvai(User user, String userName){
		UserDao dao = new UserDao();
		OpeLogService opeService = new OpeLogService();
		
		String logContent = "";
		
		if(user.getAvailable().equals("1")){
			logContent = "���õ�¼�û�";
		}
		else{
			logContent = "���õ�¼�û�";
		}
		
		opeService.addOpeLog(userName,user.getUserName(),logContent);
		
		return dao.AlterAvai(user);
	}

	public User AlterAdmin(User user,String userName) {
		UserDao dao = new UserDao();
		OpeLogService opeService = new OpeLogService();
		
		String logContent = "";
		
		if(user.getAdminUser().equals("1")){
			logContent = "���ù���Ա�û�";
		}
		else{
			logContent = "���ù���Ա�û�";
		}
		
		opeService.addOpeLog(userName,user.getUserName(),logContent);
		
		return dao.AlterAdmin(user);
	} 
	
	public String findNickname(String userName){
		UserDao dao = new UserDao();
		
		return dao.findNickname(userName);
	}
}
