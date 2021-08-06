package com.library.app.book;
/**
 * @author SaranBayi
 *
 */

public class Book {
	private int id;
	private String title;
	private String author;
	private String genre;
	private boolean isAvailable=true;
	private long ISBN;

	public Book(int id, String title, String author, String genre,long ISBN) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.ISBN = ISBN;
	}

	public Book() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
		this.ISBN = iSBN;
	}
	

}
