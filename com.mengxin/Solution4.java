import java.util.ArrayList;

/**
 * @author mx
 * @date 2020/8/15 - 11:34
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则按字典序
 * 打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Solution4 {
    static ArrayList<String> res = new ArrayList<>();

    public static void main(String[] args) {
        String s = "aac";
        Permutation(s);
    }

    public static ArrayList<String> Permutation(String str) {
        char[] chars = str.toCharArray();
        helper(chars, 0);
        System.out.println(res);
        return res;
    }

    public static void helper(char[] chars, int index) {
        if (index == chars.length -1) {
            String s = new String(chars);
            res.add(s);
        } else {
            for (int i = index; i < chars.length; i++) {
                if (canSwap(chars, i)) {
                    swap(chars, index, i);
                    helper(chars, index + 1);
                    swap(chars, index, i);
                }
            }
        }

    }

    public static boolean canSwap(char[] chars, int index) {
        char tmp = chars[index];
        for (int i = 0; i < index; i++) {
            if (tmp == chars[i]) {
                return false;
            }
        }
        return true;
    }

    public static void swap(char[] chars, int m, int n) {
        char tmp = chars[m];
        chars[m] = chars[n];
        chars[n] = tmp;
    }
}
