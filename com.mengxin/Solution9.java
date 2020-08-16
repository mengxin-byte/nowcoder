import java.util.ArrayList;

/**
 * @author mx
 * @date 2020/8/16 - 11:00
 */
public class Solution9 {
    static ArrayList<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 1}, {4, 5, 6, 2}, {7, 8, 9, 3}};
        printMatrix(arr);
        System.out.println(res);
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            for (int i = 0; i < matrix[0].length; i++) {
                res.add(matrix[0][i]);
            }
            for (int i = 1; i < matrix.length; i++) {
                res.add(matrix[i][matrix[0].length - 1]);
            }
            for (int i = matrix[0].length - 2; i >= 0; i--) {
                if (matrix.length - 1 == 0) {
                    break;
                }
                res.add(matrix[matrix.length - 1][i]);
            }
            for (int i = matrix.length - 2; i > 0; i--) {
                if (matrix[0].length - 1 == 0) {
                    break;
                }
                res.add(matrix[i][0]);
            }
            int[][] newArr = getMatrix(matrix);
            printMatrix(newArr);
        }
        return res;
    }

    public static int[][] getMatrix(int[][] arr) {
        if (arr.length < 3 || arr[0].length < 3) {
            return null;
        }
        int[][] newArr = new int[arr.length - 2][arr[0].length - 2];
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr[0].length - 1; j++) {
                newArr[i - 1][j - 1] = arr[i][j];
            }
        }
        return newArr;
    }
}
