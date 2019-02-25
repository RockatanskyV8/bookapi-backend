package com.bookstoresystem.spring.service;

import java.util.List;

import com.bookstoresystem.spring.model.Book;

public interface BookService {
	//save the record
	long save(Book book);
	//get single record
	Book get(long id);
	//get all the records
	List<Book> list();
	//update the record
	void update(long id, Book book);
	//Delete a record
	void delete(long id);
}
