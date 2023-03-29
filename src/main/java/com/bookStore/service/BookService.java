package com.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.Book;
import com.bookStore.repository.BookRepositroy;

@Service
public class BookService 
{
	@Autowired
	private BookRepositroy repo;
	
	public void saveBook(Book b)
	{
		repo.save(b);
	}
	
	public List<Book> getAllBooks()
	{
		return repo.findAll();
	}
	
	public Book getBookById(Integer id)
	{
		return repo.findById(id).get();
	}
	
	public void deleteById(Integer id)
	{
		repo.deleteById(id);
	}
}
