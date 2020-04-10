package cn.inpcs.learningjunit5.assertions;

/**
 * The type Assert throw exception demo.
 *
 * @author inpcs
 * @version 1.0
 * @date 2020 -04-10 07:35:32
 */
public class AssertThrowExceptionDemo {
    /**
     * Test throw arithmetic exception.
     *
     * @param a the a
     * @param b the b
     */
    public static int division(int a, int b) {
        try {
            return  a / b;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("The b not allowed to zero !");
        }
    }

    /**
     * Null exception.
     */
    public static void nullException() {
        throw new NullPointerException("a NullPointerException msg");
    }
}
