package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String title; //書名


    @Column(nullable = false)
    private String author; //作者
    private String isbn;  //國際標準書號
    private String quantity; //庫存的數量
}
