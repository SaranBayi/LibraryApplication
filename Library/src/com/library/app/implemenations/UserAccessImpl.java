package com.library.app.implemenations;

/**
 * @author SaranBayi
 *
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.library.app.book.Book;

public class UserAccessImpl implements Useraccess {

	Connection con = DB.getDB();

	/**
	 * Method to persist the data from library table to User table
	 */
	@Override
	public void addToCart(int id, String name) {

		try {
			PreparedStatement p = con.prepareStatement(
					"insert into Euphoric.User select id,title,author,genre,ISBN from Euphoric.library where id=?");
			p.setInt(1, id);
			p.executeUpdate();
			// PreparedStatement pre= con.prepareStatement("delete from Euphoric.library
			// where id=?");
			// pre.setInt(1, id);
			// pre.executeUpdate();
			PreparedStatement pr = con.prepareStatement("update Euphoric.library set isAvailable=1 where id=?");
			pr.setInt(1, id);
			pr.executeUpdate();
			System.out.println("success inside addToCart");
			PreparedStatement ps = con.prepareStatement(
					"insert into Euphoric.map_table select UserName,u.id from Euphoric.library u cross join Euphoric.login v where ((u.id=?)and(v.UserName=?))");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.executeUpdate();
			System.out.println("success - the join query");
			//PreparedStatement s = con.prepareStatement("insert into euphoric.saran select a.UserName,a.PHNumber,a.EMAIL,c.id,c.title,c.author from euphoric.login a join euphoric.map_table b on a.UserName=? join euphoric.library c on c.id=?");
	        //s.setString(1, name);
	        //s.setInt(2, id);
	        //s.executeUpdate();
	        //System.out.println("successfully inserted into saran");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Method to remove the particular data from User table i.e from Cart
	 */
	@Override
	public void removeFromCart(int id, String name) {
		try {
			PreparedStatement p = con.prepareStatement("select * from Euphoric.User where id=?");
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			if (rs.next()) {
				PreparedStatement pr = con.prepareStatement("update Euphoric.library set isAvailable=0 where id=?");
				pr.setInt(1, id);
				pr.executeUpdate();
				// PreparedStatement pr= con.prepareStatement("insert into Euphoric.library
				// select id,title,author,genre,ISBN from Euphoric.User where
				// Euphoric.User.id=?");
				// pr.setInt(1,id);
				// pr.executeUpdate();
				PreparedStatement s = con.prepareStatement("delete from euphoric.saran where id=?");
				s.setInt(1, id);
				s.executeUpdate();
				System.out.println("success removing from saran");
				PreparedStatement ps= con.prepareStatement("delete from euphoric.map_table where id=?");
			    ps.setInt(1, id);
			    ps.executeUpdate();
			    System.out.println("success deleting from mapping table");
				PreparedStatement pre = con.prepareStatement("delete from Euphoric.User where id=?");
				pre.setInt(1, id);
				pre.executeUpdate();
				System.out.println("success inside removeFromCart");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Method to list all the data from library and to display all the data to User
	 */
	@Override
	public List<Book> list() {
		List<Book> b = new ArrayList<Book>();

		try {
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery("select * from Euphoric.library where isAvailable=0");
			while (rs.next()) {
				b.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * Method to list all the data from User table and show them in My Cart
	 */
	@Override
	public List<Book> listOfUser() {
		List<Book> b = new ArrayList<Book>();

		Statement sta;
		try {
			sta = con.createStatement();
			ResultSet rs = sta.executeQuery("select* from Euphoric.User");
			while (rs.next()) {
				b.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;

	}

}
