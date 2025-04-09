package Stack.Digital.SD;

import Stack.Digital.SD.Entity.Author;
import Stack.Digital.SD.Service.AuthorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AuthorServiceTests {
    @Autowired
   public AuthorService service;

    @Test
    void createAuthor() {
        Author a = new Author();
        a.setName("Testing author  ");
        a.setBio("Bio");
        Author saved = service.create(a);
        assertNotNull(saved.getId());
    }
}

