package exercises1chapter;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class StringReverseTest {

    private static final Object[] getStrings(){
        return new Object[] {
            "Sasha", "Masha", "Kurwa"};
    }

    @Test
    @Parameters(method = "getStrings")
    public void testMethodresults (String string){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        StringReverse stringReverse = new StringReverse();
        String reversedString = stringBuilder.reverse().toString();
        assertEquals(reversedString, stringReverse.reverse(string));
    }

    @Test(expected = NullPointerException.class)
    public void exceptionMustBeThrown(){
        new StringReverse().reverse(null);
    }
}
