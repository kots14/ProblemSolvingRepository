public class PermutationsOfString {
    static void swap(char[] s, int l, int r) {
        char x = s[l];
        s[l] = s[r];
        s[r] = x;
    }
    static void p(char[] s, int l, int r){
        if (l == r)  
            System.out.println(String.valueOf(s));
        else { 
            for (int i = l; i <= r; i++) { 
                swap(s,l,i); 
                p(s, l+1, r); 
                swap(s,l,i); 
            } 
        } 
    }
    public static void main(String[] args) {
        String s = "abc";
        p(s.toCharArray(), 0, s.length() - 1);
    }
}