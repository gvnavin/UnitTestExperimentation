package com;

import com.test.mockito.ArticleManager;

/**
 * Created by gnavin on 2/26/17.
 */
public class Util {

    public static void shouldDoSomething(final ArticleManager manager) {
        System.out.println("manager.getDatabase() = " + manager.getDatabase());
        System.out.println("manager.getUser() = " + manager.getUser());
    }

}
