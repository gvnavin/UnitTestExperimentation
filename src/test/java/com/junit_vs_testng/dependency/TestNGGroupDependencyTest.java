package com.junit_vs_testng.dependency;


import org.testng.annotations.Test;

/**
 * Created by gnavin on 2/25/17.
 */
public class TestNGGroupDependencyTest {

    @Test(groups= "depends-group-test")
    public void method1() {
        System.out.println("This is method 1");
    }


    @Test(dependsOnGroups = {"depends-group-test"})
    public void method2() {
        System.out.println("This is method 2");
    }


}
