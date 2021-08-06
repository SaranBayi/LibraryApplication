package com.euphoric.service.serviceIMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.euphoric.model.Book;
import com.euphoric.service.BookService;

public class BookServiceImpl implements BookService {

	AtomicInteger id = new AtomicInteger(0);

	static List<Book> books = new ArrayList<Book>();

	public BookServiceImpl() {
		books = generateDummyBooks();
	}

	private List<Book> generateDummyBooks() {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book(id.incrementAndGet(), "Java", "Herbert"));
		books.add(new Book(id.incrementAndGet(), "c++", "Balagurusamy"));
		books.add(new Book(id.incrementAndGet(), "c", "Dennis"));
		return books;
	}

	@Override
	public void addBook(Book book) {
		book.setId(id.incrementAndGet());
		books.add(book);

	}

	@Override
	public void updateBook(Book book) {
		for (Book b : books) {
			if (b.getId().equals(book.getId())) {
				int index = books.indexOf(b);
				books.set(index, book);
				break;
			}
		}

	}

	@Override
	public Book findBookById(Integer id) {
		for (Book b : books) {
			if (b.getId().equals(id)) {
				return b;
			}
		}
		return null;
	}

	@Override
	public void deleteBookById(Integer id) {
		for (Book b : books) {
			if (b.getId().equals(id)) {
				books.remove(b);
				break;
			}
		}

	}

	@Override
	public List<Book> listAllBooks() {
		return books;
	}

	@Override
	public void deleteAllBooks() {
		books.clear();

	}

}
