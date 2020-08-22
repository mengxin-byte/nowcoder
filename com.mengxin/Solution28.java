import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author mx
 * @date 2020/8/18 - 0:33
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 */
public class Solution28 {
    public int lengthOfLIS(int[] nums) {
        int res = 1;
        int[] arr = new int[nums.length];
        Arrays.fill(arr, 1);
        for (int i = 1; i < arr.length; i++) {
            int tmp = nums[i];
            for (int j = 0; j < i; j++) {
                if (tmp < nums[j]) {
                    arr[i] = Math.max(arr[i], arr[j] + 1);
                }
            }
            res = Math.max(res, arr[i]);
        }
        return res;
    }
}
