import java.util.ArrayList;
import java.util.Map;

/**
 * @author mx
 * @date 2020/8/12 - 22:18
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，
 * 因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Solution1 {
    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(10));
    }

    public static int GetUglyNumber_Solution(int index) {
        if (index < 7) {
            return index;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        while (arr.size() < index) {
            int num = Math.min(arr.get(p2) * 2, Math.min(arr.get(p3) * 3, arr.get(p5) * 5));
            if (num == arr.get(p2) * 2)
                ++p2;
            if (num == arr.get(p3) * 3)
                ++p3;
            if (num == arr.get(p5) * 5)
                ++p5;
            arr.add(num);
        }
        return arr.get(index - 1);
    }
}
