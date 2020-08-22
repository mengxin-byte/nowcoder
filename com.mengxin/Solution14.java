/**
 * @author mx
 * @date 2020/8/16 - 16:07
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 */
public class Solution14 {
    public void reverseString(char[] s) {
        if (s.length < 2) {
            return;
        }
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
            ++i;
            --j;
        }
    }
}
