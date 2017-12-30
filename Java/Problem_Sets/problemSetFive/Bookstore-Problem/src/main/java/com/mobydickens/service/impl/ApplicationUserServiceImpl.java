package com.mobydickens.service.impl; /**
 * Created by Taras on 11/20/2016.
 */

import com.mobydickens.model.ApplicationUser;
import com.mobydickens.repository.ApplicationUserRepository;
import com.mobydickens.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService
{

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Override
    public void createApplicationUser(ApplicationUser user) {applicationUserRepository.createApplicationUser(user);}

    @Override
    public ApplicationUser findByUserName(String username) {return applicationUserRepository.findByUserName(username);}
}
