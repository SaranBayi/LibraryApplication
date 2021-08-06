package com.euphoric;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.euphoric.model.Book;
import com.euphoric.service.serviceIMPL.BookServiceImpl;

@Controller
public class BookController {

	BookServiceImpl bsi;

	public BookController() {
		bsi = new BookServiceImpl();
	}

//	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
//	public String addBook(@RequestParam("name") String name, @RequestParam("author") String author, Model m) {
//		Book b = new Book();
//		// ModelAndView mv = new ModelAndView("viewBook");
//		b.setName(name);
//		b.setAuthor(author);
//		bsi.addBook(b);
//		// mv.addObject("books", bsi.listAllBooks());
//		m.addAttribute("books", bsi.listAllBooks());
//		return "viewBook";
//	}

	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("book") Book book, Model m) {
		bsi.addBook(book);
		m.addAttribute("books", bsi.listAllBooks());
		return "viewBook";
	}
	
	@RequestMapping(value = "/addBook2", method = RequestMethod.GET)
	public String addBook2(Model model) {
		model.addAttribute("book", new Book());
		return "addBook";
	}

	@RequestMapping(value = "/viewBook", method = RequestMethod.GET)
	public String viewBook2(Model m) {

		List<Book> books = bsi.listAllBooks();
		m.addAttribute("books", books);

		return "viewBook";

	}

	@RequestMapping(value = "/viewBook", method = RequestMethod.POST)
	public String viewBook(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("author") String author, Model m) {
		Book b = new Book();
		// ModelAndView mv = new ModelAndView("viewBook");
		b.setId(id);
		b.setName(name);
		b.setAuthor(author);
		bsi.updateBook(b);
		// mv.addObject("books", bsi.listAllBooks());
		m.addAttribute("books", bsi.listAllBooks());
		return "viewBook";
	}

	@RequestMapping(value = "/editBook", method = RequestMethod.GET)
	public String editBook(@ModelAttribute("book") Book b, Model m) {
		Book d = bsi.findBookById(b.getId());
		m.addAttribute("books", d);
		return "editBook";
	}

	//@RequestMapping(value = "/editBook", method = RequestMethod.POST)
	//public String editBook2(@RequestParam("id") int id, @RequestParam("name") String name,
		//	@RequestParam("author") String author, Model m) {
		//Book b = new Book();
		// ModelAndView mv = new ModelAndView("viewBook");
		//b.setId(id);
		//b.setName(name);
		//b.setAuthor(author);
		//bsi.updateBook(b);
		// mv.addObject("books", bsi.listAllBooks());
		//m.addAttribute("books", bsi.listAllBooks());
		//return "viewBook";
	//}
	
	@RequestMapping(value = "/editBook", method = RequestMethod.POST)
		public String editBook2(@ModelAttribute("book") Book b, Model m) {
			bsi.updateBook(b);
			// mv.addObject("books", bsi.listAllBooks());
			m.addAttribute("books", bsi.listAllBooks());
			return "viewBook";
		}
	
	@RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
	public String deleteBook(@RequestParam("id") int id, Model m) {
		bsi.deleteBookById(id);
		List<Book> books = bsi.listAllBooks();
		m.addAttribute("books", books);

		return "viewBook";
	}

}
