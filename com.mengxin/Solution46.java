/**
 * @author mx
 * @date 2020/8/23 - 1:56
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 */
public class Solution46 {
    static int right = 0;

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(lengthOfLIS(arr));
    }
    public static int lengthOfLIS(int[] nums) {
        if (nums.length < 2) {
            return 1;
        }
        int len = nums.length;
        int[] arr = new int[len];
        arr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            insert(arr, nums[i]);
        }
        return right + 1;
    }

    public static void insert(int[] arr, int num) {
        if (num > arr[right]) {
            ++right;
            arr[right] = num;
        } else {
            int low = 0;
            int high = right;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] == num) {
                    return;
                } else if (arr[mid] < num) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            arr[high] = num;
        }
    }
}
