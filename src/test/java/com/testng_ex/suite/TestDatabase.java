package com.testng_ex.suite;

/**
 * Created by gnavin on 2/25/17.
 */

import org.testng.annotations.Test;

public class TestDatabase {

    @Test(groups = "db")
    public void testConnectOracle() {
        System.out.println("testConnectOracle()");
    }

    @Test(groups = "db")
    public void testConnectMsSQL() {
        System.out.println("testConnectMsSQL");
    }

    @Test(groups = "db-nosql")
    public void testConnectMongoDB() {
        System.out.println("testConnectMongoDB");
    }

    @Test(groups = {"db", "brokenTests"})
    public void testConnectMySQL() {
        System.out.println("testConnectMySQL");
    }

}
