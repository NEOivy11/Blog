package com.neo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.neo.entity.User;
import com.neo.common.DbObject;


public class UserDao {
	public User add(User user)
		{
			Connection cn=null;
			PreparedStatement st=null;
			
			try {
				cn = DbObject.getConnection();
				
				System.out.println("数据库已经连接！");
				
				//执行sql语句
				
				String sql="insert into LoginUser(Nickname,UserName,passwo,FullName,sex,birthday,phone,email,wxid,descip,available,adminUser,regDate,modiDate) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				st = cn.prepareStatement(sql);
				st.setString(1,user.getNickname());
				st.setString(2,user.getUserName());
				st.setString(3,user.getPassword());
				st.setString(4,user.getFullName());
				st.setString(5,user.getSex());
				st.setString(6,user.getBirthday());
				st.setInt(7,user.getPhone());
				st.setString(8,user.getEmail());
				st.setString(9,user.getWxid());
				st.setString(10,user.getDescip());
				st.setString(11, user.getAvailable());
				st.setString(12, user.getAdminUser());
				Date currentDate = new Date();
				st.setDate(13, new java.sql.Date(currentDate.getTime())); // 设置注册日期
				st.setDate(14, new java.sql.Date(currentDate.getTime()));
				
				int ret=st.executeUpdate();
				System.out.println(ret);
				System.out.println("数据库里:"+user.getAvailable());
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				DbObject.close(cn, st, null);
					
			}
			return user;
		}
	
	
	public User findByUserName(String userName){
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		User user;
		
		//1. 注册数据库驱动
		try {
			cn = DbObject.getConnection();
			
			System.out.println("数据库已经连接hh！");
			
			//4. 执行SQL语句
			String sql = "Select * from LoginUser where UserName=?";
			st = cn.prepareStatement(sql);
			
			st.setString(1, userName);
			
			rs = st.executeQuery();
			
			if(rs.next()){
				user = new User();
				//数据库的字段大小写
				user.setNickname(rs.getString("Nickname"));
				user.setUserName(rs.getString("UserName"));
				user.setFullName(rs.getString("FullName"));
				user.setPassword(rs.getString("passwo"));
				user.setSex(rs.getString("sex"));
				user.setBirthday(rs.getString("birthday"));
				user.setPhone(rs.getInt("phone"));
				user.setEmail(rs.getString("email"));
				user.setWxid(rs.getString("wxid"));
				user.setDescip(rs.getString("descip"));
				user.setAvailable(rs.getString("available"));
				user.setAdminUser(rs.getString("adminUser"));
				user.setRegDate(rs.getDate("regDate"));
				user.setModiDate(rs.getDate("modiDate"));
				
				return user;
			}
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DbObject.close(cn, st, rs);
		}
		return null;
	}
	
	public User update(User user) {
		Connection cn = null;
		PreparedStatement st = null;
		
		try {
			//3. 连接
			cn = DbObject.getConnection();
			
			//4. 执行SQL语句
			String sql = "update LoginUser set NickName=?,FullName=?, sex=?, birthday=?, phone=?, email=?, wxid=?, descip=?, modiDate=? where UserName=?"; 
			st = cn.prepareStatement(sql);
			
			st.setString(1, user.getNickname());
			st.setString(2, user.getFullName());
			st.setString(3, user.getSex());
			st.setString(4, user.getBirthday());
			st.setInt(5, user.getPhone());
			st.setString(6, user.getEmail());
			st.setString(7, user.getWxid());
			st.setString(8, user.getDescip());
			Date currentDate = new Date();
			st.setDate(9, new java.sql.Date(currentDate.getTime()));
			st.setString(10, user.getUserName());
			
			
			int ret = st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5. 关闭连接
			DbObject.close(cn, st, null);
		}
		
		return user;		
	}
		
	public User alterPassword(User user){
		Connection cn = null;
		PreparedStatement st = null;
		
		ResultSet rs = null;
		
		try {
			//3. 连接
			cn = DbObject.getConnection();
			
			
			String sql = "update LoginUser set passwo = ? where UserName = ?"; 
			st = cn.prepareStatement(sql);
			
			st.setString(1, user.getPassword());
			st.setString(2, user.getUserName());
			
			
			int ret = st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5. 关闭连接
			DbObject.close(cn, st, null);
		}
		
		return user;
	}


