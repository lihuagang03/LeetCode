package exam.problems.three.sum;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href="https://pintia.cn/problem-sets/2004497238921478144/exam/problems/type/7?problemSetProblemId=2004497238955032578">
 *     7.03 三数之和</a>
 * <a href="https://leetcode.cn/problems/3sum/description/">
 *     15. 三数之和</a>
 *
 * @author lihuagang
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            String[] numArray = str.split(" ");

            int[] nums = new int[numArray.length];
            for (int i = 0; i < numArray.length; i++) {
                nums[i] = Integer.parseInt(numArray[i]);
            }

            int result = threeSum(nums);
            System.out.println(result);
        }
    }

    private static int threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num > 0) {
                return result;
            }
            if (i > 0 && num == nums[i - 1]) {
                // 重复元素，略过
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = num + nums[left] + nums[right];

                if (sum == 0) {
                    // 找到一个解法
                    result++;

                    // 重复元素，略过
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum > 0) {
                    // 重复元素，略过
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    right--;
                } else {
                    // sum < 0
                    // 重复元素，略过
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    left++;
                }
            }
        }

        return result;
    }

}
