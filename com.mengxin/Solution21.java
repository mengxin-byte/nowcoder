/**
 * @author mx
 * @date 2020/8/16 - 20:18
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，
 * 而不是第 k 个不同的元素。
 */
public class Solution21 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(arr, 1));
    }

    public static int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }

    public static int quickSort(int[] nums, int left, int right, int k) {
        if (left <= right) {
            int i = left;
            int j = right;
            int tmp = nums[j];
            while (i < j) {
                while (i < j && nums[i] <= tmp) {
                    ++i;
                }
                if (i < j) {
                    nums[j] = nums[i];
                    --j;
                }
                while (i < j && nums[j] > tmp) {
                    --j;
                }
                if (i < j) {
                    nums[i] = nums[j];
                    ++i;
                }
            }
            nums[i] = tmp;
            if (i == k - 1) {
                return nums[i];
            } else if (i > k - 1) {
                quickSort(nums, left, i - 1, k);
            } else if (i < k - 1) {
                quickSort(nums, i + 1, right, k);
            }
        }
        return 0;
    }
}
