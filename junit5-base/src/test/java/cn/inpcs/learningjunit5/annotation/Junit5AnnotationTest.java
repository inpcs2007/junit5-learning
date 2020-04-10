package cn.inpcs.learningjunit5.annotation;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * JUnit 5 提供了一些常用的注解在编写测试用例的时候使用。
 * 其中的一些注解和 JUnit 4 的注解有相同的名称，
 * 不过所在的 Java 包变成了 org.junit.jupiter.api。
 *
 * @author inpcs
 * @version 1.0
 * @date 2020 -04-09 21:39:56
 */
public class Junit5AnnotationTest {

    /**
     * @BeforeAll 表明在所有测试方法运行之前执行的方法
     */
    @BeforeAll
    static void beforeAllTag() {
    }

    /**
     * @BeforeEach 表明在单个测试方法运行之前执行的方法
     */
    @BeforeEach
    void beforeEachTag() {
    }

    /**
     * @AfterAll 表明在所有测试方法运行之后执行的方法
     */
    @AfterAll
    static void afterAllTag() {}

    /**
     * @AfterEach 表明在单个测试方法运行之后执行的方法
     */
    @AfterEach
    void afterEachTag(){}

    /**
     * @ Test 表明一个测试方法
     */
    @Test
    void testTag() {
        String actual = "Test Tag";
        assertEquals("Test Tag", actual);
    }

    /**
     * @DisplayName 测试类或方法的显示名称
     */
    @Test
    @DisplayName("DisplayName Tag")
    void DisplayNameTest() {
        String actual = "DisplayName Tag";
        assertEquals("DisplayName Tag", actual);
    }

//    /**
//     * @Disabled 禁用测试类或方法
//     */
//    @Disabled
//    void disabledTest() {
//        String actual = "This is Disabled Tag";
//        assertEquals("This is Disabled Tag", actual);
//    }

    /**
     * Fail test.
     */
    @Test
    void failTest() {
        fail("This should fail");
    }
}
