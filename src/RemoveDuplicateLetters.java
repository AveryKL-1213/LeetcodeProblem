import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//It is the Same as Smallest Subsequence of Distinct Characters
public class RemoveDuplicateLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String ans = removeDuplicateLetters(s);
        System.out.println(ans);
    }

    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> lastIndex = new HashMap<>();
        Map<Character, Boolean> added = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (added.getOrDefault(cur, false)) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > cur && lastIndex.get(stack.peek()) > i) {
                char popped = stack.pop();
                added.put(popped, false);
            }
            stack.push(cur);
            added.put(cur, true);
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}
