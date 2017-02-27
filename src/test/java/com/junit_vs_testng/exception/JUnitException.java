package com.junit_vs_testng.exception;

import org.junit.Test;

/**
 * Created by gnavin on 2/25/17.
 * source: http://www.mkyong.com/unittest/junit-4-vs-testng-comparison/
 */
public class JUnitException {

    @Test(expected = ArithmeticException.class)
    public void divisionWithException() {
        int i = 1/0;
    }
}
