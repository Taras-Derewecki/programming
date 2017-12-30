package com.mobydickens.service;

import com.mobydickens.model.ApplicationUser;

public interface ApplicationUserService
{
    void createApplicationUser(ApplicationUser user);

    ApplicationUser findByUserName(String username);
}
