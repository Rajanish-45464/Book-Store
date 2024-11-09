package com.book.service;

import java.util.List;

import com.book.model.Books;

public interface BookService {

	public void getBookToSave(Books book);
	public List<Books> getAllBooks();
	public Books getBookById(int id);
	public void deleteById(int id);
}
