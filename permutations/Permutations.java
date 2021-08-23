package permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://www.codewars.com/kata/5254ca2719453dcc0b00027d

public class Permutations {

    public static List<String> singlePermutations(String s) {
        Set<String> results = new HashSet<>();
        permute(s, 0, s.length(), results);


        return new ArrayList<>(results);
    }

    private static void permute(String s, int start, int end, Set<String> results) {

        if(start + 1 == end) {
            results.add(s);
        }
        else {
            for (int i = start; i < end; i++) {
                s = swapCharsInString(s, start, i);
                permute(s, start + 1, end, results);
                s = swapCharsInString(s, start, i);
            }
        }
    }

    private static String swapCharsInString(String s, int a, int b) {
        char [] chars = s.toCharArray();
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
        return String.valueOf(chars);
    }
}
