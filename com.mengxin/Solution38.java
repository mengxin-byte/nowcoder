/**
 * @author mx
 * @date 2020/8/22 - 22:13
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class Solution38 {
    public int maxSubArray(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int res = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            res = Math.max(res, cur);
        }
        return res;
    }
}
