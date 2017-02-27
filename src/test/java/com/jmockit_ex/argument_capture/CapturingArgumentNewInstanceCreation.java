package com.jmockit_ex.argument_capture;

import com.test.jmockit.Person;
import com.test.jmockit.PersonDAO;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Verifications;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gnavin on 2/27/17.
 * https://phoenixjiangnan.github.io/2016/04/17/test/jmockit/Unit-Test-JMockit-Capturing-Invocation-Arguments-for-Verification/
 */
public class CapturingArgumentNewInstanceCreation {

    @Injectable
    PersonDAO dao;

    @Test
    public void capturingNewInstances(@Mocked Person mockedPerson) {
        // From the code under test:
        dao.create(new Person("Paul", 10));
        dao.create(new Person("Mary", 15));
        dao.create(new Person("Joe", 20));
        new Verifications() {{
            // Captures the new instances created with a specific constructor.
            List<Person> personsInstantiated = withCapture(new Person(anyString, anyInt));
            // Now captures the instances of the same type passed to a method.
            List<Person> personsCreated = new ArrayList<>();
            dao.create(withCapture(personsCreated));
            // Finally, verifies both lists are the same.
            Assert.assertEquals(personsInstantiated, personsCreated);
        }};
    }

}
