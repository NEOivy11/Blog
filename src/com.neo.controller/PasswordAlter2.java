package com.neo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.entity.User;
import com.neo.service.userService;

@WebServlet("/PasswordAlter2")
public class PasswordAlter2 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userName = (String) request.getSession().getAttribute("UserName");
		
		userService userService = new userService();
		String nickname = userService.findNickname(userName);
		request.setAttribute("nickname", nickname);
		User USER = userService.findByUserName(userName);
		request.setAttribute("isAdmin", USER.getAdminUser());
			
		String UserName = request.getParameter("UserName");

    User user = userService.findByUserName(UserName);
    request.setAttribute("user", user);
    request.getRequestDispatcher("/modify.jsp").forward(request, response);
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = (String) request.getSession().getAttribute("UserName");
		
		userService userService = new userService();
		String nickname = userService.findNickname(userName);
		request.setAttribute("nickname", nickname);
		User USER = userService.findByUserName(userName);
		request.setAttribute("isAdmin", USER.getAdminUser());
		
        String targetUserName = request.getParameter("UserName");

        User targetUser = userService.findByUserName(targetUserName);

        targetUser.setPassword(request.getParameter("password"));
        
        User updatedUser = userService.alterPasswordByAdmin(targetUser,userName);

        if (updatedUser == null) {
        	request.setAttribute("errorMessage", "修改密码出错！");
			request.getRequestDispatcher("/modify.jsp").forward(request, response);
			return;
        }

        request.setAttribute("user", updatedUser);
        request.getRequestDispatcher("UserDetail3.jsp").forward(request, response);	
	}
}
