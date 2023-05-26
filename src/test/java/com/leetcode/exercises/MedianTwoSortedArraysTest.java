package com.leetcode.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MedianTwoSortedArraysTest {
    @Test
    public void testMedian(){
        MedianTwoSortedArrays median = new MedianTwoSortedArrays();
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        Assertions.assertEquals(2.0, median.findMedianSortedArrays(nums1, nums2));

        nums1 = new int[]{1,2};
        nums2 = new int[]{3,4};
        Assertions.assertEquals(2.5, median.findMedianSortedArrays(nums1, nums2));

    }

    @Test
    public void testMedianOpt(){
        MedianTwoSortedArrays median = new MedianTwoSortedArrays();
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        Assertions.assertEquals(2.0, median.findMedianSortedArraysOptmized(nums1, nums2));

        nums1 = new int[]{1,2};
        nums2 = new int[]{3,4};
        Assertions.assertEquals(2.5, median.findMedianSortedArraysOptmized(nums1, nums2));

    }
}
