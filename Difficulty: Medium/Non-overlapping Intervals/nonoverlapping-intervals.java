//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minRemoval(a);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minRemoval(int intervals[][]) {
          // code here
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int overlapped = 0;
        int prev_end = intervals[0][1]; 
        
        for (int i = 1; i < intervals.length; i++) {
            int curr_start = intervals[i][0];
            int curr_end = intervals[i][1];
            
            if (curr_start < prev_end) {
                overlapped++;
                prev_end = Math.min(prev_end, curr_end);
            } else {
                prev_end = curr_end;
            }
        }
        return overlapped;
    }
}
