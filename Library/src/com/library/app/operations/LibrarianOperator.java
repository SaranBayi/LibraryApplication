package com.library.app.operations;

/**
 * @author SaranBayi
 *
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.app.book.Book;
import com.library.app.book.BookLogin;
import com.library.app.implemenations.DB;
import com.library.app.implemenations.librarianAccessImpl;
import com.library.app.login.user;

@WebServlet("/LibrarianOperator")
public class LibrarianOperator extends HttpServlet {
	Connection con = DB.getDB();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String ADD = "/librarian/add.jsp";
	private static final String EDIT = "/librarian/edit.jsp";
	private static final String LIST = "/librarian/list.jsp";
	private static final String LISTU = "/librarian/listOfUsers.jsp";
	private static final String LOGINL = "/librarian/loginlist.jsp";
	private static final String PROFILE = "/profile.jsp";
	private static final String CHANGEPD = "/changePassword.jsp";
	private static final String LL = "LibrarianLogin.jsp?message=Password changed Succesfully !  Please login Again";
	private static final String UEDIT = "/librarian/userEdit.jsp";
	librarianAccessImpl lai;

	public LibrarianOperator() {
		lai = new librarianAccessImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		String navigation = "";
		HttpSession s = req.getSession();
		if (action.equals("add")) {
			navigation = ADD;
		} else if (action.equals("edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			Book books = lai.find(id);
			req.setAttribute("books", books);
			navigation = EDIT;
		} else if (action.equals("userEdit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			user us = lai.findUser(id);
			req.setAttribute("users", us);
			navigation = UEDIT;

		} else if (action.equals("delete")) {
			int id = Integer.parseInt(req.getParameter("id"));
			lai.delete(id);
			List<Book> books = lai.list();
			req.setAttribute("books", books);
			navigation = LIST;
		} else if (action.equals("listU")) {
			List<BookLogin> users = lai.saran();
			req.setAttribute("users", users);
			navigation = LISTU;

		} else if (action.equals("loginlist")) {
			List<user> users = lai.loginlist();
			req.setAttribute("users", users);
			navigation = LOGINL;
		} else if (action.equals("profile")) {

			String UserName = (String) s.getAttribute("num");
			List<user> profile = lai.profile(UserName);
			req.setAttribute("profile", profile);
			navigation = PROFILE;
		} else if (action.equals("changepd")) {
			navigation = CHANGEPD;
		}

		else {

			List<Book> books = lai.list();
			req.setAttribute("books", books);
			navigation = LIST;
		}
		RequestDispatcher rd = req.getRequestDispatcher(navigation);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		String navigation = "";
		List<Book> books;
		List<user> uu;
		List<user> pp;
		List<BookLogin> rr;
		HttpSession s = req.getSession();
		Book book = new Book();
		user us = new user();
		if (action.equals("add")) {
			book.setTitle(req.getParameter("title"));
			book.setAuthor(req.getParameter("author"));
			book.setGenre(req.getParameter("genre"));
			book.setISBN(Long.parseLong(req.getParameter("ISBN")));

			int b = Integer.parseInt(req.getParameter("ISBN"));
			Statement sta;
			try {
				sta = con.createStatement();

				ResultSet rs = sta.executeQuery("select * from Euphoric.library");
				int count = 0;
				while (rs.next()) {
					if (b == (rs.getInt(5))) {
						count++;
					}
				}
				if (count == 0) {
					lai.add(book);
					books = lai.list();
					req.setAttribute("books", books);
					navigation = LIST;

				}
				else {
					navigation = "/librarian/add.jsp?message=The Entered ISBN already Exist. Try with new ISBN number";
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (action.equals("listU")) {
			rr = lai.saran();
			req.setAttribute("users", rr);
			navigation = LISTU;

		} else if (action.equals("loginlist")) {
			uu = lai.loginlist();
			req.setAttribute("users", uu);
			navigation = LOGINL;
		} else if (action.equals("profile")) {
			String UserName = (String) s.getAttribute("num");
			pp = lai.profile(UserName);
			req.setAttribute("profile", pp);
			navigation = PROFILE;
		} else if (action.equals("changepd")) {
			String UserName = (String) s.getAttribute("num");
			String oldp = req.getParameter("oldp");
			String newp = req.getParameter("newp");
			String cnewp = req.getParameter("cnewp");
			lai.changePassword(UserName, oldp, newp, cnewp);
			navigation = LL;
		} else if (action.equals("userEdit")) {
			us.setUserName(req.getParameter("num"));
			us.setPHNumber(Integer.parseInt(req.getParameter("phn")));
			us.setEMAIL(req.getParameter("eid"));
			us.setPassword(req.getParameter("pd"));
			String m = req.getParameter("rol");
			if (m.equals("librarian")) {
				us.setRole("librarian");
			} else {
				us.setRole("user");
			}
			us.setId(Integer.parseInt(req.getParameter("id")));
			lai.userEdit(us);
			uu = lai.loginlist();
			req.setAttribute("users", uu);
			navigation = LOGINL;
		}

		else {

			book.setTitle(req.getParameter("title"));
			book.setAuthor(req.getParameter("author"));
			book.setGenre(req.getParameter("genre"));
			book.setISBN(Long.parseLong(req.getParameter("ISBN")));
			book.setId(Integer.parseInt(req.getParameter("id")));
			lai.edit(book);
			books = lai.list();
			req.setAttribute("books", books);
			navigation = LIST;
		}

		RequestDispatcher rd = req.getRequestDispatcher(navigation);
		rd.forward(req, resp);
	}

}
