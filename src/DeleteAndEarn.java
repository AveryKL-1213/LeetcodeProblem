import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DeleteAndEarn {
    public static void main(String[] args) throws IOException {
        // 2 2 3 3 3 4
        // 8 3 4 7 6 6 9 2 5 8 2 4 9 5 9 1 5 7 1 4
        // 3 7 10 5 2 4 8 9 9 4 9 2 6 4 6 5 4 7 6 10
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String[] numString = line.split(" ");
        int[] nums = new int[numString.length];
        for (int i = 0; i < numString.length; i++) {
            nums[i] = Integer.parseInt(numString[i]);
        }
        System.out.println(Arrays.toString(nums));
        int ans = deleteAndEarn(nums);
        System.out.println(ans);
    }

    public static int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> cache = new HashMap<>();
        int ans = 0;
        for (int tmp : nums) {
            if (!map.containsKey(tmp)) {
                map.put(tmp, tmp);
            } else {
                map.put(tmp, map.get(tmp) + tmp);
            }
            ans = Math.max(ans, tmp);
        }
        int[] maxEarn = new int[ans + 1];
        maxEarn[1] = map.getOrDefault(1, 0);
        for (int i = 2; i < maxEarn.length; i++) {
            int earn = map.getOrDefault(i, 0);
            maxEarn[i] = Math.max(earn + maxEarn[i - 2], maxEarn[i - 1]);
        }
        return maxEarn[ans];
    }

}
