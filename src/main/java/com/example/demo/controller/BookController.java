package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor  //Lombok 自動產生建構子，注入 BookService
public class BookController {
    private final BookService bookService;

    //查詢全部
    @GetMapping
    public List<Book> list() {
       return bookService.findAll();
    }

    //查單筆
    @GetMapping("/{id}")
    public Book Bookid(@PathVariable long id) {
        return bookService.findId(id);
    }

    //新增or更新
    @PostMapping
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }

    //刪除
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.deleteId(id);
    }
}
