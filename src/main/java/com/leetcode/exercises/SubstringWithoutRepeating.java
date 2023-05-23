package com.leetcode.exercises;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */

public class SubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        int highest = 0, left = 0;

        // handles empty and one character strings
        if(s.length() == 0 || s.length() == 1)
            return s.length();

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(map.containsKey(c) && map.get(c) >= left){
                int sequence = i - left;
                highest = Math.max(highest, sequence);
                int previous = map.get(c);
                previous = left > previous  ? i : previous + 1;
                left = previous;
            }
            map.put(c, i);
        }
        int sequence = s.length() - left;
        return Math.max(highest, sequence);
    }
}
