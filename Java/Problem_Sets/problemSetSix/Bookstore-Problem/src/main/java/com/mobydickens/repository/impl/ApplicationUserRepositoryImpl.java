/**
 * Created by Taras on 11/20/2016.
 */

package com.mobydickens.repository.impl;

import com.mobydickens.jpa.ApplicationUserCrudRepository;
import com.mobydickens.model.ApplicationUser;
import com.mobydickens.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ApplicationUserRepositoryImpl implements ApplicationUserRepository
{
//    private List<ApplicationUser> userList = new ArrayList<>();

    @Autowired
    private ApplicationUserCrudRepository applicationUserCrudRepository;

    @Override
    public void createApplicationUser(ApplicationUser user)
    {
//        userList.add(user);
        applicationUserCrudRepository.save(user);
    }

    @Override
    public ApplicationUser findByUserName(String username)
    {
//        for (ApplicationUser user : userList) {if (user.getUsername().equalsIgnoreCase(username)) {return user;}}
        try
        {
            for (ApplicationUser user : applicationUserCrudRepository.findByUsername(username))
            {
                if (user.getUsername().equalsIgnoreCase(username)) {return user;}
            }

        }

        catch (Exception ex)
        {
            // not found!
//            ex.printStackTrace();
        }
        return null;
    }
}
