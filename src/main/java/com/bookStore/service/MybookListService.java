package com.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.MyBookList;
import com.bookStore.repository.MyBookListRepository;

@Service
public class MybookListService {
	@Autowired
	MyBookListRepository mybooks;
	
	public void save(MyBookList b) {
		mybooks.save(b);
	}
	
	public List<MyBookList> getAll(){
		return mybooks.findAll();
	}
	
	public void deleteBookById(int id) {
		mybooks.deleteById(id);
	}
}
