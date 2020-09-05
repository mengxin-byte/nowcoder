/**
 * @author mx
 * @date 2020/8/23 - 14:08
 * 数组中出现次数为1的数
 */
public class Solution49 {
    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] = nums[0] ^ nums[i];
        }
        return nums[0];
    }
}
