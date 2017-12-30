/**
 * Created by Taras on 11/20/2016.
 */

package com.mobydickens.repository.impl;

import com.mobydickens.model.ApplicationUser;
import com.mobydickens.repository.ApplicationUserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ApplicationUserRepositoryImpl implements ApplicationUserRepository
{
    private List<ApplicationUser> userList = new ArrayList<>();

    @Override
    public void createApplicationUser(ApplicationUser user) {userList.add(user);}

    @Override
    public ApplicationUser findByUserName(String username)
    {
        for (ApplicationUser user : userList) {if (user.getUsername().equalsIgnoreCase(username)) {return user;}}
        return null;
    }
}
