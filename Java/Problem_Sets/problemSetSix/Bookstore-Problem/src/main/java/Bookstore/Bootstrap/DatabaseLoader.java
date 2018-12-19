package Bookstore.Bootstrap;

import Bookstore.Model.Book;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import Bookstore.Repository.ApplicationUserRepository;
import Bookstore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {


        //  Add some users!
        applicationUserRepository.addUser("admin", "1234", Boolean.TRUE);
        applicationUserRepository.addUser("user", "pass", Boolean.FALSE);
        applicationUserRepository.addUser("trump", "president", Boolean.FALSE);

        //
        //  Add some books
        DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
       try {

bookRepository.addBook("Harry Potter and the Prisoner of Azkaban","J.K.Rowling & Jim kay",
                    39.99, 978054579L, Book.Genre.scifi, df.parse("10/03/2017"));

            bookRepository.addBook("A Column of Fire",
                    "Ken Follett", 30.99, 978152472L,
                    Book.Genre.Fiction, df.parse("09/12/2017"));

            bookRepository.addBook("Two Kinds of Truth",
                    "Michael Connelly", 37.96, 978031622L,
                    Book.Genre.mystery, df.parse("10/31/2017"));

            bookRepository.addBook("Oathbringer",
                    "Ken Follett", 45.99, 978076539L,
                    Book.Genre.fantasy, df.parse("11/14/2017"));

            bookRepository.addBook("Lincoln's Men: The President and His Private Secretaries",
                    "Daniel Mark Epstein", 60.99, 978006198L,
                    Book.Genre.history, df.parse("01/19/2010"));

            bookRepository.addBook("Twisted Truths",
                    "Rebecca Zanett", 56.99, 978145559L,
                    Book.Genre.romance, df.parse("12/11/2009"));

            bookRepository.addBook("Wings of Fire",
                    "A P J Abdul Kalam", 57.99, 977487699L,
                    Book.Genre.biography, df.parse("05/03/1999"));

            bookRepository.addBook("The Great Gasbag: An A-to-Z Study Guide to Surviving Trump World",
                    "Joy Behar", 10.99, 978006269L,
                    Book.Genre.business, df.parse("10/24/2017"));


        } catch (ParseException e)

        {
            e.printStackTrace();
        }

    }
}
