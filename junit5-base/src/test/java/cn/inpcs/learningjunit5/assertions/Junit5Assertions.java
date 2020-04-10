package cn.inpcs.learningjunit5.assertions;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Junit 5 assertions.
 *
 * @author inpcs
 * @version 1.0
 * @date 2020 -04-09 22:08:47
 */
public class Junit5Assertions {
    /**
     * @assertEquals 判断两个对象或两个原始类型是否相等
     */
    @Test
    void AssertEqualsTag() {
        assertEquals(1 + 1, 2);
    }

    /**
     * @assertNotEquals 判断两个对象或两个原始类型是否不相等
     */
    @Test
    void assertNotEqualsTag() {
        assertNotEquals(1, 2);
    }

    /**
     * @assertSame 判断两个对象引用是否指向同一个对象
     */
    @Test
    void assertSameTag() {
        Object obj = new Object();
        assertSame(obj, obj);
    }

    /**
     * @assertNotSame 判断两个对象引用是否指向不同的对象
     */
    @Test
    void assertNotSameTag() {
        Object obj = new Object();
        Object oldObj = new Object();
        assertNotSame(obj, oldObj);
    }

    /**
     * @assertTrue 判断给定的布尔值是否为 true
     */
    @Test
    void assertTrueTag() {
        assertTrue(5 > 1);
    }

    /**
     * @assertFalse 判断给定的布尔值是否为 false
     */
    @Test
    void assertFalseTag() {
        assertFalse(5 < 1);
    }

    /**
     * @assertNull 判断给定的对象引用是否为 null
     */
    @Test
    void assertNullTag() {
        String str = null;
        assertNull(str);
    }

    /**
     * @assertNotNull 判断给定的对象引用是否不为 null
     */
    @Test
    void assertNotNullTag() {
        assertNotNull(new java.lang.String("foo"));
    }

    /**
     * @assertArrayEquals 方法来判断两个对象或原始类型的数组是否相等
     */
    @Test
    void assertArrayEqualsTag() {
        assertArrayEquals(new int[]{8, 9}, new int[]{8, 9});
    }

    /**
     * assertAll 方法来判断一组断言是否满足。
     * assertAll 方法接受多个 org.junit.jupiter.api.Executable 函数式接口的实例作为要验证的断言，
     * 可以通过 lambda 表达式很容易的提供这些断言
     */
    @Test
    void assertAllTag() {
        assertAll("testAll",
                () -> assertEquals(1 + 1, 2),
                () -> assertNotEquals(1 + 1, 3));
    }

    /**
     * @assertThorwTag 或 expectThrows 来判断是否抛出期望的异常类型。
     * 两个方法的参数都是所期望的异常类型和对应的 Executable 接口的实现对象，区别在于 expectThrows 方法会返回抛出的异常对象。
     */
    @Test
    @DisplayName("NullPointerException")
    void assertThorwTag() {
        Object object = null;
        assertThrows(NullPointerException.class, () -> object.toString());
    }

    /**
     * @expectThrowsTag 来判断是否抛出期望的异常类型。两个方法的参数都是所期望的异常类型和对应的 Executable 接口的实现对象，
     * expectThrows 方法会返回抛出的异常对象。
     */
    @Test
    @DisplayName("throwable NullPointerException Object")
    void exceptionThrowsTag() {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            AssertThrowExceptionDemo.nullException();
        });
        assertEquals("a NullPointerException msg", exception.getMessage());
    }

    /**
     * @assertDoesNotThrowTag 主要用来判定被测试方法是否抛出了异常，如果抛出异常则断言失败，无异常抛出则断言成功。
     */
    @Test
    @DisplayName("not throw exception! ")
    void assertDoesNotThrowTag() {

        //这是带返回参数的assertDoesNotThrow方法，在没有异常抛出的情况下会返回一个值
        int re = assertDoesNotThrow(() -> AssertThrowExceptionDemo.division(9, 1));

        //可以对返回的结果值进行一些测试等
        assertEquals(re, 9);
    }

    /**
     * @assertLinesMatchTag 预期的字符串列表(list)与实际列表(list)匹配
     */
    @Test
    void assertLinesMatchTag() {
        assertLinesMatch(Lists.newArrayList("LinesMatch"), Lists.newArrayList("LinesMatch"));
    }

    /**
     * @assertIterableEqualsTag 迭代器中的元素全部相等
     */
    @Test
    void assertIterableEqualsTag() {
        assertIterableEquals(Lists.newArrayList("lili", "zhao"), Lists.newArrayList("lili", "zhao"));
    }

    /**
     * @assertTimeoutTag 断言在超出给定超时之前，所提供的可执行代码块的执行完成。
     * 注意：可执行代码块将在与调用代码相同的线程中执行。
     * 因此，如果超过超时，则不会抢先中止执行可执行代码块。
     */
    @Test
    @DisplayName("Assert Time Out!")
    void assertTimeoutTag() {
        assertTimeout(ofMillis(90), () -> {
            Thread.sleep(100);
        });
    }

    /**
     * @assertTimeoutPreemptivelyTag 断言在超出给定超时之前，所提供的可执行代码块的执行完成。
     * 注意：可执行代码块将在与调用代码不同的线程中执行。
     * 此外，如果超过超时，则可抢占地执行可执行代码块。
     */
    @Test
    @DisplayName("Assert Timeout Preemptively!")
    void assertTimeoutPreemptivelyTag() {
        assertTimeoutPreemptively(ofMillis(30), () -> {
            Thread.sleep(50);
        });
    }

}
