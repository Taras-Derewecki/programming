package Bookstore.Repository;


import Bookstore.Model.Book;

import java.util.Date;
import java.util.List;

public interface BookRepository {
     List<Book> findAllBooks();
     Book findBookById(Long bookId);
     Book addBook(String bookName, String author, Double price, Long iSBN, Book.Genre genre, Date publishDate);
     List<Book> findAllBooksFiltered(String filterName);
     void deleteBook(Long bookId);
     Book editbook(Long bookId, String bookName, String author, double price, Long iSBN, Book.Genre genre, Date publishDate);
}