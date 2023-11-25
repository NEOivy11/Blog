package com.neo.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/FindArtByTitle")
public class FindArtByTitleCtrl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		String userName = (String) request.getSession().getAttribute("UserName");
		
		userService userService = new userService();
		String nickname = userService.findNickname(userName);
		request.setAttribute("nickname", nickname);
		
		//request.setAttribute("UserName", userName);
		
		String artTitle = request.getParameter("ArtTitle");
		//System.out.println("typeId"+typeId);
		articleService artService = new articleService();
		
		Atricle art = new Atricle();
		List<Atricle> list = artService.findByTitle(artTitle);
		
		
		request.setAttribute("artList", list);
		//request.setAttribute("Type",t);
		request.getRequestDispatcher("/Blog_main.jsp").forward(request, response);*/
		
		doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.sendRedirect(request.getContextPath() + "/Blog_main.jsp");
		
		
		String userName = (String) request.getSession().getAttribute("UserName");
		
		userService userService = new userService();
		String nickname = userService.findNickname(userName);
		request.setAttribute("nickname", nickname);
		User USER = userService.findByUserName(userName);
		if(userName != null){
			request.setAttribute("isAdmin", USER.getAdminUser());}
		//request.setAttribute("UserName", userName);
		
		String artTitle = request.getParameter("ArtTitle");
		//System.out.println("typeId"+typeId);
		articleService artService = new articleService();
		
		Atricle art = new Atricle();
		List<Atricle> list = artService.findByTitle(artTitle);
		
		
		request.setAttribute("artList", list);
		//request.setAttribute("Type",t);
		request.getRequestDispatcher("/Blog_main.jsp").forward(request, response);
	}

}
