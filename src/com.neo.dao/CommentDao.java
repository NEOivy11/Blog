package com.neo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neo.common.DbObject;
import com.neo.entity.Atricle;
import com.neo.entity.Comment;

public class CommentDao {

	public Comment add(Comment com){
		Connection cn = null;
		PreparedStatement st = null;
		
		try {
			//3. 连接
			cn = DbObject.getConnection();
			
			//4. 执行SQL语句
			String sql = "insert into Comment (UserName,ArtId,ComContent,Available) values (?,?,?,?)"; 
			st = cn.prepareStatement(sql);
			
			st.setString(1, com.getUserName());
			st.setInt(2, com.getArtId());
			st.setString(3, com.getComContent());
			
			st.setString(4, com.getAvailable());

			int ret = st.executeUpdate();
			System.out.println("添加评论");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5. 关闭连接
			DbObject.close(cn, st, null);
		}
		return com;
	}
	
	public List<Comment> findByArt(int artId) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Comment> list = new ArrayList<Comment>();
		
		try {
			//3. 连接
			cn = DbObject.getConnection();
			
			//4. 执行SQL语句
			String sql = "select * from Comment where ArtId = ? order by ComDate DESC"; 
			st = cn.prepareStatement(sql);
			st.setInt(1, artId);
			
			rs = st.executeQuery();
			while (rs.next()){
				Comment com = new Comment();
				com.setCommentId(rs.getInt("CommentId"));
				com.setUserName(rs.getString("UserName"));
				com.setComContent(rs.getString("ComContent"));
				com.setArtId(rs.getInt("ArtId"));
				com.setComDate(rs.getDate("ComDate"));
				com.setParentCom(rs.getInt("ParentCom"));

				list.add(com);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5. 关闭连接
			DbObject.close(cn, st, rs);
		}
		return list;
	}
	
	public Comment rep(Comment com){
		Connection cn = null;
		PreparedStatement st = null;
		
		try {
			//3. 连接
			cn = DbObject.getConnection();
			
			//4. 执行SQL语句
			String sql = "insert into Comment (UserName,ArtId,ComContent,Available,ParentCom) values (?,?,?,?,?)"; 
			st = cn.prepareStatement(sql);
			
			st.setString(1, com.getUserName());
			st.setInt(2, com.getArtId());
			st.setString(3, com.getComContent());
			
			st.setString(4, com.getAvailable());
			
			st.setInt(5, com.getParentCom());
			
			
			int ret = st.executeUpdate();
			System.out.println("回复评论");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5. 关闭连接
			DbObject.close(cn, st, null);
		}
		return com;
	}
	
	public String findParentUser(int parentCom) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		
		try {
			//3. 连接
			cn = DbObject.getConnection();
			
			//4. 执行SQL语句
			String sql = "select distinct Nickname from Comment c1 join Comment c2 on c1.CommentId = c2.ParentCom join LoginUser on LoginUser.UserName = c1.UserName where c1.CommentId = ? "; 
			st = cn.prepareStatement(sql);
			st.setInt(1, parentCom);
			
			
			rs = st.executeQuery();
			
			if(rs.next()){
				
				String Nickname = rs.getString("Nickname");

				return Nickname;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5. 关闭连接
			DbObject.close(cn, st, rs);
		}
		return null;
	}
	
	public String findParentCom(int commentId) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		
		try {
			//3. 连接
			cn = DbObject.getConnection();
			
			//4. 执行SQL语句
			String sql = "select distinct c1.ComContent from Comment c1 join Comment c2 on c1.CommentId = c2.ParentCom where c2.CommentId = ? "; 
			st = cn.prepareStatement(sql);
			st.setInt(1, commentId);
			
			
			rs = st.executeQuery();
			
			if(rs.next()){
			
				String parentCom = rs.getString("ComContent");
				
				return parentCom;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5. 关闭连接
			DbObject.close(cn, st, rs);
		}
		return null;
	}
}
