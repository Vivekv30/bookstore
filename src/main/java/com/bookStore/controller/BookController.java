package com.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.service.BookService;
import com.bookStore.service.MybookListService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class BookController {
	
	@Autowired
	BookService service;
	
	@Autowired
	MybookListService myBookListRepo;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String newBook() {
		return "bookRegister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView availableBooks() {
		
//		ModelAndView mav=new ModelAndView();
//		mav.setViewName("availableBooks");
//		mav.addObject("books",service.getAll());
//		return mav;
		//or
		return new ModelAndView("availableBooks","books",service.getAll());
	}
	
	@GetMapping("/my_books")
	public String mybooks(Model model) {	
		List<MyBookList> l= myBookListRepo.getAll();
		model.addAttribute("mybook",l);
		return "mybooks";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Book book){
	
	service.save(book);	
	return "redirect:/available_books";
	}
	
	@RequestMapping("/mylist/{id}")
	public String addtoList(@PathVariable("id")int id) {
		Book b=service.getById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookListRepo.save(mb);
		return "redirect:/my_books";
	}
	
	@RequestMapping("/deleteBook/{id}")
	public String deleteBookById(@PathVariable("id") int id) {
		
		service.deleteBookById(id);
		return "redirect:/available_books";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBookById(@PathVariable("id") int id,Model model) {
		
		Book book=service.getById(id);
		model.addAttribute("book", book);
		return "editBook";
	}
}
