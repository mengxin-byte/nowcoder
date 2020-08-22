/**
 * @author mx
 * @date 2020/8/16 - 11:37
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class Solution10 {
    int res = 0;
    int[] x_index = {1, -1, 0, 0};
    int[] y_index = {0, 0, 1, -1};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return res;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0 && grid[i][j] == '1') {
                    ++res;
                    search(grid, arr, i, j);
                }
            }
        }
        return res;
    }

    public void search(char[][] grid, int[][] arr, int x, int y) {
        if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length &&
                arr[x][y] == 0 && grid[x][y] == '1') {
            arr[x][y] = 1;
            for (int i = 0; i < 4; i++) {
                search(grid, arr, x + x_index[i], y + y_index[i]);
            }
        }
    }
}
