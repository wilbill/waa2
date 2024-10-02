package org.example.waa2.service;

import org.example.waa2.dto.request.CreateBookRequest;
import org.example.waa2.dto.response.BookResponse;

import java.util.List;

public interface BookService {

    BookResponse create(CreateBookRequest bookRequest);

    List<BookResponse> findAll();

    BookResponse findById(Long id);

    BookResponse update(Long productId, CreateBookRequest bookRequest);

    void deleteById(Long bookId);

}
