package fi.haagahelia.course.bookStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.course.bookStore.domain.Book;
import fi.haagahelia.course.bookStore.domain.BookRepository;
import fi.haagahelia.course.bookStore.domain.Category;
import fi.haagahelia.course.bookStore.domain.CategoryRepository;
import fi.haagahelia.course.bookStore.domain.User;
import fi.haagahelia.course.bookStore.domain.UserRepository;



@SpringBootApplication
public class BookStoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository categoryrepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");
			categoryrepository.save(new Category("Tietokirjat"));
			categoryrepository.save(new Category("Fiktio"));
			categoryrepository.save(new Category("Lastenkirjat"));
			
			repository.save(new Book("Satukirja", "Mikko Mallikas", 2004, 1234, (long) 10.50, categoryrepository.findByName("Lastenkirjat").get(0)));
			repository.save(new Book("Sanakirja", "Maija Mallikas", 2006, 1243, (long) 11.50, categoryrepository.findByName("Tietokirjat").get(0)));	
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@email.com", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@email.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
