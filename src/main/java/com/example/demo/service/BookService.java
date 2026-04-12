package com.example.demo.service;


import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    // 注入Repository，透過BookRepository去操作資料庫
    private final BookRepository bookRepository;

    // 去資料庫撈全部的書，並回傳一個Book的清單
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    //去資料庫找id這本書，找不到就拋出例外
    public Book findId(Long id){
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()){
            return book.get();
        }else{
            throw new RuntimeException("找不到書籍" + id);
        }
    }

    // 這個操作涉及寫入資料庫，需要交易保護
    @Transactional
    public Book save(Book book){
        return bookRepository.save(book); // book如果沒有id就新增，book如果有id就更新(JPA自動判斷)
    }

    //同樣是寫入操作，需要交易保護
    @Transactional
    public void deleteId(Long id){
        bookRepository.deleteById(id);//使用id來刪除我找的書，不回傳任何東西

    }
}
