package app;

import java.util.List;
import samslib.Display;
import samslib.Tools;

class Solution {
    
    public void moveZeroes1(int[] nums) {
       int p=-1;
       for(int i=0;i<nums.length;i++){
        if(nums[i]==0&&p<0){
            p=i;
        }
        else if(p>=0&&nums[i]!=0)
            nums[p++]=nums[i];
       }
       if(p>-1){
       while(p<nums.length)nums[p++]=0;
       }
    }

}

public class leet121 {

    static List<int[]> testCases = List.of(
            // Basic cases
            new int[] { 0, 1, 0, 3, 12 },
            new int[] { 1, 0, 2, 0, 3 },
            new int[] { 0, 0, 1, 2 },
            new int[] { 1, 2, 3, 0 },

            // All / none zero
            new int[] { 0, 0, 0, 0 },
            new int[] { 1, 2, 3, 4 },

            // Single & small arrays
            new int[] { 0 },
            new int[] { 5 },
            new int[] { 0, 1 },
            new int[] { 1, 0 },

            // Order preservation
            new int[] { 4, 0, 5, 0, 4, 3 },
            new int[] { 1, 0, 1, 0, 1 },

            // Consecutive zeros
            new int[] { 1, 0, 0, 2, 3 },
            new int[] { 1, 2, 0, 0, 0 },

            // Zeros at extremes
            new int[] { 0, 1, 2, 3 },
            new int[] { 1, 2, 3, 0 },

            // Negative & mixed values
            new int[] { -1, 0, -2, 0, 3 },
            new int[] { 0, -1, 0, -2 },

            // Large / stress patterns
            new int[] { 0, 1, 0, 1, 0, 1, 0, 1 },
            new int[] { 1, 0, 1, 0, 1, 0, 1, 0 },

            // Already stable
            new int[] { 1, 2, 3, 0, 0 },
            new int[] { 0, 0, 1, 2, 3 },

            // Duplicate non-zero values
            new int[] { 2, 0, 2, 0, 2 },
            new int[] { 0, 2, 2, 0, 2 });

    static List<int[]> failingCases = List.of(
            new int[] { 0, 0, 1, 2 },
            new int[] { 1, 0, 2, 0, 3 },
            new int[] { 0, 0, 1, 2, 3 });

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println("test cases:");
        for (int[] arr : testCases)
            Display.array(arr);
        ;

        for (int[] arr : testCases)
            s.moveZeroes1(arr);

        System.out.println("\n\nresults:");
        for (int[] arr : testCases)
            Display.array(arr);
        


        // System.out.println("test cases:");
        // for (int[] arr : failingCases)
        //     Display.array(arr);
        // ;

        // for (int[] arr : failingCases)
        //     s.moveZeroes1(arr);

        // System.out.println("\n\nresults:");
        // for (int[] arr : failingCases)
        //     Display.array(arr);
        

    }
}
