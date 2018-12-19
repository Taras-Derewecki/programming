package Bookstore.Repository;

import Bookstore.Model.ApplicationUser;

public interface ApplicationUserRepository {

    ApplicationUser findUserByUserName(String username);

    ApplicationUser addUser(String userName, String password, Boolean isBoolean);
}

