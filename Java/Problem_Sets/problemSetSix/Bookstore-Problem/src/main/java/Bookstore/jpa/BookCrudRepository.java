package Bookstore.jpa;

import Bookstore.Model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookCrudRepository extends CrudRepository<Book, Long> {
    List<Book> findByBookName(String filterName);
    Book findBookById(Long bookId);
}

