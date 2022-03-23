import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BrokenCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String[] split = line.split(" ");
        int startValue = Integer.parseInt(split[0]);
        int target = Integer.parseInt(split[1]);
        int ans = brokenCalc(startValue, target);
        System.out.println(ans);
    }

    public static int brokenCalc(int startValue, int target) {
        int ans = 0;
        while (target > startValue) {
            if (target % 2 == 1) {
                target++;
            } else {
                target /= 2;
            }
            ans++;
        }
        ans += startValue - target;
        return ans;
    }
}
