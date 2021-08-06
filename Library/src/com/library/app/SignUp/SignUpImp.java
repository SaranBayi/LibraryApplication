package com.library.app.SignUp;

/**
 * @author SaranBayi
 *
 */

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

@WebServlet("/SignUpImp")
public class SignUpImp extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AtomicInteger id = new AtomicInteger(0);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Connection con = DB.getDB();
		int phn = Integer.parseInt(req.getParameter("phn"));
		String uname = req.getParameter("num");
		String eid = req.getParameter("eid");
		String pd = req.getParameter("pd");
		String cpd = req.getParameter("cpd");
		String role = req.getParameter("radioLib");
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
						if (role.equals("librarian")) {
							pre.setString(5, "librarian");
						} else {
							pre.setString(5, "user");
						}
						pre.executeUpdate();
						System.out.println("success inside signup page");
						RequestDispatcher rd = req.getRequestDispatcher("SignUpSuccess.jsp");
						rd.include(req, resp);
					} else {
						RequestDispatcher rd = req.getRequestDispatcher(
								"signup.jsp?message=The Entered UserName already Exist. Try with new UserName");
						rd.include(req, resp);

					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("signup.jsp?message=Entered Passwords are not same");
				rd.include(req, resp);
			}
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("SignUpFail2.jsp");
			rd.include(req, resp);
		}
	}

}
