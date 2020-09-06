import java.util.HashMap;

/**
 * @author mx
 * @date 2020/9/5 - 16:53
 */
public class Solution63 {
    public static void main(String[] args) {
        char[] arr = {'a','b','a','c','a','b','e'};
        print(arr);
    }
    public static void print(char[] arr) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : arr) {
            if (!map.containsKey(c)) {
                map.put(c, -1);
            } else {
                map.put(c, 1);
            }
        }
        for (char c : arr) {
            int num = map.get(c);
            if (num == -1) {
                System.out.println(c);
            } else if (num > 0) {
                System.out.println(c + "" + num);
                map.put(c, ++num);
            }
        }
    }
}
