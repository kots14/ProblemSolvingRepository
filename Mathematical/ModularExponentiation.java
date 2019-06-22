import java.io.*;
import java.util.*;

//Solutions from : 
//https://www.geeksforgeeks.org/modular-exponentiation-power-in-modular-arithmetic/
//Modular Exponentiation (Power in Modular Arithmetic)
//Given three numbers x, y and p, compute (x^y) % p.



public class ModularExponentiation {
    static int power(int x, int y, int p) {
        int res = 1;       
        x = x % p;      
        while (y > 0) { 
            // If y is odd, multiply x with result 
            if ((y & 1) == 1) 
                res = (res * x) % p; 
    
            // y must be even now 
            y = y >> 1; // y = y/2 
            x = (x * x) % p;   
        } 
        return res; 
    }

    //For recursive implementation :
    // Property 1:
    // (m * n) % p has a very interesting property:
    // (m * n) % p =((m % p) * (n % p)) % p

    // Property 2:
    // if b is even:
    // (a ^ b) % c = ((a ^ b/2) * (a ^ b/2))%c ? this suggests divide and conquer
    // if b is odd:
    // (a ^ b) % c = (a * (a ^( b-1))%c

    // Property 3:
    // If we have to return the mod of a negative number x whose absolute value is less than y:
    // then (x + y) % y will do the trick
    static int recPower(int x, int y, int p) {
        if( x == 0)
            return 0;
        if(y == 0)
            return 1;
        long temp = Integer.MIN_VALUE;
        if((y & 1) == 1) {
            temp = x % p;
            temp = (temp * recPower(x, y - 1, p) % p) % p;
        } else {
            temp = recPower(x, y / 2, p);  
            temp = (temp * temp) % p;  
        }

        return (int)((temp + p) % p);
    }
    
    public static void main(String[] args) {
        int output = power(2, 5, 6);
        System.out.println(output);
        output = recPower(2, 5, 6);
        System.out.println(output); 
    }
}