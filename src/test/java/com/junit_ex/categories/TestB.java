package com.junit_ex.categories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Created by gnavin on 2/25/17.
 * http://www.vogella.com/tutorials/JUnit/article.html
 */
@Category({ JUnitSlowTestsCategory.class, JUnitFastTestsCategory.class })
public class TestB {

    @Test
    public void c() {
        System.out.println("TestB.b");
    }
}
