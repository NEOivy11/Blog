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

public class ArtDao {
	public Atricle addA(Atricle art)
	{
		Connection cn=null;
		PreparedStatement st=null;
		
		try {
			cn = DbObject.getConnection();
			
			System.out.println("数据库已经连接！");

			//执行sql语句
			
			String sql="insert into Atricle(ArtTitle,Content,UserName,TypeId,PubDate,ModiDate) values(?,?,?,?,?,?)";
			st = cn.prepareStatement(sql);
			st.setString(1,art.getArtTitle());
			//st.setString(2,art.getType());
			st.setString(2,art.getContent());
			st.setString(3,art.getUserName());
			st.setInt(4,art.getTypeId());
			//st.setInt(5,art.getArtId());
			Date currentDate = new Date();
			st.setDate(5, new java.sql.Date(currentDate.getTime())); // 设置注册日期
			st.setDate(6, new java.sql.Date(currentDate.getTime()));
			
			int ret=st.executeUpdate();
			System.out.println(ret);
			System.out.println("添加文章！");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbObject.close(cn, st, null);				
		}
		return art;
	}
	
	public List<Atricle> findByType(int typeId, String userName) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Atricle> list = new ArrayList<Atricle>();
		
		try {
			//3. 连接
			cn = DbObject.getConnection();
			
			//4. 执行SQL语句
			String sql = "select * from Atricle where TypeId = ? and userName = ?"; 
			st = cn.prepareStatement(sql);
			st.setInt(1, typeId);
			st.setString(2, userName);
			
			rs = st.executeQuery();
			while (rs.next()){
				Atricle art = new Atricle();
				art.setTypeId(rs.getInt("TypeId"));
				art.setArtTitle(rs.getString("ArtTitle"));
				art.setContent(rs.getString("Content"));
				art.setArtId(rs.getInt("ArtId"));
				art.setPubDate(rs.getDate("PubDate"));
				art.setModiDate(rs.getDate("ModiDate"));

				list.add(art);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5. 关闭连接
			DbObject.close(cn, st, rs);
		}
		return list;
	}
	
	public String findType(int typeId) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		//Atricle art = new Atricle();
		
		try {
			//3. 连接
			cn = DbObject.getConnection();
			
			//4. 执行SQL语句
			String sql = "select distinct Type.Type from Type join Atricle on Type.TypeId = Atricle.TypeId where Atricle.TypeId = ? "; 
			st = cn.prepareStatement(sql);
			st.setInt(1, typeId);
			//st.setString(2, userName);
			
			rs = st.executeQuery();
			
			if(rs.next()){
				//art = new Atricle();
				//数据库的字段大小写
				//art.setArtId(rs.getInt("ArtId"));
				//art.setArtTitle(rs.getString("ArtTitle"));
				//art.setContent(rs.getString("Content"));
				//art.setType(rs.getString("Type"));
				
				String Type = rs.getString("Type");
				
				return Type;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5. 关闭连接
			DbObject.close(cn, st, rs);
		}
		return null;
	}
		
	public List<Atricle> findByTitle(String artTitle) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Atricle> list = new ArrayList<Atricle>();
		
		try {
			//3. 连接
			cn = DbObject.getConnection();
			
			//4. 执行SQL语句
			String sql = "select * from Atricle where ArtTitle like ? "; 
			st = cn.prepareStatement(sql);
			st.setString(1, "%" + artTitle + "%");
			
			rs = st.executeQuery();
			while (rs.next()){
				Atricle art = new Atricle();
				art.setTypeId(rs.getInt("TypeId"));
				art.setArtTitle(rs.getString("ArtTitle"));
				art.setContent(rs.getString("Content"));
				art.setArtId(rs.getInt("ArtId"));
				art.setPubDate(rs.getDate("PubDate"));
				art.setModiDate(rs.getDate("ModiDate"));

				list.add(art);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5. 关闭连接
			DbObject.close(cn, st, rs);
		}
		return list;
	}
		
