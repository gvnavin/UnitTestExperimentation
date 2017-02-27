package com.junit_vs_testng.inject_mocks;

import com.Util;
import com.test.mockito.ArticleDatabase;
import com.test.mockito.ArticleManager;
import com.test.mockito.User;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by gnavin on 2/26/17.
 */
public class TestNGArticleManagerTest {

    @Mock
    ArticleDatabase database;

    @Mock
    User user;

    @InjectMocks
    private ArticleManager manager;

    @BeforeMethod(alwaysRun=true)
    public void injectDoubles() {
        //TestNG will have MockitoAnnotations.initMocks(this);
        //Junit will have @RunWith(MockitoJUnitRunner.class)
        //It will mock all the Mockito Annotations like @Mock, @InjectMocks, @Captor
        MockitoAnnotations.initMocks(this); //This could be pulled up into a shared base class
    }

    @Test
    public void shouldDoSomething() {
        Util.shouldDoSomething(manager);
    }

}
