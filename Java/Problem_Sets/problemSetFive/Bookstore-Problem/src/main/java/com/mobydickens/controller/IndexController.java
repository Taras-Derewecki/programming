/**
 * Created by Taras on 11/20/2016.
 */

package com.mobydickens.controller;

import com.mobydickens.model.Book;
import com.mobydickens.model.Genre;
import com.mobydickens.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController
{
    @Autowired
    private BookService bookService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home(Model model)
    {
        model.addAttribute("books", bookService.findAll());
        return "/home";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String searchForm(@RequestParam(value = "bookName") String bookName, Model model)
    {
        model.addAttribute("books",bookService.findByBookName(bookName));
        return "/home";
    }

    @RequestMapping(value="/admin-books-add", method=RequestMethod.GET)
    public String viewBookAddPage() {
        return "admin-books-add";
    }

    @RequestMapping(value="/admin-books-add", method = RequestMethod.POST)
    public String addBook
        (
            @RequestParam(value="bookName") String bookName,
            @RequestParam(value="bookPrice") String bookPrice,
            @RequestParam(value ="monthPublished") String monthPublished,
            @RequestParam(value ="dayPublished") String dayPublished,
            @RequestParam(value ="yearPublished") String yearPublished,
            @RequestParam(value ="author") String author,
            @RequestParam(value ="isbn") String isbn,
            @RequestParam(value ="genre") String genre
        )
    {

        Book book = new Book
        (
                bookService.findAll().size() + 1,
           Integer.parseInt(monthPublished), Integer.parseInt(dayPublished),
           Integer.parseInt(yearPublished), bookName, author, Long.parseLong(isbn),
           Genre.valueOf(genre), Double.parseDouble(bookPrice)
        );

        bookService.addBook(book);
        return "redirect:/";
    }

    @RequestMapping(value = "/books/admin-books-edit{id}" , method = RequestMethod.GET)
    public String editBook(@PathVariable Integer id, Model model)
    {
        Book book = bookService.findById(id);
        if (book != null)
        {
            model.addAttribute("bookId", book.getBookID());
            model.addAttribute("bookName", book.getTitle());
            model.addAttribute("monthPublished", book.getMonth());
            model.addAttribute("dayPublished", book.getDay());
            model.addAttribute("yearPublished", book.getYear());
            model.addAttribute("author", book.getAuthor());
            model.addAttribute("isbn", book.getIsbn());
            model.addAttribute("genre", book.getGenre());
            model.addAttribute("bookPrice", book.getPrice());

            return "admin-books-edit";
        }

        else {return "home";}
    }

    @RequestMapping(value = "/books/admin-books-edit", method = RequestMethod.POST)
    public String saveBookEdit
            (
                    @RequestParam(value = "bookId") Integer id,
                    @RequestParam(value="bookName") String bookName,
                    @RequestParam(value="bookPrice") Double bookPrice,
                    @RequestParam(value ="monthPublished") Integer monthPublished,
                    @RequestParam(value ="dayPublished") Integer dayPublished,
                    @RequestParam(value ="yearPublished") Integer yearPublished,
                    @RequestParam(value ="author") String author,
                    @RequestParam(value ="isbn") Long isbn,
                    @RequestParam(value ="genre") Genre genre
            )
    {
        bookService.editBook(id, bookName, isbn, author, monthPublished, dayPublished,
                             yearPublished, genre, bookPrice);
        return "redirect:/";
    }

    @RequestMapping("/admin-books-delete{id}")
    public String deleteBook(@PathVariable Integer id)
    {
        bookService.deleteBookById(id);
        return "redirect:/";
    }
}
