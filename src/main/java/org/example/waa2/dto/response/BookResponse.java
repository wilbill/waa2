package org.example.waa2.dto.response;

import lombok.Data;
import org.example.waa2.domain.Book;
@Data
public class BookResponse {
    private Long id;
    private String title;
    private String isbn;
    private double price;


    public static BookResponse from(Book book){
        BookResponse bookResponse = new BookResponse();
        bookResponse.id = book.getId();
        bookResponse.isbn= book.getIsbn();
        bookResponse.title = book.getTitle();
        bookResponse.price = book.getPrice();
        return bookResponse;

    }

}
