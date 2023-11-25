package com.neo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neo.service.userService;
import com.neo.entity.User;


@WebServlet("/UserDetail")
public class userDetCtrl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

			HttpSession session = request.getSession();
			
			String userName = (String)session.getAttribute("UserName");
			
			userService userService = new userService();
			String nickname = userService.findNickname(userName);
			request.setAttribute("nickname", nickname);
			User USER = userService.findByUserName(userName);
			if(userName != null){
				request.setAttribute("isAdmin", USER.getAdminUser());}
			
			if (userName == null || userName.equals("")){
				response.sendRedirect("Login");
			}
			else{
				User user = userService.findByUserName(userName);
				request.setAttribute("user",user);
				request.getRequestDispatcher("/UserDetail.jsp").forward(request, response);
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
