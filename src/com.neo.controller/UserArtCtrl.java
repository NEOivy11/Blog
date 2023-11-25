package com.neo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

@WebServlet("/UserArt")
public class UserArtCtrl extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String userName = (String) request.getSession().getAttribute("UserName");
		
		
		userService userService = new userService();
		String nickname = userService.findNickname(userName);
		request.setAttribute("nickname", nickname);
		User USER = userService.findByUserName(userName);
		request.setAttribute("isAdmin", USER.getAdminUser());
		String UserName = request.getParameter("userName");
		String Nickname = userService.findNickname(UserName);
		if(userName != null){
			request.setAttribute("isAdmin", USER.getAdminUser());}
		
		articleService artService = new articleService();
		List<Atricle> list = artService.findByUserName(UserName);
		
		request.setAttribute("artList", list);
		
		
		request.getRequestDispatcher("/myArt.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 使用重定向将POST请求重定向到主页
        response.sendRedirect(request.getContextPath() + "/myArt.jsp");
	}
}
