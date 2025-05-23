package com.bookstore.EnchantedShelf.controller;

import com.bookstore.EnchantedShelf.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookListController {
    @Autowired
    private MyBookListService myBookListService;

    @RequestMapping("/deletemylist/{id}")
    public String deleteById(@PathVariable("id") int id ){
        myBookListService.deleteById(id);
        return "redirect:/my_books";
    }
}
