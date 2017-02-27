package com.jmockit_ex.argument_capture;

import com.test.jmockit.Collaborator;
import com.test.jmockit.Team;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Verifications;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gnavin on 2/27/17.
 */
public class CapturingArgumentMultipleInvocation {

    @Injectable
    Collaborator c;

    Team t;

    @Test
    public void testMultipleInvoations() {
        t = new Team(c);
        t.pass(1, 2);
        t.pass(3, 4);

        new Verifications() {{
            List<Integer> i = new ArrayList<>();
            List<Integer> s = new ArrayList<>();

            c.simpleOperation(withCapture(i), withCapture(s));

            // Assert size
            Assert.assertEquals(2, i.size());
            Assert.assertEquals(2, s.size());

            // Assert values
            Assert.assertEquals(2, (int)i.get(0));
            Assert.assertEquals(3, (int)s.get(0));
            Assert.assertEquals(4, (int)i.get(1));
            Assert.assertEquals(5, (int)s.get(1));

        }};
    }

}
