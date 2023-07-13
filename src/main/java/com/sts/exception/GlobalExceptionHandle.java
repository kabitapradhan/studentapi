package com.sts.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sts.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandle {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> getResourceNotFoundException(ResourceNotFoundException ex) {
		String message = ex.getMessage();
		ApiResponse api = new ApiResponse(message , false );
		return new ResponseEntity<ApiResponse>(api , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String ,String>> getMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		Map<String , String> mp = new HashMap<>();
		//String msg = ex.getMessage();
		ex.getBindingResult().getAllErrors().forEach(error-> {
			String field = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			mp.put(field, message);
		});
		return new ResponseEntity<Map<String,String>>(mp,HttpStatus.BAD_REQUEST);
	}
	
}
