import java.util.*;

/**
 * @author mx
 * @date 2020/8/24 - 23:11
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 */
public class Solution62 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return new ArrayList<>(set);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[right] < 0) {
                    break;
                }
                if (nums[i] + nums[left] + nums[right] == 0) {
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(nums[i]);
                    arr.add(nums[left]);
                    arr.add(nums[right]);
                    set.add(arr);
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    --right;
                } else {
                    ++left;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
