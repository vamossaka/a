import org.junit.Test;
import static org.junit.Assert.*;
public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    public void testisPalindrome() {
        OffByOne a=new OffByOne();
        assertTrue(palindrome.isPalindrome("aabbaa"));
        assertFalse(palindrome.isPalindrome("acba"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("&"));
        assertTrue(palindrome.isPalindrome("falke",a));
        assertFalse(palindrome.isPalindrome("aaabbbaaa",a));
        assertTrue(palindrome.isPalindrome("",a));
        assertTrue(palindrome.isPalindrome("&",a));
    }

}