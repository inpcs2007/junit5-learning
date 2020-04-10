package cn.inpcs.learningjunit5.springbootrestful;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

/**
 * The type Spring boot rest app test.
 *
 * @author inpcs
 * @version 1.0
 * @date 2020 -04-10 16:45:57
 */
@SpringBootTest(webEnvironment = RANDOM_PORT)
class SpringBootRestAppTest {

    /**
     * The Rest template.
     */
    @Autowired
    TestRestTemplate restTemplate;

    /**
     * Test get all books.
     */
    @Test
    void testGetAllBooks() {
        ResponseEntity<Book[]> responseEntity = restTemplate.getForEntity("/books", Book[].class);

        assertEquals(OK, responseEntity.getStatusCode());
        assertEquals(3, responseEntity.getBody().length);
    }

    /**
     * Test get book.
     */
    @Test
    void testGetBook() {
        ResponseEntity<Book> responseEntity = restTemplate.getForEntity("/book/0", Book.class);

        assertEquals(OK, responseEntity.getStatusCode());
        assertEquals("The Hobbit", responseEntity.getBody().getName());
    }

    /**
     * Test post book.
     */
    @Test
    void testPostBook() {
        Book book = new Book("I, Robot", "Isaac Asimov", LocalDate.of(1950, 12, 2));

        ResponseEntity<Boolean> responseEntity = restTemplate.postForEntity("/book", book, Boolean.class);
        assertEquals(CREATED, responseEntity.getStatusCode());
        assertEquals(true, responseEntity.getBody());

        ResponseEntity<Book[]> responseEntity2 = restTemplate.getForEntity("/books", Book[].class);
        assertEquals(4, responseEntity2.getBody().length);
    }

}
