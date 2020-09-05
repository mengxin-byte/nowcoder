/**
 * @author mx
 * @date 2020/8/23 - 15:09
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class Solution54 {
    public void moveZeroes(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int i = 0;
        while (nums[i] != 0) {
            ++i;
        }
        int j = i + 1;
        while (j < nums.length) {
            while (nums[j] == 0) {
                ++j;
                if (j == nums.length) {
                    return;
                }
            }
            nums[i] = nums[j];
            nums[j] = 0;
            ++i;
            ++j;
        }
    }
}
