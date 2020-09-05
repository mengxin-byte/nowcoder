import jdk.nashorn.internal.ir.CatchNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mx
 * @date 2020/8/23 - 15:24
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建
 * 一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 */
public class Solution55 {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("cat");
        arr.add("cats");
        arr.add("and");
        arr.add("sand");
        arr.add("dog");
        List<String> catsanddog = wordBreak("catsanddog", arr);
        for (String s : catsanddog) {
            System.out.println(s);
        }
    }

    static ArrayList<String> res = new ArrayList<>();
    public static List<String> wordBreak(String s, List<String> wordDict) {
        helper(s, wordDict, "");
        return res;
    }

    public static void helper(String s, List<String> wordDict, String cur) {
        if (s.length() == 0) {
            res.add(cur.trim());
        }
        for (String str : wordDict) {
            if (s.startsWith(str)) {
                helper(s.substring(str.length()), wordDict, cur + " " + str);
            }
        }
    }
}
