/**
 * Created by Taras on 12/10/2016.
 */


package com.mobydickens.jpa;


import com.mobydickens.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookCrudRepository extends CrudRepository<Book, Integer>
{
    List<Book> findByName(String name);
}
