package com.neo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neo.service.userService;


@WebServlet("/Login")
public class loginCtrl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/Login.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String UserName = request.getParameter("UserName");
		String password = request.getParameter("password");
		
		userService userService = new userService();
		String ipAdress = request.getRemoteAddr();
		
		if (userService.loginVerify(UserName, password, ipAdress)){
			HttpSession session = request.getSession();
			session.setAttribute("UserName", UserName);
			
			response.sendRedirect("Blog_main");
		}
		else{
			request.setAttribute("UserName", UserName);
			request.setAttribute("message", "登陆失败，请检查您的用户名或者密码，并确认您没有被禁用！");
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		
	}

}
