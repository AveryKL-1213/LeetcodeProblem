import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestStringWithAGivenNumericValue {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String[] split = line.split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        String ans = getSmallestString(n, k);
        System.out.println(ans);
    }

    public static String getSmallestString(int n, int k) {
        int value = k;
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            ans[i] = 'a';
        }
        value -= n;
        int i = n - 1;
        while (value != 0) {
            int add = value - 25 >= 0 ? 25 : value;
            ans[i--] += add;
            value -= add;
        }
        return String.valueOf(ans);
    }
}
