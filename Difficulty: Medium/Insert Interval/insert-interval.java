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
            int h[] = new int[2];
            h[0] = sc.nextInt();
            h[1] = sc.nextInt();
            Solution obj = new Solution();
            ArrayList<int[]> ans = obj.insertInterval(a, h);
            System.out.print("[");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print("[");
                System.out.print(ans.get(i)[0] + "," + ans.get(i)[1]);
                System.out.print("]");
                if (i != ans.size() - 1) System.out.print(",");
            }
            System.out.println("]");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        // code here
         
        ArrayList<int[]> list=new ArrayList<>();
        
        for(int[] a:intervals)
        {
            list.add(new int[]{a[0],a[1]});
        }
        
        list.add(new int[]{newInterval[0],newInterval[1]});
        
        list.sort((a,b)->Integer.compare(a[0],b[0]));
        
        ArrayList<int[]> ans=new ArrayList<>();
        
        int curstart=0;
        
        int curend=0;
        
        int start=0;
        
        int end=0;
        
        int index=0;
        
        for(int[] a:list)
        {
            index++;
            if(index==1)
            {
                start=a[0];
                end=a[1];
                
                continue;
            }
            
            curstart=a[0];
            
            curend=a[1];
            
            if(end >= curstart && end <= curend)
            {
                end=Math.max(end,curend);
            }
            
            else if( end >= curstart && end >= curend)
            {
                continue;
            }
            else
            {
                ans.add(new int[]{start,end});
                start=curstart;
                
                end=curend;
            }
            
        }
        
        ans.add(new int[]{start,end});
        
        return ans;
    }
}
