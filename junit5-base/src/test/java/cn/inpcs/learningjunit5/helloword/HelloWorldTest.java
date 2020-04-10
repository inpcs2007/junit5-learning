package cn.inpcs.learningjunit5.helloword;

import org.junit.jupiter.api.BeforeEach;

class HelloWorldTest {

    private HelloWorld helloWorld;

    @BeforeEach
    void setUp() {
        helloWorld = new HelloWorld();
    }

}