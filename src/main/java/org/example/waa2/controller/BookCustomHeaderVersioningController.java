package org.example.waa2.controller;

import org.example.waa2.dto.response.BookResponse;
import org.example.waa2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
    @RestController
    @RequestMapping("/books")
    public class BookCustomHeaderVersioningController {

        @Autowired
        private BookService bookService;

        // Custom Header Version 1
        @GetMapping(value = "", headers = "X-API-VERSION=1")
        public ResponseEntity<List<BookResponse>> getAllBooks() {
            List<BookResponse> books = bookService.findAll();
            return ResponseEntity.ok(books);
        }

        // Custom Header Version 2
        @GetMapping(value = "", headers = "X-API-VERSION=2")
        public ResponseEntity<List<BookResponse>> getBooksV2() {
            List<BookResponse> books = bookService.findAll(); // Assuming V2 has some changes
            return ResponseEntity.ok(books);
        }
    }


