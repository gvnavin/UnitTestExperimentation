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
 * https://www.tutorialspoint.com/easymock/easymock_createnicemock.htm
 */
public class EasyMockNiceMockTest {

    @Test
    public void testNiceMock() {

        // EasyMock.createNiceMock() creates a mock and sets the
        // default implementation of each method of the mock.
        // If EasyMock.createMock() is used, then invoking the mock method throws assertion error.
        List list = createNiceMock(List.class);
        expect(list.size()).andReturn(3);

        replay(list);

        Assert.assertEquals(3, list.size());
        Assert.assertFalse(list.isEmpty());

        verify(list);

    }
}
