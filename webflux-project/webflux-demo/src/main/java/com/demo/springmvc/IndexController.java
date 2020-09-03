package com.demo.springmvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenye
 */
@RestController
public class IndexController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}