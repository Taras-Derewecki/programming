/**
 * Created by Taras on 11/20/2016.
 */

package com.mobydickens.controller.api;

import com.mobydickens.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookRestController
{
    @Autowired
    protected com.mobydickens.service.BookService BookService;

    @RequestMapping("/api/books")
    public Iterable<Book> getAllBooks(){return BookService.findAll();}
}
