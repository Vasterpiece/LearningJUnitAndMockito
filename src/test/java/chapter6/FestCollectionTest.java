package chapter6;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.MapAssert.entry;

public class FestCollectionTest {
    private Set<String> setA = new LinkedHashSet<String>();
    private Set<String> setB = new LinkedHashSet<String>();
    private String s1 = "s1";
    private String s2 = "s2";

    @Before
    public void setUp(){
        setA.add(s1);
        setA.add(s2);
        setB.add(s2);
        setB.add(s1);
    }

    @Test
    public void collectionsUtilityMethods() {
        assertThat(setA).isNotEmpty()
                .hasSize(2).doesNotHaveDuplicates();
        assertThat(setA).containsOnly(s1, s2);
    }
    @Test
    public void mapUtilityMethods() {
        HashMap<String, Integer> map
                = new LinkedHashMap<String, Integer>();
        map.put("a", 2);
        map.put("b", 3);
        assertThat(map).isNotNull().isNotEmpty()
                .includes(entry("a", 2), entry("b", 3))
                .excludes(entry("c", 1));
    }
}

