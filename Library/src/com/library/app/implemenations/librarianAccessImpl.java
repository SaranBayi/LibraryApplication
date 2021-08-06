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
import java.util.concurrent.atomic.AtomicInteger;

import com.library.app.book.Book;
import com.library.app.book.BookLogin;
import com.library.app.book.BookUser;
import com.library.app.login.user;

public class librarianAccessImpl implements librarianAccess {

	Connection con = DB.getDB();

	AtomicInteger id = new AtomicInteger(0);

	/**
	 * Method to persist the data into the database
	 */
	@Override
	public void add(Book b) {
		try {
			
			
			PreparedStatement pre = con
					.prepareStatement("insert into Euphoric.library(title,author,genre,ISBN) values(?,?,?,?)");
			pre.setString(1, b.getTitle());
			pre.setString(2, b.getAuthor());
			pre.setString(3, b.getGenre());
			pre.setLong(4, b.getISBN());
			pre.executeUpdate();
			System.out.println("success inside add from librarian");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Method to update the data in database
	 */
	@Override
	public void edit(Book b) {
		try {
			PreparedStatement pre = con.prepareStatement("select * from Euphoric.library where id=?");
			pre.setInt(1, b.getId());
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				PreparedStatement p = con
						.prepareStatement("update Euphoric.library set title=?, author=?, genre=?, ISBN=? where id=?");
				p.setString(1, b.getTitle());
				p.setString(2, b.getAuthor());
				p.setString(3, b.getGenre());
				p.setInt(5, rs.getInt(1));
				p.setLong(4, b.getISBN());
				p.executeUpdate();
				System.out.println("success inside Edit");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void userEdit(user u) {
		try {
			PreparedStatement pre = con.prepareStatement("select * from Euphoric.login where id=?");
			pre.setInt(1, u.getId());
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				PreparedStatement p = con.prepareStatement(
						"update Euphoric.login set UserName=?,PHNumber=?,EMAIL=?,Password=?,Role=? where id=?");
				p.setString(1, u.getUserName());
				p.setInt(2, u.getPHNumber());
				p.setString(3, u.getEMAIL());
				p.setString(4, u.getPassword());
				p.setString(5, u.getRole());
				p.setInt(6, rs.getInt(1));
				p.executeUpdate();
				System.out.println("success inside userEdit");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * method to retrieve the data from database using ID
	 */
	@Override
	public Book find(int id) {
		try {
			PreparedStatement pre = con.prepareStatement("select * from Euphoric.library where id=?");
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();
			System.out.println("success");
			if (rs.next()) {
				return new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public user findUser(int id) {
		try {
			PreparedStatement pre = con.prepareStatement("select * from Euphoric.login where id=?");
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				return new user(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * method to delete the record using ID
	 */
	@Override
	public void delete(int id) {
		try {
			PreparedStatement pre = con.prepareStatement("select * from Euphoric.library where id=?");
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				PreparedStatement prep = con.prepareStatement("delete from Euphoric.library where id=?");
				prep.setInt(1, id);
				prep.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Method to list all the data in the database
	 */
	@Override
	public List<Book> list() {
		List<Book> b = new ArrayList<Book>();

		try {
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery("select * from Euphoric.library");
			while (rs.next()) {
				b.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<BookUser> listOfUsers() {
		List<BookUser> b = new ArrayList<BookUser>();
		try {
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery("select * from Euphoric.map_table");
			while (rs.next()) {
				b.add(new BookUser(rs.getString(1), rs.getInt(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<user> loginlist() {
		List<user> b = new ArrayList<user>();
		try {
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery("select * from euphoric.login");
			while (rs.next()) {
				if (rs.getString(6).equals("user")) {
					b.add(new user(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
							rs.getString(6)));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<BookLogin> saran() {
		List<BookLogin> b = new ArrayList<BookLogin>();
		try {
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(
					"select a.UserName,a.PHNumber,a.EMAIL,c.id,c.title,c.author from Euphoric.login a join Euphoric.map_table b on a.UserName=b.UserName join Euphoric.library c on c.id=b.id ");
			while (rs.next()) {
				b.add(new BookLogin(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<user> profile(String UserName) {
		List<user> b = new ArrayList<user>();
		try {
			PreparedStatement s = con.prepareStatement("select * from Euphoric.login a where a.UserName=?");
			s.setString(1, UserName);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				b.add(new user(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public void changePassword(String UserName, String oldp, String newp, String cnewp) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from Euphoric.login a where a.UserName=?");
			ps.setString(1, UserName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (oldp.equals(rs.getString(5))) {
					if (newp.equals(cnewp)) {
						PreparedStatement pss = con
								.prepareStatement("update Euphoric.login set Password=? where UserName=?");
						pss.setString(1, newp);
						pss.setString(2, UserName);
						pss.executeUpdate();
					}
				}
			}
			System.out.println("success inside change password");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
