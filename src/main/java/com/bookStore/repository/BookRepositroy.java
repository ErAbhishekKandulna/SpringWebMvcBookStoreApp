package com.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookStore.entity.Book;

public interface BookRepositroy extends JpaRepository<Book, Integer> {

}
