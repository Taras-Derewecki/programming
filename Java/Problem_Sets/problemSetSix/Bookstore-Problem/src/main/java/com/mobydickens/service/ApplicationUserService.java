/**
 * Created by Taras on 11/20/2016.
 */

package com.mobydickens.service;

import com.mobydickens.model.ApplicationUser;

public interface ApplicationUserService
{
    void createApplicationUser(ApplicationUser user);

    ApplicationUser findByUserName(String username);
}
