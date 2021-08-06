package com.library.app.operations;
/**
 * @author SaranBayi
 *
 */

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.app.book.Book;
import com.library.app.implemenations.UserAccessImpl;
@WebServlet("/UserOperator")
public class UserOperator extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String LIST = "/user/list_of_library.jsp";
	private static final String LIST_OF_USER = "/user/list_of_user.jsp";

	UserAccessImpl uai;

	public UserOperator() {
		uai = new UserAccessImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		String navigation = "";
		HttpSession hp = req.getSession();
		if (action.equals("add")) {
			int id = Integer.parseInt(req.getParameter("id"));
			String name =(String) hp.getAttribute("num");
			uai.addToCart(id, name);
			List<Book> books = uai.listOfUser();
			req.setAttribute("books", books);
			navigation = LIST;
		} else if (action.equals("delete")) {
			int id = Integer.parseInt(req.getParameter("id"));
			String name =(String) hp.getAttribute("num");
			uai.removeFromCart(id, name);
			List<Book> books = uai.listOfUser();
			req.setAttribute("books", books);
			navigation = LIST_OF_USER;
		} else if (action.equals("listU")) {
			List<Book> books = uai.listOfUser();
			req.setAttribute("books", books);
			navigation = LIST_OF_USER;
		} else {
			List<Book> books = uai.list();
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
		Book book = new Book();
		if (action.equals("list")) {
			book.setTitle(req.getParameter("title"));
			book.setAuthor(req.getParameter("author"));
			book.setGenre(req.getParameter("genre"));
			book.setISBN(Long.parseLong(req.getParameter("ISBN")));
			book.setId(Integer.parseInt(req.getParameter("id")));
			books = uai.list();
			req.setAttribute("books", books);
			navigation = LIST;
		}
		else {
			book.setTitle(req.getParameter("title"));
			book.setAuthor(req.getParameter("author"));
			book.setGenre(req.getParameter("genre"));
			book.setISBN(Long.parseLong(req.getParameter("ISBN")));
			book.setId(Integer.parseInt(req.getParameter("id")));
			books = uai.listOfUser();
			req.setAttribute("books", books);
			navigation = LIST_OF_USER;
			
		}
		RequestDispatcher rd = req.getRequestDispatcher(navigation);
		rd.forward(req, resp);
	}

}
