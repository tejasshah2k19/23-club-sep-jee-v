package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.UserBean;
import com.util.DbConnection;

public class UserDao {

	// query

	// insert

	public void addUser(UserBean userBean) {

		try {
			// open connection
			Connection con = DbConnection.openConnection();
			// query -> run
			// Statement -> sql
			// PreparedStatement -> sql
			// CallableStatement -> plsql

			PreparedStatement pstmt = con
					.prepareStatement("insert into users (firstName,email,password) values (?,?,?)");
			pstmt.setString(1, userBean.getFirstName());
			pstmt.setString(2, userBean.getEmail());
			pstmt.setString(3, userBean.getPassword());

			// run
			int row = pstmt.executeUpdate(); // insert update delete
			if (row != 0) {
				System.out.println("record inserted => " + row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<UserBean> getAllUsers() {
		ArrayList<UserBean> users = new ArrayList<UserBean>();

		try {

			Connection con = DbConnection.openConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users");
			ResultSet rs = pstmt.executeQuery();// read only
			// rs => 10 record -> 10row -> firstName userId email password

			while (rs.next()) { // first record
				String firstName = rs.getString("firstName");
				String email = rs.getString("email");
				String password = rs.getString("password");
				Integer userId = rs.getInt("userId");

				UserBean userBean = new UserBean();
				userBean.setFirstName(firstName);
				userBean.setEmail(email);
				userBean.setPassword(password);
				userBean.setUserId(userId);

				users.add(userBean);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return users;
	}
	
	public void deleteUser(int userId) {
		try {
			Connection con = DbConnection.openConnection();
			PreparedStatement pstmt = con
					.prepareStatement("delete from users where userId = ? ");
			pstmt.setInt(1, userId);
			int row = pstmt.executeUpdate(); // insert update delete
			if (row != 0) {
				System.out.println("record deleted => " + row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
