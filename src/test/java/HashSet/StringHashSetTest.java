package HashSet;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StringHashSetTest {

    @org.junit.Test
    public void sizeShouldReturnCoountOfElementsInserted() {

        Set<String> set  = new StringHashSet();
        set.add("Adam");
        set.add("Asia");
        set.add("Aleks");
        set.add("Rafał");
        set.add("Łukasz");
        set.add("Adrian");

        assertEquals(6, set.size());
    }
    @Test
    public void sizeShouldReturn0ForEmptySet(){
        Set<String> set = new StringHashSet();
        assertEquals(0, set.size());

        set.add("Adam");
        set.remove("Adam");
        assertEquals(0, set.size());
    }

    @Test
    public void shouldReturnAddition(){

        Set<String> set = new StringHashSet();


        assertTrue(set.add("Adam"));

    }
   @Test
    public void shouldReturnAddAllElements(){

        Set<String> test = new HashSet<>();
        Set<String> set = new StringHashSet();

        test.add("Ala");
        test.add("Beata");
        test.add("Cytryna");
        test.add("Dawid");
        test.add("Ewa");
        test.add("Franek");
        test.add("Grzegorz");
        test.add("Halin");
        test.add("Ines");
        test.add("Jarek");


set.addAll(test);

        assertEquals(10, set.size());
    }

    @Test
    public void shouldClearAllElement(){
        Set<String> set = new StringHashSet();
        set.add("Kuba");
        set.add("Wojtek");
        set.add("Michał");

        set.clear();

        assertEquals(0, set.size());
    }

    @Test
    public void shouldRemoveElement(){
        Set<String> set = new StringHashSet();
        set.add("Kuba");
        set.remove("Kuba");

        assertEquals(false, set.contains("Kuba"));
    }

    @Test
    public void shouldRemoveIfNameStartsWith_K(){
        Set<String> set = new StringHashSet();
        set.add("Kuba");
        set.add("Wojtek");

        assertEquals(true,set.removeIf(s -> s.startsWith("K")));
    }


}