		public Atricle findByArtId(int artId){
			Connection cn = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			Atricle art;
			
			//1. 注册数据库驱动
			try {
				cn = DbObject.getConnection();
				
				System.out.println("数据库已经连接hh！");
				
				//4. 执行SQL语句
				String sql = "Select * from Atricle where ArtId=?";
				st = cn.prepareStatement(sql);
				
				st.setInt(1, artId);
				
				rs = st.executeQuery();
				
				if(rs.next()){
					art = new Atricle();
					//数据库的字段大小写
					art.setArtId(rs.getInt("ArtId"));
					art.setArtTitle(rs.getString("ArtTitle"));
					art.setContent(rs.getString("Content"));
					art.setTypeId(rs.getInt("TypeId"));
					art.setPubDate(rs.getDate("PubDate"));
					art.setModiDate(rs.getDate("ModiDate"));
					
					return art;
				}
				 
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				DbObject.close(cn, st, rs);
			}
			return null;
		}
		
		public List<Atricle> findByUserName(String userName) {
			Connection cn = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			List<Atricle> list = new ArrayList<Atricle>();
			
			try {
				//3. 连接
				cn = DbObject.getConnection();
				
				//4. 执行SQL语句
				String sql = "select * from Atricle where UserName = ?"; 
				st = cn.prepareStatement(sql);
				st.setString(1, userName);
				
				rs = st.executeQuery();
				while (rs.next()){
					Atricle art = new Atricle();
					art.setTypeId(rs.getInt("TypeId"));
					art.setArtTitle(rs.getString("ArtTitle"));
					art.setContent(rs.getString("Content"));
					art.setArtId(rs.getInt("ArtId"));
					art.setPubDate(rs.getDate("PubDate"));
					art.setModiDate(rs.getDate("ModiDate"));

					list.add(art);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				//5. 关闭连接
				DbObject.close(cn, st, rs);
			}
			return list;
		}
		
		
		public Atricle modifyContent(Atricle art){
			Connection cn = null;
			PreparedStatement st = null;
			
			ResultSet rs = null;
			
			try {
				//3. 连接
				cn = DbObject.getConnection();
				
				
				String sql = "update Atricle set Content = ?, ArtTitle = ?, TypeId = ?, ModiDate = ? where ArtId = ?"; 
				st = cn.prepareStatement(sql);
				
				st.setString(1, art.getContent());
				st.setString(2, art.getArtTitle());
				st.setInt(3, art.getTypeId());
				st.setInt(4, art.getArtId());
				Date currentDate = new Date();
				st.setDate(5, new java.sql.Date(currentDate.getTime()));
				
				int ret = st.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				//5. 关闭连接
				DbObject.close(cn, st, null);
			}
			System.out.println("成功修改文章");
			return art;
		}
		
		public List<Atricle> findAll() {
			Connection cn = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			List<Atricle> list = new ArrayList<Atricle>();
			
			try {
				//3. 连接
				cn = DbObject.getConnection();
				
				//4. 执行SQL语句
				String sql = "select * from Atricle"; 
				st = cn.prepareStatement(sql);
				
				rs = st.executeQuery();
				while (rs.next()){
					Atricle art = new Atricle();
					art.setTypeId(rs.getInt("TypeId"));
					art.setArtTitle(rs.getString("ArtTitle"));
					art.setContent(rs.getString("Content"));
					art.setArtId(rs.getInt("ArtId"));
					art.setPubDate(rs.getDate("PubDate"));
					art.setModiDate(rs.getDate("ModiDate"));

					list.add(art);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				//5. 关闭连接
				DbObject.close(cn, st, rs);
			}
			return list;
		}
		
		public void delete(Atricle art){
			Connection cn=null;
			PreparedStatement st=null;
			ResultSet rs=null;

			try {
				cn=DbObject.getConnection();
			
				//4.执行sql语句
				String sql="delete from Atricle where ArtId=?";
				st = cn.prepareStatement(sql);

				st.setInt(1, art.getArtId());

				int ret=st.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				//5.关闭连接
				DbObject.close(cn, st, rs);
			}
		}
	}
