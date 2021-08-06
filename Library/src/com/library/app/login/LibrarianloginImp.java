package com.library.app.login;

/**
 * @author SaranBayi
 *
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.app.implemenations.DB;

/**
 * Servlet implementation class LibrarianloginImp
 */
@WebServlet("/LibrarianloginImp")
public class LibrarianloginImp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection con = DB.getDB();
		HttpSession session = req.getSession(true);

		String num = req.getParameter("num");
		String pd = req.getParameter("pd");
		session.setAttribute("num", num);
		session.setAttribute("pd", pd);
		try {
			PreparedStatement pre = con.prepareStatement("select * from euphoric.login where UserName = ?");
			pre.setString(1, num);
			ResultSet set = pre.executeQuery();
			if (set.next()) {
				String DBPD = set.getString(5);
				if (DBPD.equals(pd)) {
					if (set.getString(6).equals("librarian")) {
						RequestDispatcher rd = req.getRequestDispatcher("librarian/Librarianopen.jsp");
						rd.include(req, resp);
					} else if (set.getString(6).equals("user")) {
						RequestDispatcher rd = req.getRequestDispatcher("user/Useropen.jsp");
						rd.include(req, resp);
					}
				}else {
					RequestDispatcher rd = req.getRequestDispatcher("LibrarianLogin.jsp?message=username or password are invalid");
					rd.include(req, resp);
				}

			} else {
				RequestDispatcher rd = req.getRequestDispatcher("LibrarianLogin.jsp?message=username or password are invalid");
				rd.include(req, resp);
			}
			session.setAttribute("role", set.getString(6));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
