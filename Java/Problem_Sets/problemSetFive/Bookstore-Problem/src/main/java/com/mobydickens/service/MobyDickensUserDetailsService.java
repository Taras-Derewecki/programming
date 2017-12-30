package com.mobydickens.service;

import com.mobydickens.model.ApplicationUser;
import com.mobydickens.model.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class MobyDickensUserDetailsService implements UserDetailsService
{
    @Autowired
    private ApplicationUserService applicationUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        ApplicationUser user = applicationUserService.findByUserName(username);

        if (user == null) {throw new UsernameNotFoundException("Username not found: " + username);}
        return new SecurityUser(user);
    }


}
