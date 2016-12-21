package com.exp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exp.model.Book;
import com.exp.model.BookWrapper;
import com.exp.service.BookService;

@Controller

public class BookController {
	
	@Autowired
	BookService service;
	
	@ModelAttribute(name="books")
	 public Map<Integer, Book> findAll(){
		return service.findAll();
	}
	@ModelAttribute(name="category")
	public List<String> listCategories(){
		return new ArrayList<String>(){{
			add("Fiction");
			add("Non-Fiction");
			add("Drama");
			add("Comedy");
			add("Fantasy");
			add("Thriller");
			add("Suspense");
			add("Romance");
			add("Sci-Fi");
			add("Horror");
		}};
	}
	
	
	
	@RequestMapping("/")
	public String showBooks(){
			return "home";	
	}
	
	@RequestMapping("/add")
	public String addBook(Model model){
//		model.addAttribute("book",new Book());
		model.addAttribute("bookWrapper",new BookWrapper());
		return "addBooks";
	}
	
	@RequestMapping(value="/addBook",params="addRow")
	public String addRow(@ModelAttribute(value="bookWrapper") BookWrapper books){
		books.getBookList().add(new Book());
		return "addBooks";
	}
	
	@RequestMapping(value="/addBook",params="removeRow")
	public String removeRow(BookWrapper books, HttpServletRequest request){
		int index = Integer.parseInt(request.getParameter("removeRow"));
		books.getBookList().remove(index);
		return "addBooks";
	}
	
	/*@RequestMapping(value="/addBook",method = RequestMethod.POST)
	public String addBookEntry(@ModelAttribute(value="book") Book book){
		service.addToList(book);
		return "redirect:/";
	}*/
	
	@RequestMapping(value="/addBook",method = RequestMethod.POST)
	public String addBookEntry(@ModelAttribute(value="bookWrapper") BookWrapper books){
		service.addBulk(books.getBookList());
		return "redirect:/";
	}
}
