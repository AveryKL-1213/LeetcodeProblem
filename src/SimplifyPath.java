import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        String ans = simplifyPath(path);
        System.out.println(ans);
    }

    public static String simplifyPath(String path) {
        String[] splitsPath = path.split("/");
        StringBuilder ans = new StringBuilder();
        Stack<String> ansStack = new Stack<>();
        for (String tmp : splitsPath) {
            if (tmp.equals("") || tmp.equals(".")) {
                continue;
            }
            if (tmp.equals("..")) {
                if (ansStack.size() != 0) {
                    ansStack.pop();
                }
            } else {
                ansStack.push(tmp);
            }
        }
        while (ansStack.size() != 0) {
            ans.insert(0, "/" + ansStack.pop());
        }
        return ans.toString().equals("") ? "/" : ans.toString();
    }
}
