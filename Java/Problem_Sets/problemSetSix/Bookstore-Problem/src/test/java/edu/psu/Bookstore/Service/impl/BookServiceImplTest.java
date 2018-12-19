package test.java.edu.psu.Bookstore.Service.impl;

import Bookstore.Model.Book;
import Bookstore.Service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Test
    public void test_find_all_books() throws Exception {

        List<Book> bookList = bookService.findAllBooks();
        assertNotNull(bookList);

    }

    @Test
    public void findBookById() throws Exception {

        Book book = bookService.findBookById(2L);
        assertEquals("Destiny 2", book.getBookName());
//        assertEquals((long)1L, (long)game.getGameId());

    }

}
