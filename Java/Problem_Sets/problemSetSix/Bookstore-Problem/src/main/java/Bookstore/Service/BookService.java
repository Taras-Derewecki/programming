package Bookstore.Service;



import Bookstore.Model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();
    Book findBookById(Long bookId);

    List<Book> findAllBooksFiltered(String filterName);

    Book addBook(String bookName, String author, String price, String iSBN, String genre, String publishDate);

    void deleteBook(Long bookId);

    Book editBook(Long bookId, String bookName, String author, String price, String iSBN, String genre, String publishDate);
}

