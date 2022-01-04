package com.tb.bookiboi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tb.bookiboi.models.Author;
import com.tb.bookiboi.models.Book;
import com.tb.bookiboi.repositories.AuthorRepo;
import com.tb.bookiboi.repositories.BookRepo;

@Service
public class BookService {
	
	private final BookRepo bookRepo;
	private final AuthorRepo authRepo;
	public BookService(BookRepo bookRepo, AuthorRepo authRepo) {
		this.bookRepo = bookRepo;
		this.authRepo = authRepo;
	}

	public List<Author>allAuthors(){
		return authRepo.findAll();
	}
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	public Book findBook(Long id) {
		Optional<Book>optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}
	
	public Book updateBook(Book b) {
		return bookRepo.save(b);
	}
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
}
