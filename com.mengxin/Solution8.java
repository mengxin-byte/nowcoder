/**
 * @author mx
 * @date 2020/8/16 - 10:35
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 */
public class Solution8 {
    static int res = 0;

    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 1};
        InversePairs(arr);
        System.out.println(res);
    }
    public static int InversePairs(int[] array) {
        sort(array, 0, array.length - 1);
        return res;
    }

    public static void sort(int[] array, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            sort(array, low, mid);
            sort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    public static void merge(int[] array, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= high) {
            if (array[i] <= array[j]) {
                tmp[index++] = array[i++];
            } else {
                tmp[index++] = array[j++];
                res += (mid - i + 1) % 1000000007;
            }
        }
        while (i <= mid) {
            tmp[index++] = array[i++];
        }
        while (j <= high) {
            tmp[index++] = array[j++];
        }
        if (index >= 0) System.arraycopy(tmp, 0, array, low + 0, index);
    }
}
