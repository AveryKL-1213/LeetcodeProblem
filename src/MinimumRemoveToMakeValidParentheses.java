import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String ans = minRemoveToMakeValid(s);
        System.out.println(ans);
    }

    public static String minRemoveToMakeValid(String s) {
        int len = s.length();
        StringBuilder ansBuilder = new StringBuilder();
        Stack<Integer[]> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                if (stack.size() != 0 && stack.peek()[1] == -1 && s.charAt(i) == ')') {
                    stack.pop();
                } else {
                    Integer[] tmp = {i, s.charAt(i) == '(' ? -1 : 1};
                    stack.push(tmp);
                }
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if (stack.size() != 0 && stack.peek()[0] == i) {
                stack.pop();
                continue;
            }
            ansBuilder.insert(0, s.charAt(i));
        }
        return ansBuilder.toString();
    }
}
