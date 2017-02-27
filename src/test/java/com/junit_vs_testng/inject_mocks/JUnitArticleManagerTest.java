package com.junit_vs_testng.inject_mocks;

import com.Util;
import com.test.mockito.ArticleDatabase;
import com.test.mockito.ArticleManager;
import com.test.mockito.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by gnavin on 2/26/17.
 */
//TestNG will have MockitoAnnotations.initMocks(this);
//Junit will have @RunWith(MockitoJUnitRunner.class)
@RunWith(MockitoJUnitRunner.class)
public class JUnitArticleManagerTest {

    @Mock
    ArticleDatabase database;

    @Mock
    User user;

    @InjectMocks
    private ArticleManager manager;

    @Test
    public void shouldDoSomething() {
        Util.shouldDoSomething(manager);
    }

}
