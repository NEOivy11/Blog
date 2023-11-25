package com.neo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.entity.Comment;
import com.neo.service.commentService;

@WebServlet("/Reply")
public class ReplyCtrl extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = (String)request.getSession().getAttribute("UserName");
		int artId = Integer.parseInt(request.getParameter("artId"));
		int parentCom = Integer.parseInt(request.getParameter("parentCom"));	
		Comment com = new Comment();
		
		com.setUserName(userName);
		com.setArtId(artId);
		com.setParentCom(parentCom);
		com.setComContent(request.getParameter("repComContent"));
		com.setAvailable("1");
		commentService comService = new commentService();
		comService.repCom(com);
		response.sendRedirect("AtricleDisplay?ArtId="+artId);
		
	}

}
