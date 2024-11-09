package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.book.model.Books;
import com.book.model.MyBookList;
import com.book.service.BookService;
import com.book.service.MyBookListService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private MyBookListService myBookListService;

	@GetMapping("/")
	public String getHome() {
		return "home";
	}

	@GetMapping("/book_register")
	public String newBookRegister() {
		return "bookRegister";
	}

	@GetMapping("/available_books")
	public ModelAndView getAllBooks() {
		List<Books> list = bookService.getAllBooks();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
		return new ModelAndView("bookList", "book", list);
	}

	@PostMapping("/save")
	public String bookSave(@ModelAttribute Books books) {
		bookService.getBookToSave(books);
		return "redirect:/available_books";
	}

	@GetMapping("/my_books")
	public String getMyBooks(Model model) {

		List<MyBookList> list = myBookListService.getAllMyBooks();
		model.addAttribute("book", list);
		return "myBooks";
	}

	@RequestMapping("/myList/{id}")
	public String getMyBooks(@PathVariable("id") int id) {
		Books b = bookService.getBookById(id);
		MyBookList m = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
		myBookListService.saveMyBook(m);
		return "redirect:/my_books";
	}

	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		Books book = bookService.getBookById(id);
		model.addAttribute("book", book);
		return "editBook";
	}

	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		bookService.deleteById(id);
		return "redirect:/available_books";
	}
}
