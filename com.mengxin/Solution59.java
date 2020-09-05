/**
 * @author mx
 * @date 2020/8/23 - 22:54
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Solution59 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int res = 0;
        int left = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = left; j < i; j++) {
                if (s.charAt(j) == c) {
                    left = j + 1;
                }
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
