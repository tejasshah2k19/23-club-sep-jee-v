package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static void openConnection() {

		try {
			// driver load
			Class.forName("com.mysql.cj.jdbc.Driver");//type4 -> no need to load driver

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sepjee23", "root", "root");
			if(con != null) {
				System.out.println("dbConnected => "+con);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DbConnection.openConnection();
		
	}
}
