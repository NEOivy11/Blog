package com.neo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.entity.Atricle;
import com.neo.entity.Type;
import com.neo.entity.User;
import com.neo.service.articleService;
import com.neo.service.typeService;
import com.neo.service.userService;

@WebServlet("/ArtByType")
public class ArtByTypeCtrl extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = (String) request.getSession().getAttribute("UserName");
		
		userService userService = new userService();
		String nickname = userService.findNickname(userName);
		request.setAttribute("nickname", nickname);
		User USER = userService.findByUserName(userName);
		request.setAttribute("isAdmin", USER.getAdminUser());
		
		int typeId =Integer.parseInt(request.getParameter("TypeId"));
		System.out.println("typeId"+typeId);
		typeService typeService = new typeService();
		Type t = typeService.findByType(typeId, userName);
		
		articleService artService = new articleService();
		
		List<Atricle> list = artService.findByType(typeId,userName);
		
		
		request.setAttribute("artList", list);
		request.setAttribute("Type",t);
		request.getRequestDispatcher("/ArticleByType.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/ArticleByType.jsp");
		
	}

}
