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

@WebServlet("/UpdateUser2")
public class UpdateUserCtrl2 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userName = (String)request.getSession().getAttribute("UserName");
		
		if (userName == null || userName.equals("")){
			response.sendRedirect("Login");
			return;
		}
		
		
		
		userService userService = new userService();
		String nickname = userService.findNickname(userName);
		request.setAttribute("nickname", nickname);
		User USER = userService.findByUserName(userName);
		request.setAttribute("isAdmin", USER.getAdminUser());
			
		userName = request.getParameter("userName");
		
		//userService userService = new userService();
		User user = userService.findByUserName(userName);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/modify3.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = (String) request.getSession().getAttribute("UserName");
		
		userService userService = new userService();
		String nickname = userService.findNickname(userName);
		request.setAttribute("nickname", nickname);
		User USER = userService.findByUserName(userName);
		request.setAttribute("isAdmin", USER.getAdminUser());
		userName = request.getParameter("userName");
		System.out.println("userName:"+userName);
		
		User user = userService.findByUserName(userName);
		
		user.setNickname(request.getParameter("Nickname"));
		user.setFullName(request.getParameter("fullName"));
		user.setSex(request.getParameter("sex"));
		user.setBirthday(request.getParameter("birthday"));
		
		String phoneParam = request.getParameter("phone");
		int phone = Integer.parseInt(phoneParam);
        user.setPhone(phone);
        
		user.setEmail(request.getParameter("email"));
		user.setWxid(request.getParameter("wxid"));
		user.setDescip(request.getParameter("descip"));
		
		java.util.Date currentDate = Calendar.getInstance().getTime();
    Date sqlDate = new Date(currentDate.getTime());
		user.setModiDate(sqlDate);

		User retUser = userService.update(user);
		
		request.setAttribute("user", user);

		if (retUser == null){
			request.setAttribute("errorMessage", "修改信息出错！");
			request.getRequestDispatcher("/modify3.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("UserDetail3.jsp").forward(request, response);
	}
}
