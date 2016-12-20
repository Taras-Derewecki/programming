/**
 * Created by Taras on 11/20/2016.
 */

package com.mobydickens.repository.impl;

import com.mobydickens.model.Book;
import com.mobydickens.model.Genre;
import com.mobydickens.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository
{

    private List<Book> books = new ArrayList<>();

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public List<Book> findByBookName(String bookName)
    {
        List<Book> bookList = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(bookName.toLowerCase())) {
                bookList.add(book);
            }
        }
        return bookList;
    }

    @Override
    public Book findById(Integer id)
    {
        for (Book b : books)
        {
            if (b.getBookID() == id) {return b;}
        }
        return null;
    }

        @Override
        public void addBook(Book book)
        {
            Integer maxId = 0;

            for (Book b : books)
            {
                if (b.getBookID() > maxId) {maxId = b.getBookID();}
            }

            book.setBookID(maxId + 1);
//            book.setBookID(1);
            books.add(book);
    }

    @Override
    public void deleteBookById(Integer id)
    {
        Book foundBook = null;
        for (Book book : books) {
            if (book.getBookID() == id) {foundBook = book;}
        }
        if (foundBook != null) {
            books.remove(foundBook);
        }
    }

    @Override
    public void editBook(Integer id, String title, Long isbn, String author, Integer month, Integer day, Integer year, Genre genre, Double price)
    {
        Book foundBook = null;

        for (Book book : books)
        {
            if (book.getBookID() == id) {foundBook = book;}
        }

        if (foundBook != null)
        {
            foundBook.setTitle(title);
            foundBook.setIsbn(isbn);
            foundBook.setAuthor(author);
            foundBook.setMonth(month);
            foundBook.setDay(day);
            foundBook.setYear(year);
            foundBook.setGenre(genre);
            foundBook.setPrice(price);
        }
    }
}