import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        boolean ans = isValid(s);
        System.out.println(ans);
    }

    public static boolean isValid(String s) {
        Stack<Character> cache = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                cache.push(s.charAt(i));
            } else if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if (cache.size() == 0) {
                    return false;
                }
                if (cache.peek() == '(' && s.charAt(i) == ')' || cache.peek() == '[' && s.charAt(i) == ']' || cache.peek() == '{' && s.charAt(i) == '}') {
                    cache.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return cache.size() == 0;
    }
}
