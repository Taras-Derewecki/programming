/**
 * Created by Taras on 11/20/2016.
 */

package com.mobydickens.bootstrap;

import com.mobydickens.model.ApplicationUser;
import com.mobydickens.model.Book;
import com.mobydickens.model.Genre;
import com.mobydickens.repository.ApplicationUserRepository;
import com.mobydickens.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DatabaseLoader implements ApplicationListener<ContextRefreshedEvent>
{
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        // Create Books
        Book b1 = new Book(5, 25, 2011, "Fifty Shades of Grey", "E. L. James", 345803485, Genre.ROMANCE, 19.99);
        bookRepository.addBook(b1);

        Book b2 = new Book(4, 18, 2000, "Dracula", "Bram Stoker", 486454010, Genre.HORROR, 10.99);
        bookRepository.addBook(b2);

        Book b3 = new Book(3, 1, 1981, "Moby-Dick", "Herman Melville", 553213113, Genre.CLASSICS, 19.99);
        bookRepository.addBook(b3);

        Book b4 = new Book(7, 1, 1992, "Learning Java", "James O'Reilly", 596002858, Genre.NONFICTION, 44.99);
        bookRepository.addBook(b4);


        // Add users
        ApplicationUser admin = new ApplicationUser("admin", "123456", Boolean.TRUE);
        applicationUserRepository.createApplicationUser(admin);

        ApplicationUser norm = new ApplicationUser("norm", "654321", Boolean.FALSE);
        applicationUserRepository.createApplicationUser(norm);
    }
}