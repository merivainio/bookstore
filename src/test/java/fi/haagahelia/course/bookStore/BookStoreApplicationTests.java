package fi.haagahelia.course.bookStore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.course.bookStore.web.BookController;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookStoreApplicationTests {
		
		@Autowired
	    private BookController controller;

	    @Test
	    public void contexLoads() throws Exception {
	        assertThat(controller).isNotNull();
	    }	
}
