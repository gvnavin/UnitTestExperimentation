package com.jmockit_ex;

import com.test.jmockit.Discussion;
import com.test.jmockit.Leader;
import com.test.jmockit.Team;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gnavin on 2/27/17.
 * https://phoenixjiangnan.github.io/2016/04/06/test/jmockit/Unit-Test-JMockit-What-are-the-differences-between-Mocked-and-Injectable-in-JMockit-and-when-to-use-Injectable-rather-than-Mocked/
 */
public class MockedVsInjectable {

    @Test
    public void testHasADiscussion(
            @Mocked final Discussion aDiscussion,
            @Injectable final Leader aLeader)
    // Usually you will write `@Mocked Leader aLeader`,
    // which is fine in most cases but you will hit hidden issues and don't know why
    {
        new Expectations() {{
            aLeader.getName();
            result = "dev_leader";
            aDiscussion.started();
            result = true;
        }};


        Team t = new Team(aLeader); // Note! You can pass in `aLeader` (but not aDiscussion) to `Team` here!
        Assert.assertTrue(t.hasADiscussion());

        Assert.assertEquals("dev_leader", aLeader.getName());
    }

}
