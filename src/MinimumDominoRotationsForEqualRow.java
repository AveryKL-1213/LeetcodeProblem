import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class MinimumDominoRotationsForEqualRow {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line1 = reader.readLine();
        String[] numString = line1.split(" ");
        String line2 = reader.readLine();
        String[] numString2 = line2.split(" ");
        int[] tops = new int[numString.length];
        int[] bottoms = new int[numString2.length];
        reader.close();
        for (int i = 0; i < numString.length; i++) {
            tops[i] = Integer.parseInt(numString[i]);
            bottoms[i] = Integer.parseInt(numString2[i]);
        }
        System.out.println(Arrays.toString(tops));
        System.out.println(Arrays.toString(bottoms));

        int ans = minDominoRotations(tops, bottoms);
        System.out.println(ans);
    }

    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int length = tops.length;
        int[][] dp = new int[6][3];
        for (int i = 0; i < length; i++) {
            if (tops[i] == bottoms[i]) {
                dp[tops[i] - 1][0]++;
                dp[tops[i] - 1][1]++;
                dp[tops[i] - 1][2]++;
            } else {
                dp[tops[i] - 1][0]++;
                dp[tops[i] - 1][1]++;
                dp[bottoms[i] - 1][0]++;
                dp[bottoms[i] - 1][2]++;
            }
        }
        for (int[] num : dp) {
            if (num[0] == length) {
                return Math.min(length - num[1], length - num[2]);
            }
        }
        return -1;
    }
}
