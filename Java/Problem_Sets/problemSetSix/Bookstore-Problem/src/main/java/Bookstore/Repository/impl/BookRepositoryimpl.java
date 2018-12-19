package Bookstore.Repository.impl;

import Bookstore.Model.Book;
import Bookstore.jpa.BookCrudRepository;
import Bookstore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;


@Repository
public class BookRepositoryimpl implements BookRepository{

    @Autowired
    private BookCrudRepository bookCrudRepository;

    @Override
    public List<Book> findAllBooks(){
        return (List<Book>) bookCrudRepository.findAll();
    }

    @Override
    public Book findBookById(Long bookId){ return bookCrudRepository.findBookById(bookId); }

    @Override
    public  Book addBook(String bookName, String author, Double price, Long iSBN, Book.Genre genre, Date publishDate) {
        Book toAdd = new Book(bookName, author, price, iSBN,genre, publishDate);
        return bookCrudRepository.save(toAdd);
    }

    @Override
    public List<Book> findAllBooksFiltered(String filterName){
        return bookCrudRepository.findByBookName(filterName);
    }

    @Override
    public void deleteBook(Long bookId){ bookCrudRepository.deleteById(bookId); }

    @Override
    public  Book editbook (Long bookId, String bookName, String author, double price, Long iSBN, Book.Genre genre, Date publishDate){
        // find book by id
        Book candidate = bookCrudRepository.findBookById(bookId);

        if (candidate == null)
            return null;

        else {
            candidate.setBookName(bookName);
            candidate.setBookPrice(price);
            candidate.setAuthor(author);
            candidate.setISBN(iSBN);
            candidate.setGenre(genre);
            candidate.setPublishDate(publishDate);
            return bookCrudRepository.save(candidate);
        }
    }
}



