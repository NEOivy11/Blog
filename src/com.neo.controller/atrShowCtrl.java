package com.neo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.entity.Atricle;
import com.neo.entity.Comment;
import com.neo.entity.User;
import com.neo.service.articleService;
import com.neo.service.commentService;
import com.neo.service.userService;

@WebServlet("/AtricleDisplay2")
public class artShowCtrl2 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = (String) request.getSession().getAttribute("UserName");
		
		userService userService = new userService();
		String nickname = userService.findNickname(userName);
		request.setAttribute("nickname", nickname);
		User USER = userService.findByUserName(userName);
		request.setAttribute("isAdmin", USER.getAdminUser());
		
		int artId =  Integer.parseInt(request.getParameter("ArtId")); 
		
		articleService artService = new articleService();
		Atricle art = artService.findByArtId(artId);
		
		String type = artService.findType(art.getTypeId());
		commentService comService = new commentService();
		List<Comment> list =  comService.findByArtId(artId);
		
		request.setAttribute("list", list);
		
		request.setAttribute("type", type);
		
		request.setAttribute("art",art);
		request.getRequestDispatcher("/ArtDisplayAUpdate.jsp").forward(request, response);
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}
}
