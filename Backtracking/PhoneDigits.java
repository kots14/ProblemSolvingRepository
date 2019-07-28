public class PhoneDigits {
    static String[] letters = {"", "", "abc", "def", "ghi", "jkl", 
                               "mno", "pqrs", "tuv", "wxyz"}; 
  
    static void  getWords(int number[], int current, char output[], int n) { 
        if (current == n) { 
            System.out.print(String.valueOf(output)); 
            return ; 
        } 
        
        String s = letters[number[current]];
        for (int i=0; i < s.length(); i++) { 
            output[current] = letters[number[current]].charAt(i); 
            getWords(number, current + 1, output, n); 
            if (number[current] == 0 || number[current] == 1) 
                return; 
        } 
    } 
  
    public static void main(String[] args) {
        int number[] = {2, 3, 4}; 
        int n = number.length; 
        char[] result = new char[n+1]; 
        getWords(number, 0, result, n); 
    }
}