package com.euphoric;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.euphoric.model.Book;
import com.euphoric.service.serviceIMPL.BookServiceImpl;

public class BookController2 {

	BookServiceImpl bsi;

	public BookController2() {
		bsi = new BookServiceImpl();
	}

	@RequestMapping("/addBook2")
	public ModelAndView showForm() {
		return new ModelAndView("addBook2", "command", new Book());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("books") Book book, @RequestParam("name") String name,
			@RequestParam("author") String author) {
		book.setName(name);
		book.setAuthor(author);
		bsi.addBook(book);
		return new ModelAndView("redirect:/viewBook");
	}

}
