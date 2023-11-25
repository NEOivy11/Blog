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
import com.neo.entity.Type;
import com.neo.entity.User;
import com.neo.service.articleService;
import com.neo.service.commentService;
import com.neo.service.typeService;
import com.neo.service.userService;

@WebServlet("/UpdateArt")
public class UpdateArtCtrl extends HttpServlet {

	
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
		request.setAttribute("art", art);
		
		typeService typeService = new typeService();
		List<Type> list = typeService.findAll(userName);
		request.setAttribute("typeList", list);
		
		request.getSession().setAttribute("artId", artId);
		
		request.getRequestDispatcher("/ArtModify.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = (String) request.getSession().getAttribute("UserName");
		
		userService userService = new userService();
		String nickname = userService.findNickname(userName);
		request.setAttribute("nickname", nickname);
		
		
		int artId = (Integer) request.getSession().getAttribute("artId");
		articleService artService = new articleService();
		Atricle art = artService.findByArtId(artId);
		
		art.setArtTitle(request.getParameter("artTitle"));
		art.setTypeId(Integer.parseInt(request.getParameter("typeId")));
		art.setContent(request.getParameter("content"));
		Atricle retArt = artService.modifyContent(art);
		
		request.setAttribute("art", art);

		if (retArt == null){
			request.setAttribute("errorMessage", "修改文章出错！");
			request.getRequestDispatcher("/ArtModify.jsp").forward(request, response);
			return;
		}
		String type = artService.findType(art.getTypeId());
		request.setAttribute("type", type);
		
		commentService comService = new commentService();
		List<Comment> list =  comService.findByArtId(artId);
		
		request.setAttribute("list", list);

		request.getRequestDispatcher("ArtDisplayAUpdate.jsp").forward(request, response);		
	}

}
