package com.testng_ex.suite;

/**
 * Created by gnavin on 2/25/17.
 */

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

//show the use of @BeforeSuite and @BeforeTest
public class TestConfig {

    @BeforeSuite
    public void testBeforeSuite() {
        System.out.println("testBeforeSuite()");
    }

    @AfterSuite
    public void testAfterSuite() {
        System.out.println("testAfterSuite()");
    }

    @BeforeTest
    public void testBeforeTest() {
        System.out.println("testBeforeTest()");
    }

    @AfterTest
    public void testAfterTest() {
        System.out.println("testAfterTest()");
    }

}
