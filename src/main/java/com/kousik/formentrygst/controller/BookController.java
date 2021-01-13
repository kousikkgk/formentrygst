package com.kousik.formentrygst.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kousik.formentrygst.dao.ServiceResponse;
import com.kousik.formentrygst.model.Book;

@RestController
public class BookController {

	List<Book> bookStore=new ArrayList<>();
	
	
	
	@PostMapping("/saveBook")
	public ResponseEntity<Object> addBook(@RequestBody Book book){
		bookStore.add(book);
		ServiceResponse<Book> response=new ServiceResponse<Book>("success",book);
		return new ResponseEntity<Object>(response,HttpStatus.OK);
	}
	
	
	@GetMapping("/getAllBooks")
	public ResponseEntity<Object> getAllBook(){
		ServiceResponse<List<Book>> response=new ServiceResponse<>("success",bookStore);
		return new ResponseEntity<Object>(response,HttpStatus.OK);
	}
}
