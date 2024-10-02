package org.example.waa2.service.Impl;

import org.example.waa2.domain.Book;
import org.example.waa2.dto.request.CreateBookRequest;
import org.example.waa2.dto.response.BookResponse;
import org.example.waa2.exceptions.BookNotFoundException;
import org.example.waa2.repository.BookRepository;
import org.example.waa2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookResponse create(CreateBookRequest request) {
        // TODO Check if Book exist already...later
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setPrice(request.getPrice());
        book.setIsbn(request.getIsbn());
        book = bookRepository.save(book);
        return BookResponse.from(book);
    }


    @Override
    public List<BookResponse> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(BookResponse::from)
                .toList();
    }

    @Override
    public BookResponse findById(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(
                () -> new BookNotFoundException(String.format("Book with id %s not found", bookId)));
        return BookResponse.from(book);
    }

    @Override
    public BookResponse update(Long bookId, CreateBookRequest bookRequest) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(optionalBook.isPresent()){
            Book book = optionalBook.get();

            //update the Book properties
            book.setTitle(bookRequest.getTitle());
            book.setIsbn(bookRequest.getIsbn());
            book.setPrice(bookRequest.getPrice());
            bookRepository.save(book); //gow is this true
            return BookResponse.from(book);
        }
        else{
            //throw new EntityNotFoundException("Car not found");  //in-built exception
            throw new BookNotFoundException(String.format("Book id %s not found", bookId)); //custom error
        }
    }

    @Override
    public void deleteById(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(
                ()-> new BookNotFoundException(String.format("Cant delete, Book with id %s not found", bookId))
        );
        bookRepository.delete(book);
    }
}
