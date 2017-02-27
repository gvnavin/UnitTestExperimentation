package com.junit_vs_testng.time_out;

import org.testng.annotations.Test;

/**
 * Created by gnavin on 2/25/17.
 * source:
 * http://www.mkyong.com/unittest/junit-4-vs-testng-comparison/
 */
public class TestNGTimeOutTest {

    @Test(timeOut = 1000)
    public void infinity() {
        while (true) ;
    }
}
