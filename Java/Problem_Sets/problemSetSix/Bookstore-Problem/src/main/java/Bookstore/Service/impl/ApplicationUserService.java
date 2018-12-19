package Bookstore.Service.impl;


import Bookstore.Model.ApplicationUser;

public interface ApplicationUserService {
    ApplicationUser findUserByUserName(String username);
}

