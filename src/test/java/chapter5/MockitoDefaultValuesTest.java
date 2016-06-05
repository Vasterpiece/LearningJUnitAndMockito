package chapter5;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

public class MockitoDefaultValuesTest {
    private Car myFerrari = mock(Car.class);
    @Test
    public void testDefaultBehaviourOfTestDouble() {
        assertFalse("new test double should return false as boolean",
                myFerrari.needsFuel());
        assertEquals("new test double should return 0.0 as double",
                0.0, myFerrari.getEngineTemperature());
    }
}
