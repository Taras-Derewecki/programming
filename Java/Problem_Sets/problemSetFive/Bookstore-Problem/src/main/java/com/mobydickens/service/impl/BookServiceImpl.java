/**
 * Created by Taras on 11/20/2016.
 */

package com.mobydickens.service.impl;

import com.mobydickens.model.Book;
import com.mobydickens.model.Genre;
import com.mobydickens.repository.BookRepository;
import com.mobydickens.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService
{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {return bookRepository.findAll();}

    @Override
    public List<Book> findByBookName(String bookName) {return bookRepository.findByBookName(bookName);}


    @Override
    public Book findById(Integer id) {return bookRepository.findById(id);}

    @Override
    public void addBook(Book book) {bookRepository.addBook(book);}

    @Override
    public void deleteBookById(Integer id) {bookRepository.deleteBookById(id);}

    @Override
    public void editBook(Integer id, String title, Long isbn, String author, Integer month, Integer day, Integer year, Genre genre, Double price)
    {
        bookRepository.editBook(id, title, isbn, author, month, day, year, genre, price);
    }
}
