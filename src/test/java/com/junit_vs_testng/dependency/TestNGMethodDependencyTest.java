package com.junit_vs_testng.dependency;


import org.testng.annotations.Test;

/**
 * Created by gnavin on 2/25/17.
 */
public class TestNGMethodDependencyTest {

    @Test
    public void method1() {
        System.out.println("This is method 1");
    }


    @Test(dependsOnMethods = {"method1"})
    public void method2() {
        System.out.println("This is method 2");
    }


}
