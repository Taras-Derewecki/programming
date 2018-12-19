package Bookstore.Service.impl;


import Bookstore.Model.Book;
import Bookstore.Repository.BookRepository;
import Bookstore.Repository.impl.BookRepositoryimpl;
import Bookstore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    //
    //  Instance Data

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAllBooks();
    }

    @Override
    public Book findBookById(Long bookId) {
        return bookRepository.findBookById(bookId);
    }

    @Override
    public List<Book> findAllBooksFiltered(String filterName) {
        return bookRepository.findAllBooksFiltered(filterName);
    }

    @Override
    public Book addBook(String bookName, String publisher, String price, String iSBN, String genre, String publishDate) {
        Book temp = null;
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        try{
            temp = bookRepository.addBook( bookName, publisher, Double.valueOf(price),
                    Long.parseLong(iSBN), Book.Genre.valueOf(genre), df.parse(publishDate));
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        return  temp;
    }

    @Override
    public void deleteBook(Long bookId) {
         bookRepository.deleteBook(bookId);
    }

    @Override
    public Book editBook (Long bookId, String bookName, String publisher, String price, String iSBN, String genre, String publishDate) {
        Book temp = null;
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        try{
            temp = bookRepository.editbook(bookId, bookName, publisher, Double.parseDouble(price),

                    Long.parseLong(iSBN), Book.Genre.valueOf(genre), df.parse(publishDate));
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        return  temp;
    }
//
//    public GameServiceImpl() {
//        this.gameRepository = new GameRepositoryImpl();
//    }
}

