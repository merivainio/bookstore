package fi.haagahelia.course.bookStore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.course.bookStore.domain.Book;
import fi.haagahelia.course.bookStore.domain.BookRepository;
import fi.haagahelia.course.bookStore.domain.Category;


@RunWith(SpringRunner.class)
@DataJpaTest

public class BookRepositoryTest {
	
	@Autowired
    private BookRepository repository;

    @Test
    public void findByTitleShouldReturnBook() {
        List<Book> books = repository.findByTitle("Satukirja");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Mikko Mallikas");
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("Haikuja", "Miikka Malli", 2007, 1212, (long) 9.50, new Category("Runot"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }
    
    @Test
    public void deleteBook() {
    	repository.deleteById((long) 4);
    }

}
