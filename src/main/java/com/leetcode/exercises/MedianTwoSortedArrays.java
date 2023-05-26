    package com.leetcode.exercises;

/**
 * 4. Median of Two Sorted Arrays
 * Hard
 * 23.4K
 * 2.6K
 * Companies
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 *
 * Constraints:
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class MedianTwoSortedArrays {
    // O(M+N) time complexity
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int[] nums = new int[totalLength];
        int oddIndex = -1;
        int evenIndex1 = -1, evenIndex2 = -1;

        // calculate median indexes
        if(totalLength % 2 != 0)
            oddIndex = totalLength / 2;
        else {
            double temp = totalLength / 2;
            evenIndex1 = (int)(temp - 0.5);
            evenIndex2 = (int)(temp + 0.5);
        }

        // ordered insert to the resulting array
        for(int i = 0, i1 = 0, i2 = 0; i < totalLength ; i++){

            // handle edge cases: only one of the array has leftover items
            if(i1 >= nums1.length) {
                nums[i] = nums2[i2];
                i2++;
                continue;
            }
            if(i2 >= nums2.length){
                nums[i] = nums1[i1];
                i1++;
                continue;
            }

            // regular handling, ordered insert
            if(nums1[i1] < nums2[i2]){
                nums[i] = nums1[i1];
                i1++;
            } else{
                nums[i] = nums2[i2];
                i2++;
            }
        }

        // get the median from the resulting array
        double median = 0.00;
        if(oddIndex  > -1){
            median = nums[oddIndex];
        } else{
            int num1 = nums[evenIndex1];
            int num2 = nums[evenIndex2];
            median = (double)(num1 + num2) / 2;
        }

        return median;
    }


    // optmization done using binary search on arrays to achieve a OLOG(MIN(N,M)) algorithm
    public double findMedianSortedArraysOptmized(int[] nums1, int[] nums2) {

        // swap so the largest array comes first
        if(nums1.length < nums2.length)
            return  findMedianSortedArraysOptmized(nums2, nums1);

        boolean even = (nums1.length + nums2.length) % 2 == 0;

        int maxLeft1, maxLeft2, minRight1, minRight2;
        int left = 0;
        int right = nums1.length;

        while(left < right){
            int mid1 = left + right / 2;
            int mid2 =( (nums1.length + nums2.length + 1) / 2) - mid1;
            minRight1 = mid1 == nums1.length ? Integer.MAX_VALUE : nums1[mid1];
            maxLeft1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
            minRight2 = mid2 == nums2.length ? Integer.MAX_VALUE : nums2[mid2];
            maxLeft2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
            if(maxLeft1 <= minRight2 && maxLeft2 <= minRight1){
                if(even)
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2;
                else
                    return Math.min(minRight1, minRight2);
            }
            if(maxLeft1>minRight2)
                right = mid1 - 1;
            else
                left = mid1 + 1;
        }

        return 0.0;
    }

}
