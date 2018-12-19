package Bookstore.Controller.api;

import Bookstore.Model.Book;
import Bookstore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
@RestController
public class ApiController {

    @Autowired
    private BookService bookService;

    @GetMapping("/api/books")
    public List<Book> findAllBooks() {
        return bookService.findAllBooks();
    }
}
