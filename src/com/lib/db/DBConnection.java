package com.lib.db;

import java.sql.*;

public class DBConnection {

	private static String driverName = "com.mysql.jdbc.Driver";
	//private static String driverURL = "jdbc:mysql://localhost:3306/doclib?useUnicode=true"
	//		+ "&characterEncoding=gbk&useSSL=false";
	private static String driverURL = "jdbc:mysql://localhost:3306/doclib?useUnicode=true&useSSL=false";
	private static String userName="root";
	private static String password ="123456";
	Connection conn = null;
	public Connection getConn() {
		return conn;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnection db = new DBConnection();
		String sql = "select * from doc";
		try {
			
			Connection ct = db.getConn();
			PreparedStatement ps = ct.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				System.out.println("test: "+rs.getString(3));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeConn();
		}
	}
	public void closeConn()
	{
		try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
   //此处不要在抛出异常了，感觉抛出异常不容易debug
	public DBConnection() 
	{
		try {
			Class.forName(driverName);
			conn =  DriverManager.getConnection(driverURL, userName, password);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
