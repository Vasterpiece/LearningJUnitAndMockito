package exercises4chapter;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
@RunWith(JUnitParamsRunner.class)
public class TestFinder {

    private static Object[] getStringsToCheck(){
        return new Object[]{
                new Object[]{"abc 12", new ArrayList<Integer>()},
                new Object[]{"cdefg 345 12bb23", Arrays.asList(345)},
                new Object[]{"cdefg 345 12bbb33 678tt",Arrays.asList(345, 678) }
        };
    }

    @Test(expected = IllegalArgumentException.class)
    public void NullReferenceThrowsIllegalArgumentException(){
        Finder.checkString(null);
    }

    @Test
    @Parameters(method = "getStringsToCheck")
    public void CheckReturnedList(String string, List list){
        ArrayList<Integer> returnedList = Finder.checkString(string);
        assertTrue("Lists are not equal. Expected list: " + list +
                " Returned list: "+returnedList,returnedList.equals(list));
    }
}
