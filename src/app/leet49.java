package app;
// import samslib.*;

import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs.length == 0) {
            return new ArrayList<>();
        }

        if (strs.length == 1) {
            List<List<String>> res = new ArrayList<>();
            res.add(new ArrayList<>(Arrays.asList(strs[0])));
            return res;
        }


        int[][] arr=new int[strs.length][26];

        for(int i=0;i<strs.length;i++){
            String s=strs[i];
            int slen=s.length();
            for(int j=0;j<slen;j++)arr[i][s.charAt(j)-'a']++;
        }


        int[] temp;
        List<List<String>> op = new ArrayList<>();
        boolean status = true;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < strs.length; i++) {
         
            if(set.contains(i))continue;

            
            String s = strs[i];
            int slen = s.length();
            List<String> subop=new ArrayList<>();
            subop.add(s);
            
            if(slen==0){
                
                for (int k = i + 1; k < strs.length; k++){
                    if(strs[k].length()==0){
                        set.add(k);
                        subop.add("");
                    }
                }

            }
            else{

                
                
                for (int k = i + 1; k < strs.length; k++) {
    
                    if (set.contains(k)) continue;
    
                    status = true;
                    temp = Arrays.copyOf(arr[i], arr[i].length);
                    String str = strs[k];
    
                    for (int l = 0; l < str.length(); l++) {
                        char c = str.charAt(l);
                        temp[c - 'a']--;

                    }
    
                    for (int l = 0; l < temp.length; l++) {
                        if (temp[l] != 0) {
                            status = false;
                            break;
                        }
                    }
                    if (status) {
                        set.add(k);
                        subop.add(str);
                    }
            }

            }
            if(!subop.isEmpty())op.add(subop);
        }

        return op;
    }


    // public void groupAnagrams(String[] strs){
    //     int[][] arr=new int[strs.length][26];

    //     for(int i=0;i<strs.length;i++){
    //         String s=strs[i];
    //         int slen=s.length();
    //         for(int j=0;j<slen;j++)arr[i][s.charAt(j)-'a']++;
    //     }

    //     Display.array(arr);

    // }

}



public class leet49 {
    public static void main(String[] args) {

        Solution sol = new Solution();
        


        // Test Case A
        String[] A = {"", "a", ""};
        System.out.println("A: " + Arrays.toString(A));
        System.out.println(sol.groupAnagrams(A));
        System.out.println();

        // Test Case B
        String[] B = {"ab", "ba", "abc", "cab", "bca", "a"};
        System.out.println("B: " + Arrays.toString(B));
        System.out.println(sol.groupAnagrams(B));
        System.out.println();

        // Test Case C
        String[] C = {"x", "y", "x", "y", "xy", "yx"};
        System.out.println("C: " + Arrays.toString(C));
        System.out.println(sol.groupAnagrams(C));
        System.out.println();

        // Test Case D
        String[] D = {"aaa", "aa", "a", "aaa", "aa"};
        System.out.println("D: " + Arrays.toString(D));
        System.out.println(sol.groupAnagrams(D));
        System.out.println();

        // Test Case E
        String[] E = {"listen", "silent", "enlist", "google", "gooegl", "abc"};
        System.out.println("E: " + Arrays.toString(E));
        System.out.println(sol.groupAnagrams(E));
        System.out.println();

        // Test Case F
        String[] F = {"", "", "a", "", "a"};
        System.out.println("F: " + Arrays.toString(F));
        System.out.println(sol.groupAnagrams(F));
        System.out.println();

        // Test Case G
        String[] G = {"z"};
        System.out.println("G: " + Arrays.toString(G));
        System.out.println(sol.groupAnagrams(G));
        System.out.println();

        // Test Case H
        String[] H = {"abcd", "dcba", "bcda", "dabc", "efgh"};
        System.out.println("H: " + Arrays.toString(H));
        System.out.println(sol.groupAnagrams(H));
        System.out.println();

        // Test Case I
        String[] I = {"aabb", "bbaa", "abab", "baba", "abba"};
        System.out.println("I: " + Arrays.toString(I));
        System.out.println(sol.groupAnagrams(I));
        System.out.println();

        // Test Case J
        String[] J = {"rat", "tar", "art", "car"};
        System.out.println("J: " + Arrays.toString(J));
        System.out.println(sol.groupAnagrams(J));
        System.out.println();
    }
}

   