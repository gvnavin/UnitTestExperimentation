package com.testng_ex.group;

/**
 * Created by gnavin on 2/25/17.
 * Source:
 * http://www.mkyong.com/unittest/testng-groups-example/
 */

import org.testng.annotations.Test;

@Test(groups= "selenium-test")
public class TestSeleniumGroupOnClass {

    public void runSelenium() {
        System.out.println("runSelenium()");
    }

    public void runSelenium1() {
        System.out.println("runSelenium1()");
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