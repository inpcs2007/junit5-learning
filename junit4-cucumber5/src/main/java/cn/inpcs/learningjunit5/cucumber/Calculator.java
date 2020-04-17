
package cn.inpcs.learningjunit5.cucumber;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * The type Calculator.
 *
 * @author inpcs
 * @version 1.0
 * @date 2020 -04-17 20:21:34
 */
public class Calculator {

    private final Deque<Number> stack = new LinkedList<Number>();

    private static final List<String> OPS = asList("-", "+", "*", "/");

    /**
     * Push.
     *
     * @param arg the arg
     */
    public void push(Object arg) {
        if (OPS.contains(arg)) {
            Number y = stack.removeLast();
            Number x = stack.isEmpty() ? 0 : stack.removeLast();
            Double val = null;
            if ("-".equals(arg)) {
                val = x.doubleValue() - y.doubleValue();
            } else if ("+".equals(arg)) {
                val = x.doubleValue() + y.doubleValue();
            } else if ("*".equals(arg)) {
                val = x.doubleValue() * y.doubleValue();
            } else if ("/".equals(arg)) {
                val = x.doubleValue() / y.doubleValue();
            }
            push(val);
        } else {
            stack.add((Number) arg);
        }
    }

    /**
     * Value number.
     *
     * @return the number
     */
    public Number value() {
        return stack.getLast();
    }
}
