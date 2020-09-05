/**
 * @author mx
 * @date 2020/8/23 - 1:09
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，
 * 而不是第 k 个不同的元素。
 */
public class Solution44 {
    public int findKthLargest(int[] nums, int k) {
        return helper(nums, 0, nums.length - 1, k);
    }

    public int helper(int[] nums, int left, int right, int k) {
        if (left <= right) {
            int tmp = nums[right];
            int i = left;
            int j = right;
            while (i < j) {
                while (i < j && nums[i] <= tmp) {
                    ++i;
                }
                if (i < j) {
                    nums[j] = nums[i];
                    ++i;
                    --j;
                }
                while (i < j && nums[j] > tmp) {
                    --j;
                }
                if (i < j) {
                    nums[i] = nums[j];
                    ++i;
                    --j;
                }
            }
            nums[i] = tmp;
            if (i == k - 1) {
                return i;
            } else if (i < k - 1) {
                return helper(nums, i + 1, right, k);
            } else {
                return helper(nums, left, i - 1, k);
            }
        }
        return -1;
    }
}
