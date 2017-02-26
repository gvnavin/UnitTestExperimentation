package com.testng_ex.annotations;

import org.testng.annotations.Test;

/**
 * Created by gnavin on 2/25/17.
 * Source:
 * http://www.mkyong.com/unittest/testng-tutorial-1-basic-usage/
 */
public class TestDBConnection {

    @Test
    public void runOtherTest1() {
        System.out.println("@Test - runOtherTest1");
    }

    @Test
    public void runOtherTest2() {
        System.out.println("@Test - runOtherTest2");
    }

}
