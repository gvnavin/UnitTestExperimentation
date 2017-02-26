package com.junit_ex.categories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.fail;

/**
 * Created by gnavin on 2/25/17.
 */
public class TestA {

    @Test
    public void a() {
        System.out.println("TestA.a");
        fail();
    }

    @Category(JUnitSlowTestsCategory.class)
    @Test
    public void b() {
        System.out.println("TestA.b");
    }
}
