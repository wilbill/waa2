package org.example.waa2.controller;

import org.example.waa2.dto.request.CreateBookRequest;
import org.example.waa2.dto.response.BookResponse;
import org.example.waa2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateBookRequest bookRequest) {// CreateProductRequest is like a
        // dto to create a book
        BookResponse bookResponse = bookService.create(bookRequest);
        return new ResponseEntity<>(bookResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllbooks() {
        List<BookResponse> products = bookService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductByID(@PathVariable Long id) {
        BookResponse productResponse = bookService.findById(id);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);

    }

    @PutMapping("/{bookId}")
    public ResponseEntity<?> updateProduct(
            @PathVariable Long bookId,
            @RequestBody CreateBookRequest bookRequest) {
        BookResponse updatedProduct = bookService.update(bookId, bookRequest);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long bookId) {
        bookService.deleteById(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
