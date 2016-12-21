package com.exp.model;

import java.util.List;

public class Book {

	private int id;
	private String name;
	private String authorName;
	private List<String> category;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Book(int id, String name, String authorName, List<String> category) {
		super();
		this.id = id;
		this.name = name;
		this.authorName = authorName;
		this.category = category;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public List<String> getCategory() {
		return category;
	}

	public void setCategory(List<String> category) {
		this.category = category;
	}
	
	
	
}
