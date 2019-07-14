import java.io.*;
import java.util.*;
// https://practice.geeksforgeeks.org/viewSol.php?subId=17049304&pid=700570&user=KoustavGhosh1
public class ReverseAStringUsingStack {
    static void reverse(String str){
        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i =0 ; i < str.length(); i++) {
            s.push(str.charAt(i));
        }
        
        while(!s.isEmpty()) {
            char c = s.pop();
            sb.append(c);
        }
        
        str = sb.toString();
        System.out.println(str);
    }
    public static void main(String[] args) {
        reverse("hello");
        reverse("hello=world");
    }
}