package test.java.edu.psu.Bookstore.Service.impl;

import Bookstore.Model.ApplicationUser;
import Bookstore.Service.impl.ApplicationUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationUserServiceImplTest {

    @Autowired
    private ApplicationUserService applicationUserService;

    @Test
    public void findUserByUserName() throws Exception {

        ApplicationUser user = applicationUserService.findUserByUserName("admin");
        assertEquals(1L, (long)user.getId());
    }

}