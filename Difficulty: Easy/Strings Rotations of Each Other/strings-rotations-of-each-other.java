//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {

        // taking input using BufferedReader class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking total count of testcases
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // Reading the two Strings
            String s1 = br.readLine();
            String s2 = br.readLine();

            // Creating an object of class Rotate
            Solution obj = new Solution();

            // calling areRotations method
            // of class Rotate and printing
            //"1" if it returns true
            // else "0"
            if (obj.areRotations(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        // Your code here
          String temp=s2+"$"+s1+s1;
        int n=temp.length();
        int arr[]=new int[n];
        int i=1;
        int len=0;
        while(i<n){
            if(temp.charAt(i)==temp.charAt(len)){
                len++;
                arr[i]=len;
                i++;
            }else {
                if(len>0){
                    len=arr[len-1];
                }else {
                    i++;
                }
            }
        }
        for(int a: arr) {
        	if(a==s1.length())return true;
        }
        return false;
        
    }
}