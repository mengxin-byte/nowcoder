/**
 * @author mx
 * @date 2020/9/6 - 14:36
 */
public class Solution65 {
    public static void main(String[] args) {
        System.out.println(reverseInt(234));
    }
    public static int reverseInt(int num) {
        long res = 0;
        while (num != 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        return (int) res == res ? (int) res : -1;
    }
}
