import java.util.Arrays;

public class Solution {

    /**
     * Entry method matching LeetCode 169 interface.
     * Uses Divide and Conquer to find the majority element.
     */
    public int majorityElement(int[] nums) {
        return divideAndConquer(nums, 0, nums.length - 1);
    }

    /**
     * Recursively breaks down the array into halves until single elements remain.
     */
    private int divideAndConquer(int[] nums, int left, int right) {
        // Base case: a single element is always its own majority
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;

        // Recurse left and right
        int leftMajor = divideAndConquer(nums, left, mid);
        int rightMajor = divideAndConquer(nums, mid + 1, right);

        // If both halves agree, return candidate immediately
        if (leftMajor == rightMajor) {
            return leftMajor;
        }

        // When candidates differ, count frequencies within the current range [left, right]
        int leftCount = countInRange(nums, leftMajor, left, right);
        int rightCount = countInRange(nums, rightMajor, left, right);

        return leftCount > rightCount ? leftMajor : rightMajor;
    }

    /**
     * Counts how many times target appears in nums[left ... right].
     */
    private int countInRange(int[] nums, int target, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }

    /**
     * Main method to test locally in VS Code.
     */
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1
        int[] nums1 = {3, 2, 3};
        int result1 = solver.majorityElement(nums1);
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Majority Element: " + result1); // Expected: 3

        System.out.println("----------------------------------------");

        // Test Case 2
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        int result2 = solver.majorityElement(nums2);
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Majority Element: " + result2); // Expected: 2

        System.out.println("----------------------------------------");

        // Test Case 3
        int[] nums3 = {1};
        int result3 = solver.majorityElement(nums3);
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Majority Element: " + result3); // Expected: 1
    }
}