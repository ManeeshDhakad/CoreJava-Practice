package com.ds.string;

import java.util.HashMap;
import java.util.Map;

public class LargestSubStringUniqueChar {
	public static String largestSubString(String s) {
		Map<Character, Integer> visitedMap = new HashMap<Character, Integer>();
		
		visitedMap.put(s.charAt(0), 0);
		
        int maxlen = 1;    // result 
        int start = 0;
        int currentStart = 0; // starting point of current substring. 
        int i;
        
        for(i = 1; i < s.length(); i++) {
        	// If this character is not present in hash, 
            // then this is first occurrence of this 
            // character, store this in hash. 
        	char ch = s.charAt(i);
        	if(visitedMap.containsKey(ch)) {
                // If this character is present in hash then 
                // this character has previous occurrence, 
                // check if that occurrence is before or after 
                // starting point of current substring. 
                if (visitedMap.get(ch) >= currentStart) { 
      
                    // find length of current substring and 
                    // update maxlen and start accordingly. 
                    if (maxlen < i - currentStart) { 
                        maxlen = i - currentStart; 
                        start = currentStart; 
                    } 
      
                    // Next substring will start after the last 
                    // occurrence of current character to avoid 
                    // its repetition. 
                    currentStart = visitedMap.get(ch) + 1; 
                } 
            } 
        	// Update last occurrence of current character.
            visitedMap.put(ch, i);
        }
        
        // Compare length of last substring with maxlen and 
        // update maxlen and start accordingly. 
        if (maxlen < i - currentStart) { 
            maxlen = i - currentStart; 
            start = currentStart; 
        } 
      
        return s.substring(start, maxlen + start); 
	}
	
	public static boolean doTest() {
		return largestSubString("GEEKSFORGEEKS").equals("EKSFORG") && 
				largestSubString("ABDEFGABEF").equals("ABDEFG");
	}
	
	public static void main(String[] args) {
		if(doTest()) {
			System.out.println("All Test Passed");
		} else {
			System.out.println("Some failed");
		}
	}
}
