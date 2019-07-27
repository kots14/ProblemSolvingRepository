import java.io.*;
import java.util.*;
public class PalindromePartition {
    static boolean isPalindrome(String s) { 
        int size = s.length(); 
         
        for (int i=0, j = size - 1; i < size && j > -1; i++, j--) { 
            if (s.charAt(i) != s.charAt(j)) 
                return false; 
        } 
        return true; 
    } 
    static ArrayList<ArrayList<String>> addStrings(ArrayList<ArrayList<String>> v, String s, ArrayList<String> temp, int index) { 
        int len = s.length(); 
        String str = ""; 
        ArrayList<String> current = new ArrayList<>(temp); 
          
        if (index == 0) 
            temp.clear(); 
          
        for (int i = index; i < len; ++i)  { 
            str = str + s.charAt(i); 
            if (isPalindrome(str)) { 
                temp.add(str); 
                  
                if (i + 1 < len) 
                    v = addStrings(v,s,temp,i+1); 
                else 
                    v.add(temp); 
                 
                temp = new ArrayList<>(current); 
            } 
        } 
        return v; 
    } 
       
    public static void main(String args[])  { 
        String s = "abbabc";  
        ArrayList<String> temp = new ArrayList<>(); 
          
        ArrayList<ArrayList<String>> v = new ArrayList<>();
        
        v = addStrings(v, s, temp, 0); 
         
        for(ArrayList<String> i: v) { 
            for(String j: i) { 
                System.out.print(j + " "); 
            } 
            System.out.println(); 
        }
    } 
}