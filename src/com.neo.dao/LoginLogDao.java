package com.neo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neo.common.DbObject;
import com.neo.entity.LoginLog;

public class LoginLogDao {
	public void add(String userName, String logContent, String ipAdress){
		Connection cn = null;
		PreparedStatement st = null;
		
		try {
			//3. 连接
			cn = DbObject.getConnection();
			
			//4. 执行SQL语句
			String sql = "insert into LoginLog (UserName,logContent,IpAdress,logDate) values (?,?,?,?)"; 
			st = cn.prepareStatement(sql);
			
			st.setString(1, userName);
			st.setString(2, logContent);
	        st.setString(3, ipAdress);
			
	        Date currentDate = new Date();
	        System.out.println(currentDate);
			st.setDate(4, new java.sql.Date(currentDate.getTime()));
			
			Date time = new java.sql.Date(currentDate.getTime());
	        System.out.println(time);
			
			int ret = st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5. 关闭连接
			DbObject.close(cn, st, null);
		}
	}
	
	public List<LoginLog> findAll() {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<LoginLog> list = new ArrayList<LoginLog>();
		
		try {
			//3. 连接
			cn = DbObject.getConnection();
			
			//4. 执行SQL语句
			String sql = "select * from LoginLog"; 
			st = cn.prepareStatement(sql);
			
			rs = st.executeQuery();
			while (rs.next()){
				LoginLog log = new LoginLog();
				log.setUserName(rs.getString("UserName"));
				log.setLogContent(rs.getString("logContent"));
				log.setIpAdress(rs.getString("IpAdress"));
				log.setLogDate(rs.getDate("logDate"));
				
				list.add(log);
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
