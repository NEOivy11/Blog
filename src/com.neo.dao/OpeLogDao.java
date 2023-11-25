package com.neo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neo.common.DbObject;
import com.neo.entity.OpeLog;

public class OpeLogDao {
	public void add(String userName,String changeUser, String logContent){
		Connection cn = null;
		PreparedStatement st = null;
		
		try {
			//3. 连接
			cn = DbObject.getConnection();
			
			//4. 执行SQL语句
			String sql = "insert into OpeLog (UserName,changeUser,logContent,logDate) values (?,?,?,?)"; 
			st = cn.prepareStatement(sql);
			
			st.setString(1, userName);
			st.setString(2, changeUser);
			st.setString(3, logContent);

	        Date currentDate = new Date();
	        System.out.println(currentDate);
			st.setDate(4, new java.sql.Date(currentDate.getTime()));

			int ret = st.executeUpdate();
			System.out.println("添加操作日志");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5. 关闭连接
			DbObject.close(cn, st, null);
		}
	}
	
	public List<OpeLog> findAll() {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<OpeLog> list = new ArrayList<OpeLog>();
		
		try {
			//3. 连接
			cn = DbObject.getConnection();
			
			//4. 执行SQL语句
			String sql = "select * from OpeLog"; 
			st = cn.prepareStatement(sql);
			
			rs = st.executeQuery();
			while (rs.next()){
				OpeLog log = new OpeLog();
				log.setUserName(rs.getString("UserName"));
				log.setChangeUser(rs.getString("changeUser"));
				log.setLogContent(rs.getString("logContent"));
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
