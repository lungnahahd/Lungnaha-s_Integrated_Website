package com.Lungnaha.IntegratedWebsite.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.jasper.tagplugins.jstl.core.If;

public class JDBCUtil {
	public static Connection getConnection() { // 데이터베이스에 연결을 시도하는 함수
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/springboard?serverTimezone=Asia/Seoul","root","khd10810");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(PreparedStatement stmt, Connection conn) { // stmt는 sql 명령어를 실행시키는 객체
		if (stmt != null) {
			try {
				if(!stmt.isClosed()) stmt.close();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				stmt = null;
			}
		}
		
		if(conn != null) {
			try {
				if(!conn.isClosed()) conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
		}
	}
	
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) { // rs는 sql문 실행 결과를 담는 객체
		if(rs != null) {
			try {
				if(!rs.isClosed()) rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				rs = null;
			}
		}
		
		if (stmt != null) {
			try {
				if(!stmt.isClosed()) stmt.close();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				stmt = null;
			}
		}
		
		if(conn != null) {
			try {
				if(!conn.isClosed()) conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
		}
	}
	
}
