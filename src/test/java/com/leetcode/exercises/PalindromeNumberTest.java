package com.leetcode.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PalindromeNumberTest {
    @Test
    public void testPalindromeNumber(){
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        Assertions.assertEquals(true, palindromeNumber.isPalindrome(121));
        Assertions.assertEquals(true, palindromeNumber.isPalindrome(2442));
        Assertions.assertEquals(true, palindromeNumber.isPalindrome(24542));
        Assertions.assertEquals(false, palindromeNumber.isPalindrome(21522));

    }
}
