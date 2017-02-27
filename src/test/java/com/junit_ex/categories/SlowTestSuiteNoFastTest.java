package com.junit_ex.categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by gnavin on 2/25/17.
 */
@RunWith(Categories.class)
@Categories.IncludeCategory(JUnitSlowTestsCategory.class)
@Categories.ExcludeCategory(JUnitFastTestsCategory.class)
@Suite.SuiteClasses({ TestA.class, TestB.class })
// Note that Categories is a kind of Suite
public class SlowTestSuiteNoFastTest {
    // Will run A.b, but not A.a or B.c
}

/*
TestA.b
*/