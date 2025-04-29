package com.bookstore.EnchantedShelf.controller;

import com.bookstore.EnchantedShelf.entity.Book;
import com.bookstore.EnchantedShelf.entity.MyBookList;
import com.bookstore.EnchantedShelf.service.BookService;
import com.bookstore.EnchantedShelf.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private MyBookListService myBookListService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }

    @GetMapping("/book_list")
    public String getBookList(Model model){
        List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("allBooks",allBooks);
        return "bookList";
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book){
        bookService.save(book);
        return "redirect:/book_list";
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model){
        List<MyBookList> allMyBooks = myBookListService.getAllMyBooks();
        model.addAttribute("allMyBooks",allMyBooks);
        return "myBooks";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyBookList(@PathVariable("id") int id){
        Book book = bookService.getBookById(id);
        MyBookList myBookList = new MyBookList(book.getId(), book.getName(),
                book.getAuthor(),book.getPrice());
        myBookListService.saveMyBooks(myBookList);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        Book book = bookService.getBookById(id);
        model.addAttribute("book",book);
        return "bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteBookById(id);
        return "redirect:/book_list";
    }

}
