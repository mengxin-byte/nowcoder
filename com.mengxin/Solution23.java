/**
 * @author mx
 * @date 2020/8/17 - 23:25
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class Solution23 {

    public static void main(String[] args) {
        System.out.println(reverse(-123456));
    }

    public static int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return (int)res == res ? (int) res : 0;
    }
}
