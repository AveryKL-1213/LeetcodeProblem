import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String[] words = line.split(" ");
        reader.close();

        int ans = longestStrChain(words);

        System.out.println(ans);
    }

    public static int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> dp = new HashMap<>();

        int maxPath = 1;
        for (String word: words) {
            int currLength = 1;
            StringBuilder sb = new StringBuilder(word);
            for (int i=0; i<word.length(); i++) {
                sb.deleteCharAt(i);
                String prevWord = sb.toString();
                currLength = Math.max(currLength, dp.getOrDefault(prevWord, 0) + 1);
                sb.insert(i, word.charAt(i));
            }
            dp.put(word, currLength);
            maxPath = Math.max(maxPath, currLength);
        }

        return maxPath;
    }


}
