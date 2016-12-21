package com.exp.model;

import java.util.ArrayList;
import java.util.List;

public class BookWrapper {

	private List<Book> bookList;
	
	public BookWrapper() {
		bookList = new ArrayList<Book>();
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	
}
