import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScoreOfParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int ans = scoreOfParentheses(s);
        System.out.println(ans);
    }

    public static int scoreOfParentheses(String s) {
        int ans = 0;
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (s.charAt(i + 1) == ')') {
                    ans += Math.pow(2, k);
                }
                k++;
            } else if (s.charAt(i) == ')') {
                k--;
            }
        }
        return ans;
    }
}
