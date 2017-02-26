package com.testng_ex.group;

/**
 * Created by gnavin on 2/25/17.
 * Source:
 * http://www.mkyong.com/unittest/testng-groups-example/
 */
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class TestGroupOnMethod {

    @BeforeGroups("database")
    public void setupDB() {
        System.out.println("setupDB()");
    }

    @AfterGroups("database")
    public void cleanDB() {
        System.out.println("cleanDB()");
    }

    @Test(groups= "selenium-test")
    public void runSelenium() {
        System.out.println("runSelenium()");
    }

    @Test(groups= "selenium-test")
    public void runSelenium1() {
        System.out.println("runSelenium1()");
    }

    @Test(groups = "database")
    public void testConnectOracle() {
        System.out.println("testConnectOracle()");
    }

    @Test(groups = "database")
    public void testConnectMsSQL() {
        System.out.println("testConnectMsSQL");
    }

    @Test(dependsOnGroups = {"database","selenium-test"})
    public void runFinal() {
        System.out.println("runFinal");
    }

    @Test(groups = {"selenium-test","database"})
    public void testMultipleGroups() {
        System.out.println("test selenium and database group");
    }
}

/**

 //group = selenium-test
 runSelenium()
 runSelenium()1

 //group = database
 setupDB()
 testConnectMsSQL
 testConnectOracle()
 cleanDB()

 //dependsOnGroups = database, selenium-test
 runFinal

 */