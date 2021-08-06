package com.library.app.book;

/**
 * @author SaranBayi
 *
 */

public class BookUser {
	private String UserName;
	private int id;
	public BookUser() {
		
	}
	public BookUser(String UserName, int id) {
		super();
		this.UserName = UserName;
		this.id = id;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		this.UserName = userName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
