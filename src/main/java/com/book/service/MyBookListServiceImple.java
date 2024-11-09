package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.model.MyBookList;
import com.book.repository.MyBookRepo;

@Service
public class MyBookListServiceImple implements MyBookListService {

	@Autowired
	private MyBookRepo myBookRepo;
	
	
	public void saveMyBook(MyBookList myBook)
	{
		myBookRepo.save(myBook);
	}


	@Override
	public List<MyBookList> getAllMyBooks() {
		
		return myBookRepo.findAll();
	}


	@Override
	public void deleteById(int id) {
		myBookRepo.deleteById(id);
	}
}
