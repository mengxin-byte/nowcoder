/**
 * @author mx
 * @date 2020/8/17 - 0:03
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 */
public class Solution22 {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder("");
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].length() > 0) {
                sb.append(arr[i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
