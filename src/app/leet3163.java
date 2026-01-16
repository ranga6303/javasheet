package app;

import samslib.*;
import java.lang.StringBuilder;

class Solution {

    static StringBuilder sb = new StringBuilder();

    // fully optimized code
    public String compressedStringopt(String word) {
        final int n = word.length();
        final char[] out = new char[n * 2];
        int o = 0;

        char prev = word.charAt(0);
        int count = 1;

        for (int i = 1; i < n; i++) {
            char c = word.charAt(i);
            if (c == prev && count < 9) {
                count++;
            } else {
                
                out[o++] = (char) ('0' + count);
                out[o++] = prev;
                prev = c;
                count = 1;
            }
        }

        out[o++] = (char) ('0' + count);
        out[o++] = prev;

        return new String(out, 0, o);
    }






    public String compressedString(String word) {
    
        if (word == null)
            return null;

        sb.setLength(0);
        int len = word.length(), subcount = 0;
        char c, pre = '*';

        for (int i = 0; i < len; i++) {
            c = word.charAt(i);
            if (pre == c || pre == '*') {
                if (subcount == 9) {
                    sb.append(subcount);
                    sb.append(c);
                    subcount = 0;
                }
                subcount++;
                pre = c;

            } else {
                
                sb.append(subcount);
                sb.append(pre);
                pre = c;
                subcount = 1;

            }

            if (i + 1 == len) {
                sb.append(subcount);
                sb.append(c);
            }

        }

        return sb.toString();

    }
}

public class leet3163 {
    public static void main(String[] args) {
        System.out.println("\nLEET CODE 3163 PROBLEM");
        String[] arr = { "bbbbbbbbbaaaaaaaaaacccccccccc" }, res = new String[arr.length];
        Solution s = new Solution();
        int i = 0;
        for (String str : arr) {
            res[i++] = s.compressedString(str);
        }
        System.out.print("Non compressed");
        Display.array(arr);
        System.out.print("compressd string ");
        Display.array(res);
    }
}

// 3163. String Compression III

// Given a string word, compress it using the following algorithm:

// Begin with an empty string comp. While word is not empty, use the following
// operation:
// Remove a maximum length prefix of word made of a single character c repeating
// at most 9 times.
// Append the length of the prefix followed by c to comp.
// Return the string comp.

// Example 1:

// Input: word = "abcde"

// Output: "1a1b1c1d1e"

// Explanation:

// Initially, comp = "". Apply the operation 5 times, choosing "a", "b", "c",
// "d", and "e" as the prefix in each operation.

// For each prefix, append "1" followed by the character to comp.

// Example 2:

// Input: word = "aaaaaaaaaaaaaabb"

// Output: "9a5a2b"

// Explanation:

// Initially, comp = "". Apply the operation 3 times, choosing "aaaaaaaaa",
// "aaaaa", and "bb" as the prefix in each operation.

// For prefix "aaaaaaaaa", append "9" followed by "a" to comp.
// For prefix "aaaaa", append "5" followed by "a" to comp.
// For prefix "bb", append "2" followed by "b" to comp.

// Constraints:

// 1 <= word.length <= 2 * 105
// word consists only of lowercase English letters.
