import java.util.HashMap;
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
        System.out.println(InterfaceTestSon.a);
        HashMap<String, String> hashMap = new HashMap<>(100);
    }

    public static void change(String str) {
        str += "aaa";
    }
}
