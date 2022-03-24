import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BoatsToSavePeople {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String line2 = reader.readLine();
        reader.close();
        String[] split = line.split(" ");
        int[] people = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            people[i] = Integer.parseInt(split[i]);
        }
        int limit = Integer.parseInt(line2);
        int ans = numRescueBoats(people, limit);
        System.out.println(ans);
    }

    public static int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        int left = 0;
        int right = people.length - 1;
        Arrays.sort(people);
        while (left <= right) {
            int sum = people[left] + people[right];
            if (sum <= limit) {
                ans++;
                left++;
                right--;
            } else {
                ans++;
                right--;
            }
        }
        return ans;

//        Map<Integer, Integer> map = new HashMap<>();
//        int cur = 0;
//        int min = Integer.MAX_VALUE;
//        for (int tmp : people) {
//            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
//            cur = Math.max(cur, tmp);
//            min = Math.min(min, tmp);
//        }
//        int ans = 0;
//        while (cur >= min) {
//            if (map.getOrDefault(cur, 0) > 0) {
//                ans++;
//                map.put(cur, map.get(cur) - 1);
//                int left = limit - cur;
//                while (left >= min) {
//                    if (map.getOrDefault(left, 0) > 0) {
//                        map.put(left, map.get(left) - 1);
//                        break;
//                    } else {
//                        left--;
//                    }
//                }
//            } else {
//                cur--;
//            }
//        }
//        return ans;
    }
}
