//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }

            int x = sc.nextInt();

            if (new Solution().matSearch(mat, x))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static boolean matSearch(int mat[][], int x) {
        // your code here
         // Get the number of rows
        int n = mat.length;
        // Get the number of columns
        int m = mat[0].length;
        // Start from the top-right corner of the matrix
        int row = 0;
        int col = m - 1;
        
        // Loop until we are within the bounds of the matrix
        while (row < n && col >= 0) {
            // If the current element is the target, return true
            if (mat[row][col] == x) {
                return true;
            // If the current element is greater than the target, move left
            } else if (mat[row][col] > x) {
                col--;
            // If the current element is less than the target, move down
            } else {
                row++;
            }
        }
        // If we exit the loop, the target is not in the matrix
        return false;
    }
}