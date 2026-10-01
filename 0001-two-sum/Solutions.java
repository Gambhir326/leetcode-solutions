import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solutions {
    public int[] twoSum(int[] nums, int target) {
        // Map stores: value -> index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // If the complement is already seen, return the pair of indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {}; // No solution found
    }

    public static void main(String[] args) {
        Solutions solver = new Solutions();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements in array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " integers separated by spaces or newlines:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter target value: ");
        int target = scanner.nextInt();

        int[] result = solver.twoSum(nums, target);
        System.out.println("Indices: " + Arrays.toString(result));

        scanner.close();
    }
}