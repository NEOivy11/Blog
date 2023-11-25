package com.neo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neo.common.DbObject;
import com.neo.entity.Type;

public class TypeDao {
	public Type add(Type type)
	{
		Connection cn=null;
		PreparedStatement st=null;
		
		try {
			cn = DbObject.getConnection();
			
			System.out.println("数据库已经连接！");

			//执行sql语句
			
			String sql="insert into Type(Type, UserName) values(?,?)";
			st = cn.prepareStatement(sql);
			st.setString(1,type.getType());
			st.setString(2, type.getUserName());
			
			int ret=st.executeUpdate();
			System.out.println(ret);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DbObject.close(cn, st, null);				
		}
		return type;
	}
	
	public Type findByType(int typeId, String userName){
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Type t;
		
		//1. 注册数据库驱动
		try {
			cn = DbObject.getConnection();
			
			System.out.println("数据库已经连接hh！");
			
			//4. 执行SQL语句
			String sql = "Select * from Type where TypeId=? and UserName = ?";
			st = cn.prepareStatement(sql);
			
			st.setInt(1, typeId);
			st.setString(2, userName);
			
			rs = st.executeQuery();
			
			if(rs.next()){
				t = new Type();
				//数据库的字段大小写
				t.setTypeId(rs.getInt("TypeId"));
				t.setType(rs.getString("Type"));
				t.setUserName(rs.getString("UserName"));
				
				return t;
			}
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DbObject.close(cn, st, rs);
		}
		return null;
	}
	
	public List<Type> findAll(String userName) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Type> list = new ArrayList<Type>();
		
		try {
			//3. 连接
			cn = DbObject.getConnection();
			
			//4. 执行SQL语句
			String sql = "select * from Type where UserName = ?"; 
			st = cn.prepareStatement(sql);
			st.setString(1, userName);
			
			rs = st.executeQuery();
			while (rs.next()){
				Type type = new Type();
				type.setType(rs.getString("Type"));
				type.setTypeId(rs.getInt("TypeId"));
				list.add(type);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5. 关闭连接
			DbObject.close(cn, st, rs);
		}
		return list;
	}
	
	public Type modifyType(Type type){
		Connection cn = null;
		PreparedStatement st = null;
		
		ResultSet rs = null;
		
		try {
			//3. 连接
			cn = DbObject.getConnection();
			
			
			String sql = "update Type set Type = ? where TypeId = ?"; 
			st = cn.prepareStatement(sql);
			
			st.setString(1, type.getType());
			st.setInt(2, type.getTypeId());
			
			
			int ret = st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5. 关闭连接
			DbObject.close(cn, st, null);
		}
		System.out.println("成功修改类型");
		return type;
	}
	
	public boolean delete(Type type){
		Connection cn=null;
		PreparedStatement st=null;
		ResultSet rs=null;

		try {
			cn=DbObject.getConnection();
		
			//4.执行sql语句
			String sql="delete from Type where TypeId = ? and TypeId not in (select TypeId from Atricle)";
			st = cn.prepareStatement(sql);

			st.setInt(1, type.getTypeId());

			int rowsAffected = st.executeUpdate();
			System.out.println(rowsAffected);

	        return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//5.关闭连接
			DbObject.close(cn, st, rs);
		}
		return false;
	}
}
