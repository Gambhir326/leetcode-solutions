import java.util.Arrays;
// import java.util.*;

public class Solutions {
    public static int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];
        int i = 0; 
        int j = 0; 
        int k = 0; 
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        while (i < m) {
            merged[k++] = nums1[i++];
        }
        while (j < n) {
            merged[k++] = nums2[j++];
        }
        return merged;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = merge(nums1, nums2);
        int n = mergedArray.length;
        double result = 0;

        if (n % 2 == 0) {
            int i = ((n - 1) / 2);
            int j = (n / 2);
            result = (mergedArray[i] + mergedArray[j]) / 2.0;
        } else {
            int i = (n - 1) / 2;
            result = mergedArray[i];
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solutions sol = new Solutions();

        // Test Case 1: Odd total length (1 + 3 = 4 elements) -> Even total
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double median1 = sol.findMedianSortedArrays(nums1, nums2);
        System.out.println("Test 1:");
        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("nums2: " + Arrays.toString(nums2));
        System.out.println("Median: " + median1); // Output: 2.0

        System.out.println("--------------------");

        // Test Case 2: Even total length (2 + 2 = 4 elements)
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        double median2 = sol.findMedianSortedArrays(nums3, nums4);
        System.out.println("Test 2:");
        System.out.println("nums1: " + Arrays.toString(nums3));
        System.out.println("nums2: " + Arrays.toString(nums4));
        System.out.println("Median: " + median2); // Output: 2.5
    }
}