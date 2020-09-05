/**
 * @author mx
 * @date 2020/8/23 - 21:54
 * 寻找峰值
 */
public class Solution57 {
    static int res = -1;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(findPeakElement(arr));
    }
    public static int findPeakElement(int[] nums) {
        helper(nums, 0, nums.length - 1);
        return res;
    }

    public static void helper(int[] arr, int low, int high) {
        if (res != -1) {
            return;
        }
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid == 0) {
                if (arr[mid] > arr[mid + 1]) {
                    res = 0;
                    return;
                }
            } else if (mid == arr.length - 1) {
                if (arr[mid] > arr[mid - 1]) {
                    res = arr.length - 1;
                    return;
                }
            }else if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                res = mid;
                return;
            }
            helper(arr, low, mid - 1);
            helper(arr, mid + 1, high);
        }
    }
}
