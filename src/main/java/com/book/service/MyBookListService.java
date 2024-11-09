package com.book.service;

import java.util.List;

import com.book.model.MyBookList;

public interface MyBookListService {

	public void saveMyBook(MyBookList myBook);
	public List<MyBookList> getAllMyBooks();
	public void deleteById(int id);
}
