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


@WebServlet("/Article")
public class atricleCtrl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = (String) request.getSession().getAttribute("UserName");
		
		userService userService = new userService();
		String nickname = userService.findNickname(userName);
		request.setAttribute("nickname", nickname);
		User USER = userService.findByUserName(userName);
		request.setAttribute("isAdmin", USER.getAdminUser());
		
		typeService typeService = new typeService();
		List<Type> list = typeService.findAll(userName);
		
		request.setAttribute("typeList", list);
		request.getRequestDispatcher("/Article.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = (String) request.getSession().getAttribute("UserName");
		
		userService userService = new userService();
		String nickname = userService.findNickname(userName);
		request.setAttribute("nickname", nickname);
		
		Type type = new Type();
		
		type.setType(request.getParameter("type"));
		type.setUserName(userName);
		
		typeService typeService = new typeService();
		typeService.addType(type);
		
		response.sendRedirect("Article");

	}

}
