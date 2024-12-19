//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.kthMissing(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int kthMissing(int[] arr, int k) {
        // code here
         int missingCount = 0;  // Count of missing numbers
        int lastChecked = 0;  // Last checked number (starts from 0)

        for (int num : arr) {
            // Count missing numbers before the current array element
            while (lastChecked + 1 < num) {
                missingCount++;
                lastChecked++;

                // If we've found the kth missing number, return it
                if (missingCount == k) {
                    return lastChecked;
                }
            }
            lastChecked = num; // Update the last checked number
        }

        // If the kth missing number is after the last array element
        return lastChecked + (k - missingCount);
    }
}