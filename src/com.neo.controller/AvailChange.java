package com.neo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.entity.User;
import com.neo.service.userService;

@WebServlet("/Change")
public class AvailChange extends HttpServlet {
	
		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			String userName = (String)request.getSession().getAttribute("UserName");
			
			if (userName == null || userName.equals("")){
				response.sendRedirect("Login");
				return;
			}
				
			String UserName = request.getParameter("UserName");
			userService userService = new userService();
			User user = userService.findByUserName(UserName);
			
			user = userService.AlterAvai(user,userName);		
			
			response.sendRedirect("UserManage");
			
		}

		
		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doGet(request, response);
		}
		
	}
