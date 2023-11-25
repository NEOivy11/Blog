package com.neo.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.entity.User;
import com.neo.service.userService;

@WebServlet("/PasswordAlter")
public class PasswordAlter extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userName = (String) request.getSession().getAttribute("UserName");
		
		userService userService = new userService();
		String nickname = userService.findNickname(userName);
		request.setAttribute("nickname", nickname);
		User USER = userService.findByUserName(userName);
		request.setAttribute("isAdmin", USER.getAdminUser());

		User user = userService.findByUserName(userName);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/modify.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = (String) request.getSession().getAttribute("UserName");
		
		userService userService = new userService();
		String nickname = userService.findNickname(userName);
		request.setAttribute("nickname", nickname);
		
		User user = new User();
	
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));

		User retUser = userService.alterPassword(user);
		
		User currentUserInfo = userService.findByUserName(request.getParameter("userName"));
		if (currentUserInfo != null) {
			user.setNickname(currentUserInfo.getNickname());
		    user.setFullName(currentUserInfo.getFullName());
		    user.setSex(currentUserInfo.getSex());
		    user.setBirthday(currentUserInfo.getBirthday());
		    user.setPhone(currentUserInfo.getPhone());
		    user.setEmail(currentUserInfo.getEmail());
		    user.setWxid(currentUserInfo.getWxid());
		    user.setDescip(currentUserInfo.getDescip());
		    
		    user.setRegDate(currentUserInfo.getRegDate());
		    
		    java.util.Date currentDate = Calendar.getInstance().getTime();
		    Date sqlDate = new Date(currentDate.getTime());
			user.setModiDate(sqlDate);
		}
		
		request.setAttribute("user", user);

		if (retUser == null){
			request.setAttribute("errorMessage", "修改密码出错！");
			request.getRequestDispatcher("/modify.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("UserDetail.jsp").forward(request, response);	
	}

}
