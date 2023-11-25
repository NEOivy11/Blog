package com.neo.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.entity.Comment;
import com.neo.entity.User;
import com.neo.service.commentService;
import com.neo.service.userService;

@WebServlet("/AddComment")
public class AddCommentCtrl extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = (String)request.getSession().getAttribute("UserName");
		int artId = Integer.parseInt(request.getParameter("artId"));
		userService userService = new userService();
		User USER = userService.findByUserName(userName);
		request.setAttribute("isAdmin", USER.getAdminUser());
		
		Comment com = new Comment();
		
		com.setUserName(userName);
		com.setArtId(artId);
		com.setComContent(request.getParameter("comContent"));
		com.setAvailable("1");
		
		commentService comService = new commentService();
		comService.addCom(com);
		
		response.sendRedirect("AtricleDisplay?ArtId="+artId);
		
	}

}
