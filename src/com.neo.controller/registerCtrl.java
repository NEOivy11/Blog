package com.neo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neo.service.userService;
import com.neo.common.Encode;
import com.neo.entity.User;


@WebServlet("/Register")
public class registerCtrl extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/Register.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		
		User user = new User();
		
		user.setNickname(request.getParameter("Nickname"));
		String userName = Encode.generateRandomNumber();
		user.setUserName(userName);
		user.setFullName(request.getParameter("FullName"));
		user.setPassword(request.getParameter("password"));
		user.setSex(request.getParameter("sex"));
		user.setPhone(Integer.parseInt(request.getParameter("phone")));
		user.setBirthday(request.getParameter("birthday"));
		user.setEmail(request.getParameter("email"));
		user.setWxid(request.getParameter("wxid"));
		user.setDescip(request.getParameter("descip"));
		user.setAvailable("1");
		user.setAdminUser("0");
		
		String sure_passwo = request.getParameter("surePassword");
		String password = request.getParameter("password");
		userService userService = new userService();
		
		userService.userRegister(user);
		
		if (userService.RegistVerify(password, sure_passwo)){
			HttpSession session = request.getSession();
			
			
			request.setAttribute("user", user);
	
			
			request.getRequestDispatcher("/regSuccess.jsp").forward(request, response);
		}
		else{
			request.setAttribute("message", "两次输入的密码要相等！");
			request.getRequestDispatcher("/Register.jsp").forward(request, response);
		}
		
	}
}
