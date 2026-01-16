package app;

import java.util.HashMap;

public class leet3 {
    static int fun1(String s) {
        HashMap<Integer, Character> map = new HashMap<>();
        HashMap<Character, Integer> revmap = new HashMap<>();
        if (s == null)
            return 0;
        int len = s.length(), maincount = 0, subcount = 0, winindex = 0, prewin;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsValue(c) && revmap.get(c) >= winindex) {
                maincount = maincount < subcount ? subcount : maincount;
                prewin = winindex;
                winindex = revmap.get(c) + 1;
                subcount -= (winindex - prewin);
                map.put(i, c);
                subcount++;
                revmap.put(c, i);
            }

            else {
                map.put(i, c);
                revmap.put(c, i);
                subcount++;
            }

            if (i + 1 == len) {
                maincount = maincount < subcount ? subcount : maincount;
            }

        }
        return maincount;
    }

    // fully optimized function
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int[] arr = new int[256];
        for (int i = 0; i < 256; i++)
            arr[i] = -1;
        int maxLen = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (arr[c] >= start) {
                start = arr[c] + 1;
            }
            arr[c] = i;
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {

        String str1 = "";
        System.out.println("test case 1 (empty): " + fun1(str1));

        String str2 = "a";
        System.out.println("test case 2 (single char): " + fun1(str2));

        String str3 = "aa";
        System.out.println("test case 3 (double same): " + fun1(str3));

        String str4 = "ab";
        System.out.println("test case 4 (double different): " + fun1(str4));

        String str5 = "aaa";
        System.out.println("test case 5 (all same): " + fun1(str5));

        String str6 = "abcabcbb"; // from prompt
        System.out.println("test case 6: " + fun1(str6));

        String str7 = "bbbbb"; // from prompt
        System.out.println("test case 7: " + fun1(str7));

        String str8 = "pwwkew"; // from prompt
        System.out.println("test case 8: " + fun1(str8));

        String str9 = "dvdf";
        System.out.println("test case 9: " + fun1(str9));

        String str10 = "abba";
        System.out.println("test case 10: " + fun1(str10));

        String str11 = "abca";
        System.out.println("test case 11: " + fun1(str11));

        String str12 = "abcdef";
        System.out.println("test case 12 (all unique): " + fun1(str12));

        String str13 = "1234567890";
        System.out.println("test case 13 (digits): " + fun1(str13));

        String str14 = "a b c";
        System.out.println("test case 14 (spaces): " + fun1(str14));

        String str15 = "a!b@c#";
        System.out.println("test case 15 (symbols): " + fun1(str15));

        String str16 = "AaAaAa";
        System.out.println("test case 16 (case-sensitive): " + fun1(str16));

        String str17 = "aaaaabc";
        System.out.println("test case 17 (prefix dup): " + fun1(str17));

        String str18 = "abcaaaa";
        System.out.println("test case 18 (suffix dup): " + fun1(str18));

        String str19 = "tmmzuxt";
        System.out.println("test case 19 (classic tricky): " + fun1(str19));

        String str20 = "anviaj";
        System.out.println("test case 20 (classic tricky): " + fun1(str20));

        String str21 = "pwawekpew";
        System.out.println("test case 21 (your example): " + fun1(str21));

    }
}

// Given a string s, find the length of the longest substring without duplicate
// characters.

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3. Note that "bca" and
// "cab" are also correct answers.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a
// substring.

// Constraints:

// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.
