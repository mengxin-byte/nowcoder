/**
 * @author mx
 * @date 2020/8/16 - 20:01
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 */
public class Solution20 {
    public void rotate(int[][] matrix) {
        int m = 0;
        int n = matrix.length - 1;

        while (m < n) {
            int i = m;
            int j = n;
            while (i < n) {
                int tmp = matrix[m][i];
                matrix[m][i] = matrix[m][j];
                matrix[m][j] = matrix[n][j];
                matrix[n][j] = matrix[i][n];
                matrix[i][n] = tmp;
                ++i;
                --j;
            }
            ++m;
            --n;
        }
    }
}
