/**
 * @author mx
 * @date 2020/8/16 - 15:50
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），
 * 返回其最大和。
 */
public class Solution12 {
    public int maxSubArray(int[] nums) {
        int cur = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], nums[i] + cur);
            max = Math.max(max, cur);
        }
        return max;
    }
}
