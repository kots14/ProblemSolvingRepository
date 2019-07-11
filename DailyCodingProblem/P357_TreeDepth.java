// Daily Coding Problem: Problem #357 [Hard]
// --------------------------------------------
// This problem was asked by LinkedIn.

// You are given a binary tree in a peculiar string representation. Each node is written in the form (lr), where l corresponds to the left child and r corresponds to the right child.

// If either l or r is null, it will be represented as a zero. Otherwise, it will be represented by a new (lr) pair.

// Here are a few examples:

// A root node with no children: (00)
// A root node with two children: ((00)(00))
// An unbalanced tree with three consecutive left children: ((((00)0)0)0)
// Given this representation, determine the depth of the tree.

import java.io.*;
import java.util.*;
public class P357_TreeDepth {
    
    static int maxTreeDepth(String s) {
        if(s.equals("") || s == null)
            return 0;
        char[] a = s.toCharArray();
        int count = 1; 
        int maxCount = Integer.MIN_VALUE;
        for(int i = 0; i < a.length - 1; i++) {
            if(a[i] == a[i + 1])
                count++;
            else
                count = 0;
            maxCount = Math.max(maxCount, count);    

        }

        return maxCount;
    }
    public static void main(String[] args) {
        System.out.println(maxTreeDepth("(00)") == 1);
        System.out.println(maxTreeDepth("((00)(00))") == 2);
        System.out.println(maxTreeDepth("((((00)0)0)0)") == 4);
        System.out.println(maxTreeDepth("((00)0)") == 2);
        System.out.println(maxTreeDepth("") == 0);
    }
}