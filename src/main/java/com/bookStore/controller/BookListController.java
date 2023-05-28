package com.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookStore.service.MybookListService;

@Controller
public class BookListController {

	@Autowired
	MybookListService service;
	
	@RequestMapping("/deleteList/{id}")
	public String deleteListById(@PathVariable("id") int id) {
	
		service.deleteBookById(id);
		return "redirect:/my_books";
	}
}
