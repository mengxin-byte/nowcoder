import java.util.HashMap;
import java.util.Map;

/**
 * @author mx
 * @date 2020/8/16 - 19:51
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个整数，
 * 并返回他们的数组下标。
 */
public class Solution19 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                res[0] = map.get(nums[i]);
                res[1] = i;
                break;
            }
            map.put(target - nums[i], i);
        }
        return res;
    }
}
