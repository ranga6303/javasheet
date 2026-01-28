package app;

import samslib.RandomGen;

import java.util.Scanner;

import samslib.Display;

class Solution {
    public void rotate(int[][] matrix) {
        int v1, v2;
        for (int i = 0; i < matrix.length / 2; i++) {
            System.out.println("iter value:" + i);
            for (int j = i; j < matrix.length - 1 - i; j++) {

                if (i == 0 && j == 0) {
                    System.out.println("subitration :" + j);
                    v1 = matrix[i][j];

                    v2 = matrix[i][matrix.length - j - 1];
                    matrix[i][matrix.length - j - 1] = v1;
                    Display.array(matrix);

                    v1 = matrix[matrix.length - 1 - i][matrix.length - i - 1];
                    matrix[matrix.length - 1 - i][matrix.length - j - 1] = v2;
                    Display.array(matrix);

                    v2 = matrix[matrix.length - 1][j];
                    matrix[matrix.length - 1][j] = v1;
                    Display.array(matrix);

                    matrix[i][j] = v2;
                    Display.array(matrix);
                }

                else {
                    System.out.println("subitration :" + j);
                    v1 = matrix[i][j];

                    // v2 = matrix[i][matrix.length - j - 1];
                    // matrix[i][matrix.length - j - 1] = v1;
                    // Display.array(matrix);

                    v2 = matrix[matrix.length - 1 - i][matrix.length - i - 1];
                    matrix[matrix.length - 1 - i][matrix.length - j - 1] = v1;
                    Display.array(matrix);

                    v1 = matrix[matrix.length - 1][j];
                    matrix[matrix.length - 1][j] = v2;
                    Display.array(matrix);

                    v2 = matrix[i][j - i];

                    matrix[i][j] = v2;
                    Display.array(matrix);
                }

            }
        }

        // Display.array(matrix);
    }
}

public class leet48 {
    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        int[][] arr = sc.nextInt() == 1
                ? new RandomGen().array(3, 3, 1, 9)
                : new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        sc.close();

        Display.array(arr);
        s.rotate(arr);
    }
}
