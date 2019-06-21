import java.io.*;
import java.util.*;

//Problem : https://www.geeksforgeeks.org/find-possible-words-phone-digits/

public class AllPossibleWordsFromPhoneDigits {
    static String[] num = {"", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static void printAllWords(String number, int currentDigit, char[] output, int N) {
        if(currentDigit == N) {
            System.out.print(String.valueOf(output)+" ");
            return;
        }

        int index = Character.getNumericValue(number.charAt(currentDigit));
        for (int i=0; i < num[index].length(); i++) { 
            output[currentDigit] = num[index].charAt(i); 
            printAllWords(number, currentDigit + 1, output, N); 
            int temp = Character.getNumericValue(number.charAt(currentDigit));
            if (temp == 0 || temp == 1) 
                return; 
        } 
    }

    static void printAllWords(String number) {
        char[] a = new char[number.length()];
        printAllWords(number, 0, a, number.length()); 
    }
    public static void main(String[] args) {
        String number = "234";
        printAllWords(number);
    }
}