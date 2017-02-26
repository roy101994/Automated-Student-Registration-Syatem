package com.project.utils;

import java.sql.*;

import com.project.db.DBUtils;

public class MemberUtilsImpl implements MemberUtils {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	@Override
	public boolean authenticate(String email, String password,
			String designation) {
		// TODO Auto-generated method stub
		boolean authenticationStatus = false;

		conn = DBUtils.connectToDb();
		String query = "select * from member where emailid = ? and password = ? and designation = ?;";
		pst = DBUtils.getPreparedStatement(conn, query);
		try {
			pst.setString(1, email);
			pst.setString(2, password);
			pst.setString(3, designation);
			rs = pst.executeQuery();
			if (rs.next()) {
				authenticationStatus = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtils.closeConnections();
		return authenticationStatus;
	}

	@Override
	public boolean changePassword(String email, String password,
			String newPassword) {
		// TODO Auto-generated method stub

		boolean isPasswordChanged = false;
		conn = DBUtils.connectToDb();
		String query = "update member set password = ? where emailid = ? and password = ?;";
		pst = DBUtils.getPreparedStatement(conn, query);
		int val = 0;
		try {

			pst.setString(1, newPassword);
			pst.setString(2, email);
			pst.setString(3, password);
			val = pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (val > 0) {
			isPasswordChanged = true;
		}

		DBUtils.closeConnections();
		return isPasswordChanged;
	}

}
