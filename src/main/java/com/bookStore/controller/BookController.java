package com.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookListService;

@Controller
public class BookController 
{
	
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookListService bookListService;
	
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister()
	{
		return "bookRegister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAllBooks()
	{
		List<Book> list = service.getAllBooks();
		
		//ModelAndView m = new ModelAndView();
		//m.setViewName("bookList");
		//m.addObject("book",list);
		return new ModelAndView("bookList","book",list);
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b)
	{
		service.saveBook(b);
		return "redirect:/available_books";
	}
	
	@GetMapping("/my_books")
	public String getMyBooks(Model model)
	{
		List<MyBookList> list = bookListService.getAllMyBookList();
		model.addAttribute("book",list);
		return "myBooks";
	}
	
	@GetMapping("/myList/{id}")
	public String getMyList(@PathVariable("id") Integer id)
	{
		Book b = service.getBookById(id);
		MyBookList mb = new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		bookListService.saveMyBooks(mb);
		return "redirect:/my_books";
	}
	
	@GetMapping("/editBook/{id}")
	public String editBook(@PathVariable("id")Integer id,Model model)
	{
		Book b = service.getBookById(id);
		model.addAttribute("book",b);
		return "bookEdit";
	}
	
	@GetMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id")Integer id)
	{
		service.deleteById(id);
		return "redirect:/available_books";
	}
}
