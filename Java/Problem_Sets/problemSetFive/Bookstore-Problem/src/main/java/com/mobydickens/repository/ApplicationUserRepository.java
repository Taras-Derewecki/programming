/*
Created by Taras Derewecki on 11/20/2016
 */

package com.mobydickens.repository;

import com.mobydickens.model.ApplicationUser;

public interface ApplicationUserRepository
{
    void createApplicationUser(ApplicationUser user);

    ApplicationUser findByUserName(String username);
}
