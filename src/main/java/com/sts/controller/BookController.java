package com.sts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.payload.ApiResponse;
import com.sts.payload.BookDto;
import com.sts.payload.BookDto;
import com.sts.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/add")
	public ResponseEntity<BookDto> addbook(@Valid @RequestBody BookDto dto) {
		
		BookDto book = this.bookService.addBook(dto);
		return new ResponseEntity<BookDto>(book , HttpStatus.CREATED);
	}
	@GetMapping("/all")
	public ResponseEntity<List<BookDto>> getAllbook(){
		List<BookDto> list = this.bookService.getAllBook();
		return new ResponseEntity<List<BookDto>>(list , HttpStatus.FOUND);
	}
	@GetMapping("/{id}")
	public ResponseEntity<BookDto> getbookById(@PathVariable int id) {
		BookDto book = this.bookService.getBookById(id);
		return new ResponseEntity<BookDto>(book , HttpStatus.FOUND);
	}
	@PostMapping("/{id}")
	public ResponseEntity<BookDto> updatebook(@Valid @RequestBody BookDto dto , @PathVariable int id) {
		BookDto book = this.bookService.updateBook(dto, id);
		return new ResponseEntity<BookDto>(book , HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteBook(@PathVariable int id) {
		this.bookService.deleteBook(id);
		
		ApiResponse api = new ApiResponse("Delete book with id:" + id + " Succussfully" , true);
		return new ResponseEntity<ApiResponse>(api , HttpStatus.OK);
	}
	
	

}
