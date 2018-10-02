package fi.haagahelia.project.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;


import fi.haagahelia.project.Bookstore.domain.Book;
import fi.haagahelia.project.Bookstore.domain.BookRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("save a test book");
			repository.save(new Book("To Kill a Mockingbird", "Harper Lee", 1960, "9780446310789", 8.99));
			
			
			log.info("fetch all books");
			for (Book Book : repository.findAll()) {
				log.info(Book.toString());
			}
		};

	}
	
}
