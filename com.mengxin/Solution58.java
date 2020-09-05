import java.util.Stack;

/**
 * @author mx
 * @date 2020/8/23 - 22:00
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。
 * 注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 
 * 的输入。
 *
 */
public class Solution58 {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.push("" + s.charAt(i));
            } else {
                String tmp = "";
                while (!stack.peek().equals("" + '[') ) {
                    tmp = stack.pop() + tmp;
                }
                stack.pop();
                String countString = "";
                while((!stack.isEmpty())&&(stack.peek().charAt(0)>='0'&&stack.peek().charAt(0)<='9')) {
                    countString=stack.pop()+countString;
                }
                int count = Integer.parseInt(countString);
                String str = "";
                for (int j = 0; j < count; j++) {
                    res = res + tmp;
                }
                stack.push(res);
            }
        }
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }
}
