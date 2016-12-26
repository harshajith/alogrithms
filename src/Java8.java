
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Harsha on 24/12/16.
 */
public class Java8 {

    public Java8() {
    }

    public void loopMap(){

        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        items.forEach((k,v) -> {
            System.out.println(k);
        });
    }

    public static void main(String[] args){

        List<String> lines = Arrays.asList("SAM", "PAT", "Hala");
        List<String> result = lines.stream().filter(x -> !x.equals("Hala")).collect(Collectors.toList());
        result.forEach(x-> System.out.println(x));
        Java8 java8 = new Java8();
        java8.loopMap();
    }
}
