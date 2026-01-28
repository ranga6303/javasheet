package app;
import java.util.LinkedHashMap;
class Solution {
    public int firstUniqChar(String s) {
        LinkedHashMap<Integer,Character> m=new LinkedHashMap<>();
        int len=s.length();
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            if(m.containsValue(c))m.values().remove(c);
            else
            m.put(i,c);
            
        }
        return m.isEmpty()?-1:m.entrySet().iterator().next().getKey();
    }
}

public class leet387 {

    
    public static void main(String[] args) {
    
        Solution sol = new Solution();
    
        System.out.println(sol.firstUniqChar("leetcode"));        // Expected: 0
        System.out.println(sol.firstUniqChar("loveleetcode"));    // Expected: 2
        System.out.println(sol.firstUniqChar("aabb"));            // Expected: -1
        System.out.println(sol.firstUniqChar("z"));               // Expected: 0
        System.out.println(sol.firstUniqChar("abc"));             // Expected: 0
        System.out.println(sol.firstUniqChar("aadadaad"));        // Expected: -1
    }
}
