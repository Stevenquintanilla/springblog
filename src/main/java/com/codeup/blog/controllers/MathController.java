package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @ResponseBody
    @GetMapping("/add/{x}/and/{y}")
    public int add(@PathVariable int x, @PathVariable int y) {
        return x + y;
    }

    @ResponseBody
    @GetMapping("/subtract/{x}/from/{y}")
    public int subtract(@PathVariable int x, @PathVariable int y) {
        return x - y;
    }

    @ResponseBody
    @GetMapping("/multiply/{x}/and/{y}")
    public int multiply(@PathVariable int x, @PathVariable int y) {
        return x * y;
    }

    @ResponseBody
    @GetMapping("/divide/{x}/by/{y}")
    public int divide(@PathVariable int x, @PathVariable int y) {
        return x / y;
    }
}
