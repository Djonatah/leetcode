package com.leetcode.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

public class SubstringWithoutRepeatingTest {
    @Test
    public void longestSeqTest() {
        SubstringWithoutRepeating sbr = new SubstringWithoutRepeating();
        Assertions.assertEquals(3, sbr.lengthOfLongestSubstring("dvdf"));
        Assertions.assertEquals(3, sbr.lengthOfLongestSubstring("abcabcbb"));
        Assertions.assertEquals(2,  sbr.lengthOfLongestSubstring("abba"));
        Assertions.assertEquals(0,  sbr.lengthOfLongestSubstring(""));
        Assertions.assertEquals(2, sbr.lengthOfLongestSubstring("aab"));
        Assertions.assertEquals(2,  sbr.lengthOfLongestSubstring("aaab"));
        Assertions.assertEquals(2,  sbr.lengthOfLongestSubstring("baaa"));
        Assertions.assertEquals(2,  sbr.lengthOfLongestSubstring("ab"));

    }
}
