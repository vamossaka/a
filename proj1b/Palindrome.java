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
       int n=word.length();
       return helper(pal,0,n-1);
    }
    private boolean helper(Deque tar,int start,int end){
        if(start==end)
            return true;
        if(helper(tar,start+1,end-1)&&tar.get(start)==tar.get(end))
        {
            return true;
        }
        else
            return false;
    }
    public boolean isPalindrome(String word, CharacterComparator cc){
        int n=word.length();
        Deque pal=wordToDeque(word);
        int start=0,end=n-1;
        while (start<end)
        {
            if(!cc.equalChars((char) pal.get(start),(char) pal.get(end)))
            return false;
        }
        return true;
    }

}
