package exercises1chapter;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class HashMapTest {
    private HashMap map;

    @Before
    public void setUp(){
        map = new HashMap();
    }

    private static Object[] getData(){
        return new Object[]{
                new Object[]{"Suka", "ti"},
                new Object[]{"Blyat", "ona"}
        };
    }

    @Test
    @Parameters(method = "getData")
    public void testPutGetmethods(String key, String value){
        map.put(key,value);
        assertEquals(value,map.get(key));
    }

    @Test
    @Parameters(method="getData")
    public void testHashMapReplacement(String key, String value){
        testPutGetmethods(key,value);
        testPutGetmethods(key, "newValue");
        assertEquals("newValue", map.get(key));
    }

    @Test
    @Parameters(method = "getData")
    public void testClearMethod(String key, String value){
        assertEquals(0,map.size());
        testPutGetmethods(key, value);
        assertEquals(1,map.size());
        map.clear();
        assertEquals(0, map.size());
    }

    @Test
    public void testNullKey(){
        map.put(null,"String");
        assertEquals("String", map.get(null));
    }
}
