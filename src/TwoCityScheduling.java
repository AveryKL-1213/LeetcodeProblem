import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
    public static void main(String[] args) {
        int[][] costs = {{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}};
        int ans = twoCityScheduledCost(costs);
        System.out.println(ans);
    }

    public static int twoCityScheduledCost(int[][] costs) {
        int ans = 0;
        int[] diff = new int[costs.length];
        int i = 0;
        for (int[] cost : costs) {
            ans += cost[0];
            diff[i++] = cost[1] - cost[0];
        }
        Arrays.sort(diff);
        for (int j = 0; j < i / 2; j++) {
            ans += diff[j];
        }
        return ans;

//        int ans = 0;
//        ArrayList<Integer> diffA = new ArrayList<>();
//        ArrayList<Integer> diffB = new ArrayList<>();
//        for (int[] cost : costs) {
//            if (cost[0] < cost[1]) {
//                ans += cost[0];
//                diffA.add(cost[1] - cost[0]);
//            } else {
//                ans += cost[1];
//                diffB.add(cost[0] - cost[1]);
//            }
//        }
//        ArrayList<Integer> diff;
//        if (diffA.size() > diffB.size()) {
//            diff = diffA;
//        } else {
//            diff = diffB;
//        }
//        diff.sort(Comparator.naturalOrder());
//        int sub = Math.abs(diffA.size() - diffB.size()) / 2;
//        for (int i = 0; i < sub; i++) {
//            ans += diff.get(i);
//        }
//        return ans;
    }
}
