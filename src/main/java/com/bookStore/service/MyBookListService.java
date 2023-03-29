package com.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.MyBookList;
import com.bookStore.repository.MyBookRepository;

@Service
public class MyBookListService 
{
	@Autowired
	private MyBookRepository repo;
	
	public void saveMyBooks(MyBookList book)
	{
		repo.save(book);
	}
	
	public List<MyBookList> getAllMyBookList()
	{
		return repo.findAll();
	}
	
	public void deleteMyBookById(Integer id)
	{
		repo.deleteById(id);
	}
}
