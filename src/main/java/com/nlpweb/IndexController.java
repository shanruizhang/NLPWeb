package com.nlpweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The Class IndexController.
 */
@Controller
public class IndexController {
    
    /**
     * Index page.
     *
     * @return the string
     */
    @GetMapping("/index")
    public String indexPage() {
        return "index";
    }

    /**
     * Default page.
     *
     * @return the string
     */
    @GetMapping("/")
    public String defaultPage() {
        return "index";
    }

    /**
     * About page.
     *
     * @return the string
     */
    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }


}
