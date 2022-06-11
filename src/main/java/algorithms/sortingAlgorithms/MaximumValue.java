package algorithms.sortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumValue {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        // 50, 1, 10
        // 50, 1, 19
        // 678, 65
        // 678, 69
        strings.add("50");
        strings.add("1");
        strings.add("19");

        Collections.sort(strings, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        for(String s : strings) {
            System.out.print(s);
        }
    }
}
