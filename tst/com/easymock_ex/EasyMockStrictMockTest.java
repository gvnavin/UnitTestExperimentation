package com.easymock_ex;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

/**
 * Created by gnavin on 2/26/17.
 * https://www.tutorialspoint.com/easymock/easymock_createstrictmock.htm
 */
public class EasyMockStrictMockTest {

    @Test
    public void testStrictMock() {

        //EasyMock.createStrictMock() creates a mock and also takes
        // care of the order of method calls that the mock is
        // going to make in due course of its action.
        List list = createNiceMock(List.class);
        expect(list.size()).andReturn(3);
        expect(list.isEmpty()).andReturn(true);

        replay(list);


        Assert.assertEquals(3, list.size());
        Assert.assertTrue(list.isEmpty());

        verify(list);

    }
}
