package com.junit_vs_testng.suite_test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by gnavin on 2/25/17.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        JunitTest1.class,
        JunitTest2.class
})
public class JunitSuiteTest {

}
