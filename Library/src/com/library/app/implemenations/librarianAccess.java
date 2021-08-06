package com.library.app.implemenations;

/**
 * @author SaranBayi
 *
 */

import java.util.List;

import com.library.app.book.Book;
import com.library.app.book.BookLogin;
import com.library.app.book.BookUser;
import com.library.app.login.user;

public interface librarianAccess {

	public void add(Book b);

	public Book find(int id);
	
	public user findUser(int id);

	public void delete(int id);

	public List<Book> list();

	public void edit(Book b);
	
	public void userEdit(user u);

	public List<BookUser> listOfUsers();

	public List<user> loginlist();
	
	public List<BookLogin> saran();
	
	public List<user> profile(String UserName);
	
	public void changePassword(String UserName,String oldp,String newp,String cnewp);

}
