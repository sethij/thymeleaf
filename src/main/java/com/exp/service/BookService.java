package com.exp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.exp.model.Book;
import com.exp.model.BookWrapper;

@Service
public class BookService {
	
	public static Map<Integer, Book> books = new HashMap<Integer, Book>(){{
		put(1,new Book(1,"Games of throne","George R. Martin",new ArrayList<String>(){{
			add("fantasy");
			add("drama");
			add("fiction");
		}} ));
		put(2,new Book(2,"Three muskteers","Ruskin bond",new ArrayList<String>(){{
			add("drama");
			add("fiction");
		}}));
		put(3,new Book(3,"White tiger","Arvind adiga",new ArrayList<String>(){{
			add("non-fiction");
		}}));
		put(4,new Book(4,"The Good, The Bad and The Evil","Mr X, Mr Y",new ArrayList<String>(){{
			add("drama");
			add("fiction");
		}}));
	}}; 
	
	public Map<Integer, Book> findAll(){
		if(!books.isEmpty())
			return books;
		return null;
			
	}
	
	public Book findOne(int id){
		if(books.get(id) != null)
			return books.get(id);
		return null;
	}
	
	public void addToList(Book b){
		books.put(b.getId(), b);
		
	}
	
	public void addBulk(List<Book> booksList){
		for (Book b : booksList) {
			books.put(b.getId(), b);
		}
		
	}

}
