import java.util.HashMap;

import java.util.*;
// Longest substring with maximum K distinct characters
public class LongestSubstringKDistinct {
    static int findLength(String query, int k){
        if(query == null || query.length() == 0){
            throw new IllegalArgumentException();
        }
        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> distinctCharMap = new HashMap<>();

        for(int windowEnd = 0; windowEnd < query.length(); windowEnd++){
            // current char
            char currentLetter = query.charAt(windowEnd);
            distinctCharMap.put(currentLetter, distinctCharMap.getOrDefault(currentLetter, 0) + 1);
            while(distinctCharMap.size() > k){
                char firstLetter = query.charAt(windowStart);
                distinctCharMap.put(firstLetter, distinctCharMap.get(firstLetter) - 1);
                if(distinctCharMap.get(firstLetter) == 0){
                    distinctCharMap.remove(firstLetter);
                }
                windowStart += 1;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart +1);
        }

       return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}