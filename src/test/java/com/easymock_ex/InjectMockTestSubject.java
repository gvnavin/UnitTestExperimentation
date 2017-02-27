package com.easymock_ex;

import com.Util;
import com.test.mockito.ArticleDatabase;
import com.test.mockito.ArticleManager;
import com.test.mockito.User;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by gnavin on 2/26/17.
 * https://www.tutorialspoint.com/easymock/easymock_expecting_calls.htm
 */
@RunWith(EasyMockRunner.class)
public class InjectMockTestSubject {

    @Mock
    ArticleDatabase database;

    @Mock
    User user;

    @TestSubject
    private ArticleManager manager = new ArticleManager();

    @Test
    public void shouldDoSomething() {
        Util.shouldDoSomething(manager);
    }
}
