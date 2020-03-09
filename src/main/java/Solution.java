import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    public static void main(String[] args) {
        String base = "taxicab";
        String sub = "abc";

        // Can sub string be arrange in a way that it is the substring of the base string?
        // Reorder "abc" --> "cab" and then "cab" is a substring of "taxicab" so we return TRUE
        // Otherwise FALSE
        findCombination(sub,"",base);

    }

    static void findCombination(String str, String ans,String baseStr)
    {
        if (str.length() == 0) {
            System.out.println(ans + " is sub string :"+baseStr.contains(ans));
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            // Recurvise call
            findCombination(ros, ans + ch,baseStr);
        }
    }
}