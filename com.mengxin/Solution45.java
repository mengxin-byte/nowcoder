/**
 * @author mx
 * @date 2020/8/23 - 1:32
 * 颠倒给定的 32 位无符号整数的二进制位。
 */
public class Solution45 {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += (((n >> i) & 1) << (31 - i));
        }
        return res;
    }
}
