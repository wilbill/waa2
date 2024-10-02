package org.example.waa2;

import org.example.waa2.domain.Book;
import org.example.waa2.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Waa2Application{

	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(Waa2Application.class, args);
	}

	@Bean
	CommandLineRunner runner(BookRepository bookRepository) {
		return args -> {
			bookRepository.save(new Book(null, "Effective Java", "978-0134685991", 45.00));
			bookRepository.save(new Book(null, "Clean Code", "978-0132350884", 40.50));
			bookRepository.save(new Book(null, "Java Concurrency in Practice", "978-0321349606", 55.75));
			bookRepository.save(new Book(null, "Spring in Action", "978-1617294945", 49.99));
			bookRepository.save(new Book(null, "Head First Design Patterns", "978-0596007126", 37.99));

			System.out.println("Sample books added!");
		};
	}

}
