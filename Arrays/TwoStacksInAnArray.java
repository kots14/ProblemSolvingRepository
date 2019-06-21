import java.io.*;
import java.util.*;


//Problem : https://www.geeksforgeeks.org/implement-two-stacks-in-an-array/

public class TwoStacksInAnArray {
    static class TwinStack<T> {
        Object a[] = null;
        int DEFAULT_SIZE = 20;
        int top1 = Integer.MIN_VALUE; // to be assigned with the left index
        int top2 = Integer.MAX_VALUE; // to be assigned with the right index
        public TwinStack() {
            a = new Object[DEFAULT_SIZE];
            top1 = -1;
            top2 = DEFAULT_SIZE;
        }
        public TwinStack(int size) {
            a = new Object[size];
            top1 = -1;
            top2 = size;
        }
        public void push1(T element) throws Exception {
            if((top1 + 1) < top2) {
                top1 += 1;
                a[top1] = element;
            } else {
                throw new Exception("Stack 1 overflow");
            }
        }

        public void push2(T element) throws Exception {
            if((top2 - 1) > top1) {
                top2 -= 1;
                a[top2] = element;
            } else {
                throw new Exception("Stack 2 overflow");
            }
                
        }

        public T pop1() throws Exception {
            T output = null;
            if(top1 > -1) {
                output = (T) a[top1--];
            }
            if(output == null)
                throw new Exception("Stack 1 underflow");
            return output;
        }

        public T pop2() throws Exception {
            T output = null;
            if(top2 < a.length) {
                output = (T) a[top2++];
            }
            if(output == null)
                throw new Exception("Stack 2 underflow");
            return output;
        }

        public T peek1() {
            T output = null;
            if(top1 > -1) {
                output = (T) a[top1];
            }
            return output;
        }

        public T peek2() {
            T output = null;
            if(top2 < a.length) {
                output = (T) a[top2];
            }
            return output;
        }

        public boolean isStack1Empty() {
            return (top1 == -1);
        }
        public boolean isStack2Empty() {
            return (top2 == a.length);
        }
        public int stack1Size() {
            return (top1 == -1)? 0 : (top1 + 1);
        }
        public int stack2Size() {
            return (top2 == a.length)? 0 : (a.length - top2);
        }
        public int size() {
            //return stack1Size() + stack2Size();
            return 
                ((top1 == -1)? 0 : (top1 + 1)) 
                + ((top2 == a.length)? 0 : (a.length - top2));
        }
        public boolean isEmpty() {
            //return (isStack1Empty() && isStack2Empty());
            return ((top1 == -1) && (top2 == a.length));
        }
    }
    public static void main(String[] args) throws Exception {
        TwinStack<Integer> ts = new TwinStack<>(20);
        for(int i = 0; i < 20; i++) {
            ts.push1(i);
            i = i + 1;
            ts.push2(i);
        }

        System.out.println("Twin stack :-");
        System.out.println("  size : " + ts.size());
        System.out.println("  is empty : " + ts.isEmpty());
        System.out.println("Stack 1 :-");
        System.out.println("  size : " +ts.stack1Size());
        System.out.println("  is empty : " +ts.isStack1Empty());
        System.out.println("  top element : " +ts.peek1());
        while(!ts.isStack1Empty()){
            System.out.print("  "+ts.pop1());
        }
        System.out.println("\n  is empty : " +ts.isStack1Empty());

        System.out.println("\nStack 2 :-");
        System.out.println("  size : " +ts.stack2Size());
        System.out.println("  is empty : " +ts.isStack2Empty());
        System.out.println("  top element : " +ts.peek2());
        while(!ts.isStack2Empty()){
            System.out.print("  "+ts.pop2());
        }
        System.out.println("\n  is empty : " +ts.isStack2Empty());

        System.out.println("Twin stack :-");
        System.out.println("  size : " + ts.size());
        System.out.println("  is empty : " + ts.isEmpty());
    
    } 
}