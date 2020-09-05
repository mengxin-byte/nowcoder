/**
 * @author mx
 * @date 2020/8/22 - 23:45
 * 旋转数组最小元素
 */
public class Solution42 {
    public int minNumberInRotateArray(int[] array) {
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] <= array[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return array[low];
    }
}
