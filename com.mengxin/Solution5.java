/**
 * @author mx
 * @date 2020/8/15 - 12:15
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法
 * 的数值则返回0
 */
public class Solution5 {
    public int StrToInt(String str) {
        int flag = 1;
        long res = 0;
        int index = 0;
        if (str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        if (chars[0] == '-') {
            flag = -1;
            ++index;
        } else if (chars[0] == '+') {
            ++index;
        }
        for (int i = index; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return 0;
            }
            res = res * 10 + (chars[i] - '0');
        }
        res = res * flag;
        return (int)res == res ? (int)res : 0;
    }
}
