package com.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.Book;
import com.bookStore.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository repo;	
	
	public void save(Book book)
	{
		repo.save(book);
	}
	
	public List<Book> getAll(){
		return repo.findAll();
	}
	
	public Book getById(int id) {
		return repo.findById(id).get();
	}
	
	public void deleteBookById(int id) {
	   repo.deleteById(id);
	}
}
