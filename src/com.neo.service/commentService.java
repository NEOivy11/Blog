package com.neo.service;

import java.util.List;

import com.neo.dao.CommentDao;
import com.neo.dao.UserDao;
import com.neo.entity.Comment;

public class commentService {
	public Comment addCom(Comment com){
		CommentDao comDao=new CommentDao();

		return comDao.add(com);
	}
	
	public Comment repCom(Comment com){
		CommentDao comDao=new CommentDao();

		return comDao.rep(com);
	}
	
	public List<Comment> findByArtId(int artId){
		CommentDao dao = new CommentDao();
		
		return dao.findByArt(artId);
	}
	
	public String findParentUser(int parenCom){
		CommentDao dao = new CommentDao();
		
		return dao.findParentUser(parenCom);
	}
	
	public String findParentCom(int comId){
		CommentDao dao = new CommentDao();
		
		return dao.findParentCom(comId);
	}
}
