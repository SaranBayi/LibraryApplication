package com.library.app.SignUp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.app.implemenations.DB;
import com.library.app.implemenations.librarianAccessImpl;

/**
 * Servlet implementation class SignUpImp2
 */
@WebServlet("/SignUpImp2")
public class SignUpImp2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AtomicInteger id = new AtomicInteger(0);
	librarianAccessImpl lai;

	public SignUpImp2() {
		lai = new librarianAccessImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection con = DB.getDB();
		int phn = Integer.parseInt(req.getParameter("phn"));
		String uname = req.getParameter("num");
		String eid = req.getParameter("eid");
		String pd = req.getParameter("pd");
		String cpd = req.getParameter("cpd");

		if ((uname != null) && (pd != null)) {
			if (pd.equals(cpd)) {
				try {
					Statement sta = con.createStatement();
					ResultSet rs = sta.executeQuery("select * from Euphoric.login");
					int count = 0;
					while (rs.next()) {
						if (rs.getString(2).equals(uname)) {
							count++;
						}
					}
					if (count == 0) {
						PreparedStatement pre = con.prepareStatement(
								"insert into euphoric.login(UserName,PHNumber,EMAIL,Password,Role) values(?,?,?,?,?)");
						pre.setString(1, uname);
						pre.setInt(2, phn);
						pre.setString(3, eid);
						pre.setString(4, pd);
						pre.setString(5, "user");
						pre.executeUpdate();
						RequestDispatcher rd = req.getRequestDispatcher("SignUpSuccess.jsp");
						rd.include(req, resp);
					} else {
						RequestDispatcher rd = req.getRequestDispatcher(
								"UserSignUp.jsp?message=The Entered UserName already Exist. Try with new UserName");
						rd.include(req, resp);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("UserSignUp.jsp?message=Entered Passwords are not same");
				rd.include(req, resp);
			}
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("SignUpFail2.jsp");
			rd.include(req, resp);
		}

	}

}
