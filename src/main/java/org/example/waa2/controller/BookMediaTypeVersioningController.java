package org.example.waa2.controller;

import org.example.waa2.dto.response.BookResponse;
import org.example.waa2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class BookMediaTypeVersioningController {


    @Autowired
    private BookService bookService;

    // Media Type Version 1
    @GetMapping(value = "/{id}", produces = "application/cs.miu.edu-v1+json")
    public ResponseEntity<BookResponse> getBookV1(@PathVariable Long id) {
        BookResponse book = bookService.findById(id);
        return ResponseEntity.ok(book);
    }

    // Media Type Version 2
    @GetMapping(value = "/{id}", produces = "application/cs.miu.edu-v2+json")
    public ResponseEntity<BookResponse> getBookV2(@PathVariable Long id) {
        BookResponse book = bookService.findById(id); // Assuming V2 has different response structure
        return ResponseEntity.ok(book);
    }
}
