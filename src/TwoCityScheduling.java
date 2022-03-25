import java.util.ArrayList;
import java.util.Comparator;

public class TwoCityScheduling {
    public static void main(String[] args) {
        int[][] costs = {{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}};
        int ans = twoCityScheduledCost(costs);
        System.out.println(ans);
    }

    public static int twoCityScheduledCost(int[][] costs) {
        int ans = 0;
        ArrayList<Integer> diffA = new ArrayList<>();
        ArrayList<Integer> diffB = new ArrayList<>();
        for (int[] cost : costs) {
            if (cost[0] < cost[1]) {
                ans += cost[0];
                diffA.add(cost[1] - cost[0]);
            } else {
                ans += cost[1];
                diffB.add(cost[0] - cost[1]);
            }
        }
        ArrayList<Integer> diff;
        if (diffA.size() > diffB.size()) {
            diff = diffA;
        } else {
            diff = diffB;
        }
        diff.sort(Comparator.naturalOrder());
        int sub = Math.abs(diffA.size() - diffB.size()) / 2;
        for (int i = 0; i < sub; i++) {
            ans += diff.get(i);
        }
        return ans;
    }
}
