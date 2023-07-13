package com.sts.service;

import java.util.List;

import com.sts.entity.Book;
import com.sts.payload.BookDto;

public interface BookService {
	
	public BookDto addBook(BookDto dto);
	public List<BookDto> getAllBook();
	public BookDto getBookById(int id);
	public BookDto updateBook(BookDto dt , int id);
	public void deleteBook(int id);

}
