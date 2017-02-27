package com.easymock_ex;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

/**
 * Created by gnavin on 2/26/17.
 * https://www.tutorialspoint.com/easymock/easymock_createmock.htm
 */
public class EasyMockCreateMockTest {

    @Test
    public void testCreateMock() {

        // EasyMock.createMock() creates mocks without bothering about
        // the order of method calls that the mock is going to make
        // in due course of its action.
        List list = createMock(List.class);
        expect(list.size()).andReturn(3);
        expect(list.isEmpty()).andReturn(true);

        replay(list);

        Assert.assertTrue(list.isEmpty());
        Assert.assertEquals(3, list.size());

        verify(list);

    }
}
