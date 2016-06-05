package chapter5;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertTrue;
public class FirstMockitoTest {
    private Car myFerrari = mock(Car.class);
    @Test
    public void testIfCarIsACar() {
        assertTrue(myFerrari instanceof Car);
    }
}
