package cn.inpcs.learningjunit5.helloword;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Hello world test.
 *
 * @author inpcs
 * @version 1.0
 * @date 2020 -04-10 14:41:45
 */
class HelloWorldTest {

    private HelloWorld helloWorld;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        helloWorld = new HelloWorld();
    }

    @Test
    void sayHelloTest() {
        String sh = helloWorld.sayHello();
        assertEquals("Hello World!", sh);
    }
}