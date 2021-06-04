// Time Complexity : O(K*(3^n))
//              - n is the length of the word that we are searching.
//              - 3^n is the time complexity of the findWord function which performs the backtracking.
//              - k is number of time that we invoke the above function. For each occurrence of the starting char that we find in the board, we invoke the above function.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Fumbled a little when passing index value of the helper function in for loop.


// Your code here along with comments explaining your approach

public class WordSearch {
    public boolean found;
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    
    public boolean exist(char[][] board, String word) {
        
        if(word.length() == 0) return true;
        
        if(board == null || board.length == 0) return false;
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                findWord(board, word, 0, i, j);
            }
        }
        return found;
    }
    
    public void findWord(char[][] board, String word, int index, int i, int j){
        // base case
        // If we successfully reached the end of the string then we have found the word in the given board.
        if(index == word.length()){
            found = true;
            return;
        }
        
        // If index out of bounds or if the position is already visited then return the recursion call.
        if(i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == '.'){
            return;
        }
        
        // logic
        // If we are able to match the current character with the char at given index then we recuse down to find characters at next index.
        if(board[i][j] == word.charAt(index)){
            // action
            char temp = board[i][j];
            board[i][j] = '.';

            // recurse
            for(int[] dir: dirs){
                findWord(board, word, index+1, i+dir[0], j+dir[1]);
            }

            // backtrack
            board[i][j] = temp;
        }
        
    }
}
