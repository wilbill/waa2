package org.example.waa2.dto.request;

import lombok.Data;

@Data
public class CreateBookRequest {
    private int id;
    private String title;
    private String isbn;
    private double price;
}
