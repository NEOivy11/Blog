package com.neo.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbObject {
	public static Connection getConnection(){
		Connection cn = null;
		//1. 注册数据库驱动
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			//2. 准备数据库连接串
			String url = "jdbc:sqlserver://localhost;user=neo;password=123456;database=Blog;sendStringParametersAsUnicode=false;characterEncoding=UTF-8";
			
			//3. 连接
			cn = DriverManager.getConnection(url);
			
			return cn;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	public static void close(Connection cn, Statement st, ResultSet rs){
		//5. 关闭连接
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (st != null)
				st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (cn != null)
				cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
