package com.jmockit_ex.argument_capture;

import com.test.jmockit.Collaborator;
import com.test.jmockit.Team;
import mockit.Injectable;
import mockit.Verifications;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by gnavin on 2/27/17.
 * https://phoenixjiangnan.github.io/2016/04/17/test/jmockit/Unit-Test-JMockit-Capturing-Invocation-Arguments-for-Verification/
 */
public class CapturingArgumentSingleInvocation {

    @Injectable
    Collaborator c;

    Team t;

    @Before
    public void init() {
        t = new Team(c);
    }

    @Test
    public void testASingleInvoation() {
        t.pass(1, 2);

        new Verifications() {{
            int i;
            int s;
            c.simpleOperation(i = withCapture(), s = withCapture());

            Assert.assertEquals(2, i);
            Assert.assertEquals(3, s);
        }};
    }

}
