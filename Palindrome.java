/** Checks if a given string is a palindrome. */
public class Palindrome {

	public static void main(String[]args) {
    	System.out.println(isPalindrome(args[0]));
    }
	
	/** Checks if the given string is a palindrome. */
	public static boolean isPalindrome(String str) {
		int len = str.length();
		if(len == 1 || len == 0) return true;
		if(str.charAt(0) != str.charAt(len - 1)) return false;
		return isPalindrome(str.substring(1, len - 1));
    }
}