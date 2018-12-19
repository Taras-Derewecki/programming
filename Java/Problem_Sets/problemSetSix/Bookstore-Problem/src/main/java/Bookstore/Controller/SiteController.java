package Bookstore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

    @GetMapping(value = "/about-us")
    public String aboutUs() {
        return "aboutus";
    }

    @GetMapping(value = "/employment")
    public String employment() {
        return "employment";
    }

    @GetMapping(value = "/contact-us")
    public String contactUs() {
        return "contactUs";
    }
}

