package Bookstore.jpa;

import Bookstore.Model.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationUserCrudRepository extends CrudRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}
