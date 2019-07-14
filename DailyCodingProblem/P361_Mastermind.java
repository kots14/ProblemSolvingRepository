import java.util.HashMap;
import java.util.Map;

// Mastermind is a two-player game in which the first player attempts to guess the secret code of the second. 
// In this version, the code may be any six-digit number with all distinct digits.

// Each turn the first player guesses some number, and the second player responds by saying how many digits 
// in this number correctly matched their location in the secret code. For example, if the secret code were 123456, 
// then a guess of 175286 would score two, since 1 and 6 were correctly placed.

// Write an algorithm which, given a sequence of guesses and their scores, determines whether 
// there exists some secret code that could have produced them.

// For example, for the following scores you should return True, since they correspond to the secret code 123456:

// {175286: 2, 293416: 3, 654321: 0}
// However, it is impossible for any key to result in the following scores, so in this case you should return False:

// {123456: 4, 345678: 4, 567890: 4}

//Time complexity : O(n^2)
public class P361_Mastermind {
    static boolean isCloseMatch(String secretCode, String guess, int expectedScore) {
        int count = Integer.MIN_VALUE;
        if(secretCode.length() != guess.length())
            return false;

        for(int i = count = 0; i < guess.length(); i++)
            if(secretCode.charAt(i) == guess.charAt(i))
                count += 1;
        return count == expectedScore;
    }
    static boolean mastermind(String secretCode, HashMap<String, Integer> guesses) {
        boolean isValid = true;
        for(Map.Entry<String, Integer> guess : guesses.entrySet()){ 
            isValid = isValid && isCloseMatch(secretCode, guess.getKey(), guess.getValue());
        }
        return isValid;
    }
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("175286", 2);
        hm.put("293416", 3);
        hm.put("654321", 0);
        System.out.println(mastermind("123456", hm));
        hm.clear();;
        hm.put("123456", 4);
        hm.put("345678", 4);
        hm.put("567890", 4);
        System.out.println(mastermind("123456", hm));
    }
}