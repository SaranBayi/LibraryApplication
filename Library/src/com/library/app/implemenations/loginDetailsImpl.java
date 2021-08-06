package com.library.app.implemenations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.library.app.login.user;

public class loginDetailsImpl implements loginDetails {
	Connection con = DB.getDB();

	@Override
	public List<user> loginList() {
		List<user> b = new ArrayList<user>();
		try {
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery("select * from euphoric.login");
			while (rs.next()) {
				if (rs.getString(5).equals("user")) {
					b.add(new user(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

}
