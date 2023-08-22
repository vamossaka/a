import java.util.ArrayDeque;
import java.util.LinkedList;

public class Palindrome {
    public Deque<Character> wordToDeque(String word)
    {
        int n=word.length();
        Deque<Character> deque=new LinkedListDeque<>();
        for(int i=0;i<=n-1;i++)
        {
            char p=word.charAt(i);
            deque.addLast(p);
        }
        return deque;
    }
    public boolean isPalindrome(String word)
    {
        Deque pal=wordToDeque(word);
        while (pal.size()>1)
        {
            if(pal.removeFirst()!=pal.removeLast())
                return false;
        }
        return true;
    }



    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque pal=wordToDeque(word);
        while (pal.size()>1)
        {
            if(!cc.equalChars((char) pal.removeFirst(),(char) pal.removeLast()))
            return false;
        }
        return true;
    }

}
