package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.model.Books;
import com.book.repository.BookRepo;

@Service
public class BookServiceImple implements BookService {

	@Autowired
	private BookRepo bookRepo;
   
	@Override
	public void getBookToSave(Books book) {
		bookRepo.save(book);
	}

	@Override
	public List<Books> getAllBooks() {
		
		List<Books> all = bookRepo.findAll();
		return all;
	}
	
	public Books getBookById(int id)
	{
		return bookRepo.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		bookRepo.deleteById(id);
		
	}

}
