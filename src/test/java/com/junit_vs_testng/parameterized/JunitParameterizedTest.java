package com.junit_vs_testng.parameterized;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by gnavin on 2/25/17.
 * http://www.mkyong.com/unittest/junit-4-vs-testng-comparison/
 */
@RunWith(value = Parameterized.class)
public class JunitParameterizedTest {

    private int number;

    public JunitParameterizedTest(int number) {
        this.number = number;
    }

    // Static method
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { 1 }, { 2 }, { 3 }, { 4 } };
        return Arrays.asList(data);
    }

    @Test
    public void pushTest() {
        System.out.println("Parameterized Number is : " + number);
    }
}
