import java.util.*;
import java.util.stream.*;

public class Integer_Permutation {

    /**
     * The following is the method where the solution shall be written
     */
    public static String solution(String strIn) throws NumberFormatException {
        // Used an array list to get any length of integers from the input string 
        ArrayList input = new ArrayList();
        for (int i = 0; i < strIn.length(); i++) {
            char c = strIn.charAt(i);
            if (Character.isDigit(c)) {
                input.add(c);
            }
        }
        // The input is not of type string, so a collector is used
        String listString = (String) input.stream().map(Object::toString).collect(Collectors.joining(""));

        if (listString.equals("")) {
            return "No Integers Found";
        } else {
            Set<String> set = permute(listString);
            // Quickly ensured that the list is in reverse order as required
            List list = new ArrayList(set);
            Collections.sort(list, Collections.reverseOrder());

            String resultSet = (String) list.stream().map(Object::toString).collect(Collectors.joining(","));
            return resultSet;
        }
    }

    public static Set<String> permute(String chars) {
        // Used sets to eliminate duplicates 
        Set<String> set = new TreeSet<String>();

        // Termination condition: only 1 permutation for a string of length 1
        if (chars.length() == 1) {
            set.add(chars);
        } else {
            // Each character has a chance to be the first in the permuted string
            for (int i = 0; i < chars.length(); i++) {
                // Remove the character at index i from the string
                String pre = chars.substring(0, i);
                String post = chars.substring(i + 1);
                String remaining = pre + post;

                // Recurse to find all the permutations of the remaining chars
                for (String permutation : permute(remaining)) {
                    // Concatenate the first character with the permutations of the remaining chars
                    set.add(chars.charAt(i) + permutation);
                }
            }
        }
        return set;
    }

    public static void main(String args[]) {
        System.out.println(solution("A 3B2 C6D"));
    }

}
