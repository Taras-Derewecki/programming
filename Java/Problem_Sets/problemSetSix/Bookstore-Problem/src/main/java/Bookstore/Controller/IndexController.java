package Bookstore.Controller;

import Bookstore.Model.Book;
import Bookstore.Service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@Slf4j
public class IndexController {

    //
    //  Instance Data

    @Autowired
    private BookService bookService;
//
//    public IndexController() {
//        this.gameService = new GameServiceImpl();
//    }

    //
    //  Index Page
    @GetMapping(value = "/")
    public String indexPage(Model model) {
        List<Book> bookList = bookService.findAllBooks();
        model.addAttribute("bookList", bookList);
        return "index";
    }

    @PostMapping(value = "/")
    public String filteredIndexPage(@RequestParam String filterName, Model model) {
        List<Book> bookList = bookService.findAllBooksFiltered(filterName);
        model.addAttribute("bookList", bookList);
        return "index";
    }

    @GetMapping (value = "/admin/books/view")
    public String filteredIndexPage(Model model) {
        List<Book> bookList = bookService.findAllBooks();
        model.addAttribute("bookList", bookList);
        return "view";
    }
    //
    //  Filter

    //

    @GetMapping(value = "/books/add")
    public String addBook() {
        return "addbook";
    }

    @PostMapping(value = "/books/add")
    public String addBook(@RequestParam String bookName, @RequestParam String author, @RequestParam String bookPrice,
                          @RequestParam String iSBN, @RequestParam String genre, @RequestParam String publishDate) {
        bookService.addBook(bookName, author, bookPrice, iSBN, genre, publishDate);
        return "redirect:/";
    }

    //
    //  Edit Game
    @GetMapping(value = "/books/edit/{bookId}")
    public String editBook(@PathVariable(value = "bookId") Long bookId, Model model) {

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        if (bookId == null || bookId <= 0) {
            throw new IllegalStateException("Book ID is required!");
        }

        //
        //  Attempt to find the game
        Book book = bookService.findBookById(bookId);
        if (book != null) {
            model.addAttribute("bookName", book.getBookName());
            model.addAttribute("author", book.getAuthor());
            model.addAttribute("price", book.getBookPrice());
            model.addAttribute("iSBN", book.getiSBN());
            model.addAttribute("genre", book.getGenre());
            model.addAttribute("publishDate", df.format(book.getPublishDate()));
        }

        return "editbook";
    }

    @PostMapping(value = "/books/edit")
    public String editBook(@RequestParam String bookId, @RequestParam String bookName, @RequestParam String author,
                           @RequestParam String bookPrice, @RequestParam String iSBN,
                           @RequestParam String genre, @RequestParam String publishDate) {

        if ( Long.parseLong(bookId) <= 0) {
            throw new IllegalStateException("Book ID is required!");
        }
        Book book = bookService.editBook(Long.parseLong(bookId), bookName, author, bookPrice, iSBN, genre, publishDate);
        log.debug("Book edit successful with ID " + book.getBookId());
        return "redirect:/";
    }

    //
    //  Remove Game
    @GetMapping(value = "/books/delete/{bookId}")
    public String deleteBook(@PathVariable(value = "bookId") Long bookID) {

        if (bookID == null || bookID <= 0) {
            throw new IllegalStateException("Book ID is required!");
        }

        // delete the game by id
        bookService.deleteBook(bookID);

        return "redirect:/";
    }

}








