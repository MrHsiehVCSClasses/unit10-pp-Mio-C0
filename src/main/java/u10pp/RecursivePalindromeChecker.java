package u10pp;

public class RecursivePalindromeChecker {

    public static boolean isPalindrome(String word) {
    // base case
    if (word.length() == 0 || word.length() == 1) {
        return true;
    }

    // check for anything other than base case
    if(word.charAt(0) == word.charAt(word.length()-1)) {
        return isPalindrome(word.substring(1, word.length()-1));
    }

    // return false if word isn't a palindrome
    return false;
    }
}

