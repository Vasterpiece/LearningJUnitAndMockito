package chapter6;

import org.junit.Test;
import static chapter6.BookAssert.assertThat;

public class BookFestTest {
    private static final String TITLE = "My book";
    @Test
    public void constructorShouldSetTitle() {
        Book book = new Book(TITLE);
        assertThat(book).hasTitle(TITLE);
    }
}

