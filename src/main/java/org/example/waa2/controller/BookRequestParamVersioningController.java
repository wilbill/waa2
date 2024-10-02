package org.example.waa2.controller;

import org.example.waa2.dto.response.BookResponse;
import org.example.waa2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookRequestParamVersioningController {

    @Autowired
    private BookService bookService;

    // Request Parameter Version 1
    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookV1(@PathVariable Long id, @RequestParam("version") int version) {
        if (version == 1) {
            BookResponse book = bookService.findById(id);
            return ResponseEntity.ok(book);
        } else if (version == 2) {
            BookResponse book = bookService.findById(id);
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
}

