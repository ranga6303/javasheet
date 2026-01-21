package app;

class Solution {

    static char[][] board;
    static String word;
    static char[][] ref;
    

    static Boolean recur(int i, int j, int k) {
        ref[i][j] = '.';
        if (k + 1 >= word.length())
            return true;

        if (((i < board.length) &&
                ((j > 0 && j - 1 < board[i].length && board[i][j - 1] == word.charAt(k + 1)
                        && ref[i][j - 1] == 0 && recur(i, j - 1, k + 1))// left
                        ||
                        (j + 1 < board[i].length && board[i][j + 1] == word.charAt(k + 1)
                                && ref[i][j + 1] == 0 && recur(i, j + 1, k + 1))// right
                ))
                ||
                ((j < board[i].length) &&
                        ((i > 0 && i - 1 < board.length && board[i - 1][j] == word.charAt(k + 1)
                                && ref[i - 1][j] == 0 && recur(i - 1, j, k + 1))// up
                                ||
                                (i + 1 < board.length && board[i + 1][j] == word.charAt(k + 1)
                                        && ref[i + 1][j] == 0 && recur(i + 1, j, k + 1))// down
                        ))) {

            return true;
        }
        ref[i][j] = '\u0000';
        return false;
    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.ref = new char[board.length][board[0].length];

        ref=new char[board.length][board[0].length];
        

        int k = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] == word.charAt(k) && recur(i, j, 0))
                    return true;
            }
        }

        return false;
    }
}

public class leet79 {
    public static void main(String[] args) {

        Solution s = new Solution();
        
        char[][] board = {
        { 'A', 'T', 'C', 'S', 'E', 'Q', 'L', 'W', 'M', 'P' },
        { 'B', 'R', 'A', 'D', 'O', 'O', 'R', 'T', 'S', 'A' },
        { 'C', 'A', 'T', 'T', 'L', 'E', 'S', 'A', 'X', 'W' },
        { 'D', 'O', 'G', 'B', 'I', 'R', 'D', 'S', 'E', 'Y' },
        { 'E', 'L', 'E', 'P', 'H', 'A', 'N', 'T', 'Q', 'Z' },
        { 'F', 'R', 'O', 'G', 'P', 'L', 'A', 'N', 'E', 'R' },
        { 'G', 'O', 'A', 'T', 'M', 'O', 'U', 'S', 'E', 'Q' },
        { 'H', 'O', 'R', 'S', 'E', 'C', 'A', 'T', 'S', 'D' },
        { 'I', 'G', 'U', 'A', 'N', 'A', 'R', 'O', 'W', 'T' },
        { 'J', 'A', 'G', 'U', 'A', 'R', 'Z', 'E', 'B', 'R' }
        };

        String[] words = {
        "ATCV",
        "CAT",
        "DOG",
        "HORSE",
        "GOAT",
        "MOUSE",
        "FROG",
        "ELEPHANT",
        "JAGUAR",
        "ZEBRA",
        "PLANE"
        };

        
        for (int i = 0; i < words.length; i++) {
        System.out.println(words[i] + " exist : " + s.exist(board, words[i]));
        }
        
    }
}

// // left
// if(i<board.length&&j-1<board[board.length].length&&j>0){
// partialcheck=recur(i, j-1, k+1);
// }

// // up
// if(i-1<board.length&&j<board[board.length].length&&i>0){
// partialcheck=recur(i-1, j, k+1);
// }

// // down
// if(i+1<board.length&&j<board[board.length].length){
// partialcheck=recur(i+1, j, k+1);
// }

// // right
// if(i<board.length&&j+1<board[board.length].length){
// partialcheck=recur(i, j+1, k+1);
// }

// left