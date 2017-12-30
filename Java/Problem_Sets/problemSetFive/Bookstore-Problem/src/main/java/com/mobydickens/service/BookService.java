/**
 * Created by Taras on 11/20/2016.
 */

package com.mobydickens.service;

import com.mobydickens.model.Book;
import com.mobydickens.model.Genre;

import java.util.List;

public interface BookService
{
    List<Book> findAll();
    List<Book> findByBookName(String bookName);
    Book findById(Integer id);
    void addBook(Book book);
    void deleteBookById(Integer id);
    void editBook(Integer id, String title, Long isbn, String author, Integer month, Integer day, Integer year, Genre genre, Double price);
//    void deleteBook(Book book);
}
