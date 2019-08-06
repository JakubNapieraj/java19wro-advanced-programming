import HashSet.StringHashSet;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

public class Application {

    public static void main(String[] args) {
        Set<String> set = new StringHashSet();
        set.add("Ala");
        set.add("Alan");
        set.add("Jakub");
        set.add("Marek");
        set.add("Marek");
        System.out.println(set);
        set.addAll(Arrays.asList("Kuba","Marysia", "Michał","Marcin", "Michał", "Wojtek","Bartek","Adam"));

        System.out.println(set.contains("Ala"));
        System.out.println(set);

        set.remove("Kuba");

        System.out.println(set);

    }


    private static void experimentWithArrayList(int size){
        List<Integer> numbers = IntStream.range(0,size)
                .boxed()
                .collect(Collectors.toList());

        for (int i = size/2; i <1.5* size ; i++) {
            boolean contains = numbers.contains(i);

        }
    }  private static void experimentWithHashSet(int size){
        Set<Integer> numbers = IntStream.range(0,size)
                .boxed()
                .collect(toSet());

        for (int i = size/2; i <1.5* size ; i++) {
            boolean contains = numbers.contains(i);

        }
    }
}
