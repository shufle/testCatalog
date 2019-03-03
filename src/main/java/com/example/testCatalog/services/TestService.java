package com.example.testCatalog.services;

import com.example.testCatalog.dao.BookDao;
import com.example.testCatalog.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    public BookDao bookDao;

    public List<BookInfo> listByAuthor(String author) {
        return bookDao.listBooksFilteredByAuthor(author);
    }

    public List<BookInfo> listByTitle (String title) {
        return bookDao.listBooksFilteredByTitle(title);
    }
}
