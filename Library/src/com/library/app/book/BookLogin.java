package com.library.app.book;

public class BookLogin {

	private String UserName;
	private int PHNumber;
	private String EMAIL;
	private int id;
	private String title;
	private String author;

	public BookLogin() {
		super();
	}

	public BookLogin(String userName, int pHNumber, String eMAIL, int id, String title, String author) {
		super();
		this.UserName = userName;
		this.PHNumber = pHNumber;
		this.EMAIL = eMAIL;
		this.id = id;
		this.title = title;
		this.author = author;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		this.UserName = userName;
	}

	public int getPHNumber() {
		return PHNumber;
	}

	public void setPHNumber(int pHNumber) {
		this.PHNumber = pHNumber;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		this.EMAIL = eMAIL;
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

}
