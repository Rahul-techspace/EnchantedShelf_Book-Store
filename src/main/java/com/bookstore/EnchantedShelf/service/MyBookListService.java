package com.bookstore.EnchantedShelf.service;

import com.bookstore.EnchantedShelf.entity.Book;
import com.bookstore.EnchantedShelf.entity.MyBookList;
import com.bookstore.EnchantedShelf.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {
    @Autowired
    private MyBookRepository myBookRepository;

    public void saveMyBooks(MyBookList myBookList){
        myBookRepository.save(myBookList);
    }

    public List<MyBookList> getAllMyBooks(){
        return myBookRepository.findAll();
    }

    public void deleteById(int id){
        myBookRepository.deleteById(id);
    }
}
