package com.demo.springbootdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@RestController
public class testController 
{
    @RequestMapping("/")
    String home() {
		return "Hello World!";
    }
}
