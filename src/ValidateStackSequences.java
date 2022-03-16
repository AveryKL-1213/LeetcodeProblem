import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ValidateStackSequences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String line2 = reader.readLine();
        String[] pushedString = line.split(" ");
        String[] poppedString = line2.split(" ");
        int[] pushed = new int[pushedString.length];
        int[] popped = new int[poppedString.length];
        for (int i = 0; i < pushedString.length; i++) {
            pushed[i] = Integer.parseInt(pushedString[i]);
            popped[i] = Integer.parseInt(poppedString[i]);
        }
        boolean ans = validateStackSequences(pushed, popped);
        System.out.println(ans);
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> pool = new Stack<>();
        int poppedFlag = 0;
        for (int tmp : pushed) {
            pool.push(tmp);
            while (poppedFlag < popped.length && !pool.isEmpty() && pool.peek() == popped[poppedFlag]) {
                pool.pop();
                poppedFlag++;
            }
        }
        return poppedFlag == popped.length;
    }
}
