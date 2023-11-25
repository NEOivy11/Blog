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
import com.neo.entity.User;
import com.neo.service.articleService;
import com.neo.service.userService;

@WebServlet("/DeleteArt")
public class DeleteArtCtrl extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = (String) request.getSession().getAttribute("UserName");
		
		userService userService = new userService();
		String nickname = userService.findNickname(userName);
		request.setAttribute("nickname", nickname);
		User USER = userService.findByUserName(userName);
		request.setAttribute("isAdmin", USER.getAdminUser());
		
		
		String getArtId = request.getParameter("artId");
		int artId = Integer.parseInt(getArtId);
		
		articleService artService = new articleService();
		
		Atricle art = artService.findByArtId(artId);
		
		artService.deleteArt(art);
		
		List<Atricle> list = artService.findByUserName(userName);
		
		request.setAttribute("artList", list);
		
		request.getRequestDispatcher("/myArt.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		
	}

}
