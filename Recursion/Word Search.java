// 79. Word Search
// Solved
// Medium
// Topics
// Companies
// Given an m x n grid of characters board and a string word, return true if word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

// Example 1:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true
// Example 2:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// Output: true
// Example 3:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
// Output: false

// Approach:  We are going to solve this by using backtracking, in this approach first we will linearly search the entire matrix to find the first letters matching our given string. If we found those letters then we can start backtracking in all four directions to find the rest of the letters of the given string.

// Step 1: Find the first character of the given string.

// Step 2: Start Backtracking in all four directions until we find all the letters of sequentially adjacent cells.

// Step 3: At the end, If we found our result then return true else return false.

// Edge cases: Now think about what will be our stopping condition, we can stop or return false if we reach the end of the boundaries of the matrix or the letter at which we are making recursive calls is not the required letter.

// We will also return if we found all the letters of the given word i.e. we found the number of letters equal to the length of the given word.

// NOTE: Do not forget that we cannot reuse a cell again.

// That is, we have to somehow keep track of our position so that we cannot find the same letter again and again.

// In this approach, we are going to mark visited cells with some random character that will prevent us from revisiting them again and again.

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        int index = 0;

        //first search the first character
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(board[i][j] == word.charAt(index)) {
                    if(searchNext(board, word, i, j, index, m, n))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean searchNext(char[][] board, String word, int row, int col, int index, int m, int n){
        //if index reaches at the end that means we have found the word
        if(index == word.length()) {
            return true;
        }

        //checking the boundaries if the character at which we are places is not the required charater
        if(row < 0 || col < 0 || row == m || col == n || board[row][col] != word.charAt(index) || board[row][col] == '!'){
            return false;
        }

        //this is to prevent resuing of the same charater
        char c = board[row][col];
        board[row][col] = '!';

        //top direction
        boolean top = searchNext(board, word, row-1, col, index+1, m, n);
        //right direction
        boolean right = searchNext(board, word, row, col+1, index+1, m, n);
        //bottom direction
        boolean bottom = searchNext(board, word, row+1, col, index+1, m, n);
        //left direction
        boolean left = searchNext(board, word, row, col-1, index+1, m, n);

        board[row][col] = c; //undo change

        return top || right || bottom || left;
    }
}