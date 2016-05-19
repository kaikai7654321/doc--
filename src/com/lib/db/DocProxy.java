package com.lib.db;

import java.sql.*;

public class DocProxy {
    private Connection conn = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public DocProxy()
	{
		DBConnection db = new DBConnection();
		conn = db.getConn();
		
		
	}
	
	
	
	

}
