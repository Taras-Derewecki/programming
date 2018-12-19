package Bookstore.Repository.impl;

import Bookstore.Model.ApplicationUser;
import Bookstore.Application;
import Bookstore.jpa.ApplicationUserCrudRepository;
import com.google.common.collect.MoreCollectors;
import org.springframework.beans.factory.annotation.Autowired;
import Bookstore.Repository.ApplicationUserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ApplicationUserRepositoryImpl implements ApplicationUserRepository {

    //
    //  Instance Data
   // private List<ApplicationUser> applicationUserList = new ArrayList<>();
    @Autowired
    private ApplicationUserCrudRepository applicationUserCrudRepository;



    @Override
    public ApplicationUser findUserByUserName(String username) {
    //    return applicationUserList.stream()
     //           .filter(user -> user.getUsername().equalsIgnoreCase(username))
      //          .collect(MoreCollectors.onlyElement());
        return applicationUserCrudRepository.findByUsername(username);
    }


    @Override
    public ApplicationUser addUser(String userName, String password, Boolean isAdmin) {
        ApplicationUser user = new ApplicationUser(userName, password, isAdmin);
       // applicationUserList.add(user);
      //  return user;
        return applicationUserCrudRepository.save(user);

    }
}

