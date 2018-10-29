package fi.haagahelia.course.bookStore;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.course.bookStore.domain.User;
import fi.haagahelia.course.bookStore.domain.UserRepository;


@RunWith(SpringRunner.class)
@DataJpaTest

public class UserRepositoryTest {
	
	@Autowired
    private UserRepository repository;

    @Test
    public void findByUsernameShouldReturnUser() {
        User user = repository.findByUsername("user");
        
        assertThat(user.getId()).isNotNull();
    }
    
    @Test
    public void createNewBook() {
    	User user = new User("guest", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "guest@email.com", "USER");
    	repository.save(user);
    	assertThat(user.getId()).isNotNull();
    }
    
    @Test
    public void deleteUser() {
    	repository.deleteById((long) 4);
    }


}
