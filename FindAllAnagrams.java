import java.util.*;

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        
        //Concept
        //Have hasmap of all anagram match - and initialize with 1
        //Use slow and fast pointer
        //incoming:
            // move the fast pointer by one - get the count from map and decrement if it becomes 0 means we have a match.
        //Shift - increment the slow and fast pointer
        //outgoing:
            // If a char is move out of window, then we need that char so incrment the count. If it becomes 1 then we have lost a match.
        
        // Approach 1 - Sliding Window
        
        
        List<Integer> result = new ArrayList();
        
        HashSet<Character> set = new HashSet();
        int pLength = p.length();
        for(int i =0;i<pLength;i++) {
            set.add(p.charAt(i));
        }
        
        int slowPointer = 0;
        int fastPointer = 0;
        int validCount = 0;
        while(fastPointer<s.length()) {
            char currentChar = s.charAt(fastPointer);
            if(set.contains(currentChar)) {
               validCount++;
            }
            
            if(validCount ==  pLength) {
                result.add(slowPointer);
            }
            
            
            fastPointer++; 
            if(fastPointer - slowPointer > pLength-1) {
                slowPointer++;
                validCount--;
            }
           
        }
        return result;
    }
}
