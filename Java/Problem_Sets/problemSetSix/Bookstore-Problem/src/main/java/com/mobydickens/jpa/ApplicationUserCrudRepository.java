/**
 * Created by Taras on 12/10/2016.
 */

package com.mobydickens.jpa;


import org.springframework.data.repository.CrudRepository;
import com.mobydickens.model.ApplicationUser;

import java.util.List;

public interface ApplicationUserCrudRepository extends CrudRepository<ApplicationUser, Integer>
{
    List<ApplicationUser> findByUsername(String username);
}
