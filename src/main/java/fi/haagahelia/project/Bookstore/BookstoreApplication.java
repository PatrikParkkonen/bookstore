package fi.haagahelia.project.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import fi.haagahelia.project.Bookstore.domain.Book;
import fi.haagahelia.project.Bookstore.domain.BookRepository;
import fi.haagahelia.project.Bookstore.domain.Category;
import fi.haagahelia.project.Bookstore.domain.CategoryRepository;
import fi.haagahelia.project.Bookstore.domain.User;
import fi.haagahelia.project.Bookstore.domain.UserRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a few test books");
			
			crepository.save(new Category("Coming-of-Age Fiction"));
			crepository.save(new Category("Comedy"));
			
			brepository.save(new Book("To Kill a Mockingbird", "Harper Lee", 1960, "9780446310789", "8,99€", crepository.findByName("Coming-of-Age Fiction").get(0)));
			brepository.save(new Book("The Year of the Hare", "Arto Paasilinna", 1975, "9780720612776", "14.00€", crepository.findByName("Comedy").get(0)));
			
			//login is user/user and admin/admin
			User user1 = new User("user", "$2a$10$pXkDGXJggjUM09bJCnwR5um1sxIJOpmpM876PgJnoMxsIo.cwIDjK", "user@email.com", "USER");
			User user2 = new User("admin", "$2a$10$IerqdbSAwndVhZVyn1tLuOLLDxegXFVlMaUdGZBrOEzsDB1yFZft.", "admin@email.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			
			log.info("fetch all books");
			for (Book Book : brepository.findAll()) {
				log.info(Book.toString());
			}
		};

	}
	
}
