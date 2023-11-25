package com.neo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.entity.Type;
import com.neo.entity.User;
import com.neo.service.typeService;
import com.neo.service.userService;


@WebServlet("/DeleteType")
public class DeleteTypeCtrl extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = (String) request.getSession().getAttribute("UserName");
		
		userService userService = new userService();
		String nickname = userService.findNickname(userName);
		request.setAttribute("nickname", nickname);
		User USER = userService.findByUserName(userName);
		request.setAttribute("isAdmin", USER.getAdminUser());
		
		
		String getTypeId = request.getParameter("typeId");
		int typeId = Integer.parseInt(getTypeId);
		
		typeService tService = new typeService();
		
		Type type = tService.findByType(typeId,userName);
		
		tService.deleteType(type);
		
	    List<Type> list = tService.findAll(userName);
		
		request.setAttribute("typeList", list);
		
		request.getRequestDispatcher("/Article.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		
	}

}