	public List<User> findAll() {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		
		try {
			//3. 连接
			cn = DbObject.getConnection();
			
			//4. 执行SQL语句
			String sql = "select * from LoginUser"; 
			st = cn.prepareStatement(sql);
			
			rs = st.executeQuery();
			while (rs.next()){
				User user = new User();
				user.setNickname(rs.getString("Nickname"));
				user.setUserName(rs.getString("UserName"));
				user.setFullName(rs.getString("FullName"));
				user.setPassword(rs.getString("passwo"));
				user.setSex(rs.getString("sex"));
				user.setBirthday(rs.getString("birthday"));
				user.setPhone(rs.getInt("phone"));
				user.setEmail(rs.getString("email"));
				user.setWxid(rs.getString("wxid"));
				user.setDescip(rs.getString("descip"));
				user.setAvailable(rs.getString("available"));
				user.setAdminUser(rs.getString("adminUser"));
				user.setRegDate(rs.getDate("regDate"));
				user.setModiDate(rs.getDate("modiDate"));
				
				list.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5. 关闭连接
			DbObject.close(cn, st, rs);
		}
		return list;
	}
	
	public User AlterAvai(User user){
		Connection cn = null;
		PreparedStatement st = null;
		
		ResultSet rs = null;
		
		try {
			//3. 连接
			cn = DbObject.getConnection();
			
			
			String sql = "update LoginUser set available = ? where UserName = ?"; 
			st = cn.prepareStatement(sql);
			
			if(user.getAvailable().equals("1")){
				st.setString(1, "0");
			}
			else{
				st.setString(1, "1");
			}
			st.setString(2, user.getUserName());
			
			int ret = st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5. 关闭连接
			DbObject.close(cn, st, null);
		}
		
		return user;
	}


	public User AlterAdmin(User user) {
		Connection cn = null;
		PreparedStatement st = null;
		
		ResultSet rs = null;
		
		try {
			//3. 连接
			cn = DbObject.getConnection();
			
			
			String sql = "update LoginUser set adminUser = ? where UserName = ?"; 
			st = cn.prepareStatement(sql);
			
			if(user.getAdminUser().equals("1")){
				st.setString(1, "0");
			}
			else{
				st.setString(1, "1");
			}
			st.setString(2, user.getUserName());
			
			int ret = st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5. 关闭连接
			DbObject.close(cn, st, null);
		}
		
		return user;
	}
	
	public String findNickname(String userName) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		
		try {
			//3. 连接
			cn = DbObject.getConnection();
			
			//4. 执行SQL语句
			String sql = "select distinct Nickname from LoginUser where UserName = ? "; 
			st = cn.prepareStatement(sql);
			st.setString(1, userName);
			
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
	
	
	public List<User> findUser(String find) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		
		try {
			//3. 连接
			cn = DbObject.getConnection();
			
			//4. 执行SQL语句
			String sql = "select * from LoginUser where UserName like ? or Nickname like ? or descip like ?";

			st = cn.prepareStatement(sql);
			st.setString(1, "%" + find + "%");
			st.setString(2, "%" + find + "%");
			st.setString(3, "%" + find + "%");
			
			rs = st.executeQuery();
			while (rs.next()){
				User user = new User();
				user.setNickname(rs.getString("Nickname"));
				user.setUserName(rs.getString("UserName"));
				user.setFullName(rs.getString("FullName"));
				user.setPassword(rs.getString("passwo"));
				user.setSex(rs.getString("sex"));
				user.setBirthday(rs.getString("birthday"));
				user.setPhone(rs.getInt("phone"));
				user.setEmail(rs.getString("email"));
				user.setWxid(rs.getString("wxid"));
				user.setDescip(rs.getString("descip"));
				user.setAvailable(rs.getString("available"));
				user.setAdminUser(rs.getString("adminUser"));
				user.setRegDate(rs.getDate("regDate"));
				user.setModiDate(rs.getDate("modiDate"));
				
				list.add(user);
				System.out.println(user.getUserName());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5. 关闭连接
			DbObject.close(cn, st, rs);
		}
		return list;
	}
	
	public List<User> findAllAvail() {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		
		try {
			//3. 连接
			cn = DbObject.getConnection();
			
			//4. 执行SQL语句
			String sql = "select * from LoginUser where Available = '1'"; 
			
			st = cn.prepareStatement(sql);
			
			rs = st.executeQuery();
			while (rs.next()){
				User user = new User();
				user.setNickname(rs.getString("Nickname"));
				user.setUserName(rs.getString("UserName"));
				user.setFullName(rs.getString("FullName"));
				user.setPassword(rs.getString("passwo"));
				user.setSex(rs.getString("sex"));
				user.setBirthday(rs.getString("birthday"));
				user.setPhone(rs.getInt("phone"));
				user.setEmail(rs.getString("email"));
				user.setWxid(rs.getString("wxid"));
				user.setDescip(rs.getString("descip"));
				user.setAvailable(rs.getString("available"));
				user.setAdminUser(rs.getString("adminUser"));
				user.setRegDate(rs.getDate("regDate"));
				user.setModiDate(rs.getDate("modiDate"));
				
				list.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5. 关闭连接
			DbObject.close(cn, st, rs);
		}
		return list;
	}

}
