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
 * Servlet implementation class UserloginImp
 */
@WebServlet("/UserloginImp")
public class UserloginImp extends HttpServlet {
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
			PreparedStatement pre = con.prepareStatement("select * from teja9.userinfo where PHNumber = ?");
			pre.setString(1, num);
			ResultSet set = pre.executeQuery();
			if (set.next()) {
				String DBPD = set.getString(4);
				if (DBPD.equals(pd)) {
					RequestDispatcher rd = req.getRequestDispatcher("Useropen.jsp");
					rd.include(req, resp);
				} else {
					RequestDispatcher rd = req.getRequestDispatcher("Fail.jsp");
					rd.include(req, resp);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
