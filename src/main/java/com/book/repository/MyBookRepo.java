package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.model.MyBookList;

public interface MyBookRepo extends JpaRepository<MyBookList, Integer> {

}
