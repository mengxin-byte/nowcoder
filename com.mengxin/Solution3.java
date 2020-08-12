/**
 * @author mx
 * @date 2020/8/12 - 23:33
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下
 * 移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子
 */
public class Solution3 {
    int[] x_index = {0, 0, 1, -1};
    int[] y_index = {1, -1, 0, 0};
    boolean flag = false;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        char[][] arr = new char[rows][cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = matrix[index++];
            }
        }
        int[][] nums = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (flag) {
                    return true;
                }
                helper(arr, str, i, j, 0, nums);
            }
        }
        return flag;

    }

    public void helper(char[][] arr, char[] str, int x, int y, int index, int[][] nums) {
        if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && nums[x][y] == 0 && str[index] == arr[x][y]) {
            nums[x][y] = 1;
            if (index == str.length - 1) {
                flag = true;
                return;
            }
            for (int i = 0; i < 4; i++) {
                helper(arr, str, x + x_index[i], y + y_index[i], ++index, nums);
            }
            nums[x][y] = 0;
        }
    }
}
