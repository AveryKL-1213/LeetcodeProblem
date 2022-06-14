import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeleteOperationForTwoStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        reader.close();

        String[] words = line.split(" ");
        int ans = minDistance(words[0], words[1]);

        System.out.println(ans);
    }

    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int maxLen = lcs(word1, word2, len1, len2);
        return len1 - maxLen + len2 - maxLen;
    }

    public static int lcs(String word1, String word2, int len1, int len2) {
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len2 + 1; i++)
            dp[0][i] = 0;
        for (int j = 0; j < len1 + 1; j++)
            dp[j][0] = 0;

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

            }
        }
        return dp[len1][len2];
    }
}
