package chapter6;

import org.junit.Test;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UserTest {
    @Test
    public void shouldReturnUsersPhone() {
        User user = new User();
        user.addPhone("123 456 789");
        List<String> phones = user.getPhones();
        assertNotNull(phones);
        assertEquals(1, phones.size());
        assertTrue(phones.contains("123 456 789"));
    }
}

