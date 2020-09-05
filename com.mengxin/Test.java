import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mx
 * @date 2020/8/15 - 12:39
 */
public class Test {
    public static void main(String[] args) {
        String s = new String("abc");
        System.out.println(s);
        change(s);
        System.out.println(s);
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("a", "b");
    }

    public static void change(String str) {
        str += "aaa";
    }
}
