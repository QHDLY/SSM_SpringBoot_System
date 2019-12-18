package cn.liuy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.liuy.entity.Book;
import cn.liuy.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookservice;
	
	@RequestMapping("/select")
	public List<Book> selectAllBook()
	{
		System.out.println(111);
		return bookservice.findAllBook();
	}
}
