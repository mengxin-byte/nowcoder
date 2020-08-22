/**
 * @author mx
 * @date 2020/8/18 - 0:23
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Solution27 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 1) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int res = 1;
        int left = 0;
        int right = 0;
        for (int i = 1; i < arr.length; i++) {
            ++right;
            char ch = arr[right];
            for (int j = left; j < right; j++) {
                if (arr[j] == ch) {
                    left = j + 1;
                    break;
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
