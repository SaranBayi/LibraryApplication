package com.library.app.implemenations;
/**
 * @author SaranBayi
 *
 */

import java.util.List;

import com.library.app.book.Book;

public interface Useraccess {

	public void addToCart(int id, String name);

	public void removeFromCart(int id, String name);

	public List<Book> list();

	public List<Book> listOfUser();

}
