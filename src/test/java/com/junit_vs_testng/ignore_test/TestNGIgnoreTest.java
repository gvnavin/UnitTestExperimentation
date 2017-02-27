package com.junit_vs_testng.ignore_test;


import org.testng.annotations.Test;

/**
 * Created by gnavin on 2/25/17.
 * source: http://www.mkyong.com/unittest/junit-4-vs-testng-comparison/
 */
public class TestNGIgnoreTest {

    @Test(enabled = false)
    public void divisionWithException() {
        System.out.println("Method is not ready yet");
    }
}
