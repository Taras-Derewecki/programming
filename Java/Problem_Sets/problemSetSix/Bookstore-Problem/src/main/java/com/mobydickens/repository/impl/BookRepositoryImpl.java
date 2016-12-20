/**
 * Created by Taras on 11/20/2016.
 */

package com.mobydickens.repository.impl;

import com.mobydickens.jpa.BookCrudRepository;
import com.mobydickens.model.Book;
import com.mobydickens.model.Genre;
import com.mobydickens.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository
{

//    private List<Book> books = new ArrayList<>();

    private BookCrudRepository bookCrudRepository;

    @Override
//    public List<Book> findAll()
    public Iterable<Book> findAll()
    {
//        return books;

        return bookCrudRepository.findAll();
    }

    @Override
    public Iterable<Book> findByBookName(String bookName)
    {
        List<Book> bookList = new ArrayList<>();
//        for (Book book : books)

//            if (book.getTitle().toLowerCase().contains(bookName.toLowerCase()))
//            {
//                bookList.add(book);
//            }

        try
        {
            for (Book book : bookCrudRepository.findByName(bookName)) {
                if (book.getTitle().toLowerCase().contains(bookName.toLowerCase()))
                {
                    bookList.add(book);
                }
            }
        }

        catch (Exception ignore)
        {
            // query not found
//            ignore.printStackTrace();
        }

        return bookList;
    }

    @Override
    public Book findById(Integer id)
    {
//        for (Book b : books)
//        {
//            if (b.getBookID() == id) {return b;}
//        }

        try
        {
            Book book = bookCrudRepository.findOne(id);
            return book;
        }

        catch (Exception ignore)
        {
            // exception thrown if book not found!!!
        }

        return null;
    }

        @Override
        public Book addBook(Book book)
        {
//            Integer maxId = 0;
//
//            for (Book b : books)
//            {
//                if (b.getBookID() > maxId) {maxId = b.getBookID();}
//            }
//
//            book.setBookID(maxId + 1);
////            book.setBookID(1);
//            books.add(book);

            return bookCrudRepository.save(book);
    }

    @Override
    public void deleteBookById(Integer id)
    {
//        Book foundBook = null;
//        for (Book book : books) {
//            if (book.getBookID() == id) {foundBook = book;}
//        }
//        if (foundBook != null) {
//            books.remove(foundBook);
//        }
        bookCrudRepository.delete(id);
    }

    @Override
    public Book editBook(Integer id, String title, Long isbn, String author, Integer month, Integer day, Integer year, Genre genre, Double price)
    {
//        Book foundBook = null;
//
//        for (Book book : books)
//        {
//            if (book.getBookID() == id) {foundBook = book;}
//        }

//        if (foundBook != null)
//        {
//            foundBook.setTitle(title);
//            foundBook.setIsbn(isbn);
//            foundBook.setAuthor(author);
//            foundBook.setMonth(month);
//            foundBook.setDay(day);
//            foundBook.setYear(year);
//            foundBook.setGenre(genre);
//            foundBook.setPrice(price);
//        }

        try
        {
            Book foundBook = bookCrudRepository.findOne(id);
            if (foundBook != null)
            {
                foundBook.setTitle(title);
                foundBook.setPrice(price); // STRING PRICE????
                return bookCrudRepository.save(foundBook);
            }
        }

        catch (Exception ignore) {}

        return null;
    }
}