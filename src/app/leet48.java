package app;

import samslib.RandomGen;

import java.util.Scanner;

import samslib.Display;

class Solution {
    public void rotate(int[][] matrix) {
        int  v1, v2;
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix.length - i; j++) {
                

                v1 = matrix[i][j];

                v2 = matrix[i][matrix.length - i - 1];
                matrix[i][matrix.length - i - 1] = v1;

                v1=matrix[matrix.length-1-i][matrix.length-i-1];
                matrix[matrix.length-1-i][matrix.length-i-1]=v2;

                v2=matrix[matrix.length-1][j];
                matrix[matrix.length-1][j]=v1;

                matrix[i][j]=v2;


            }
        }

        Display.array(matrix);
    }
}

public class leet48 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] arr = new Scanner(System.in).nextInt()==1?
        new RandomGen().array(3, 3, 1, 9)
        :
        new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        Display.array(arr);
        s.rotate(arr);
    }
}
