package cn.liuy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.liuy.entity.Book;
import cn.liuy.mapper.BookMapper;
import cn.liuy.service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookMapper bs;
	
	public List<Book> findAllBook() {
		// TODO Auto-generated method stub
		return bs.findAllBook();
	}

}
