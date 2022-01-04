package com.tb.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tb.bookclub.models.Book;
import com.tb.bookclub.repositories.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepo;
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	public Book saveBook(Book b) {
		return bookRepo.save(b);
	}
	
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	public Book findOneBook(Long id) {
		Optional<Book>optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
	
	
	
}
