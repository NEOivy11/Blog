package com.neo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.entity.OpeLog;
import com.neo.entity.User;
import com.neo.service.OpeLogService;
import com.neo.service.userService;

@WebServlet("/OperationLog")
public class opeLogCtrl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = (String) request.getSession().getAttribute("UserName");
		
		userService userService = new userService();
		String nickname = userService.findNickname(userName);
		request.setAttribute("nickname", nickname);
		User USER = userService.findByUserName(userName);
		request.setAttribute("isAdmin", USER.getAdminUser());
		
		OpeLogService logService = new OpeLogService();
		List<OpeLog> list = logService.findAll();
		
		request.setAttribute("logList", list);
		
		request.getRequestDispatcher("/OperationLog.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
