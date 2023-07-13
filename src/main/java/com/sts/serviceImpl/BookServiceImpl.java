package com.sts.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.entity.Book;

import com.sts.exception.ResourceNotFoundException;
import com.sts.payload.BookDto;

import com.sts.repositories.BookRepository;
import com.sts.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public BookDto addBook(BookDto dto) {
		Book book = this.bookRepo.save(this.mapper.map(dto, Book.class));
		return this.mapper.map(book, BookDto.class);
	}

	@Override
	public List<BookDto> getAllBook() {
		List<Book> list = this.bookRepo.findAll();
		List<BookDto> collect = list.stream().map(p -> this.mapper.map(p, BookDto.class)).collect(Collectors.toList());
		
		return collect;
	}

	@Override
	public BookDto getBookById(int id) {
		Book book = this.bookRepo
				.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Book", "id", id));
		return this.mapper.map(book, BookDto.class);
	}

	@Override
	public BookDto updateBook(BookDto dt, int id) {
		Book book = this.bookRepo
				.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Book", "id", id));
		
		book.setBook_name(dt.getBook_name());
		book.setBook_authorname(dt.getBook_authorname());
		
		book = this.bookRepo.save(book);
		
		return this.mapper.map(book, BookDto.class);
	}

	@Override
	public void deleteBook(int id) {
		Book book = this.bookRepo
				.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Book", "id", id));
		this.bookRepo.delete(book);
	}

}
