/**
 * @author mx
 * @date 2020/8/16 - 17:13
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 */
public class Solution16 {
    public static int uniquePaths(int m, int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[j] = arr[j] + arr[j - 1];
            }
        }
        return arr[n - 1];
    }
}
