import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mx
 * @date 2020/9/6 - 14:16
 */
public class Solution64 {
    static Map<Character, char[]> map = new HashMap<>();
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        getRes("23");
    }
    public static void getRes(String str) {
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        char[] chars = str.toCharArray();
        getAns(0, chars, new StringBuilder(""));
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void getAns(int index, char[] chars, StringBuilder sb) {
        if (index == chars.length) {
            list.add(sb.toString());
        } else {
            char[] arr = map.get(chars[index]);
            for (int i = 0; i < arr.length; i++) {
                StringBuilder tmp = new StringBuilder(sb);
                tmp.append(arr[i]);
                getAns(index + 1, chars, tmp);
            }
        }
    }
}
