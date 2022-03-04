import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChampagneTower {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String[] nums = line.split(" ");
        int poured = Integer.parseInt(nums[0]);
        int query_row = Integer.parseInt(nums[1]);
        int query_glass = Integer.parseInt(nums[2]);
        double ans = champagneTower(poured, query_row, query_glass);
        System.out.println(ans);
    }

    public static double champagneTower(int poured, int query_row, int query_glass) {
        double[][] pourIn = new double[query_row + 1][query_glass + 2];
        pourIn[0][0] = poured;
        for (int r = 0; r < query_row; r++) {
            for (int g = 0; g <= query_glass; g++) {
                double tmpPourDown = (pourIn[r][g] - 1) / 2;
                if (tmpPourDown > 0) {
                    pourIn[r + 1][g] += tmpPourDown;
                    pourIn[r + 1][g + 1] += tmpPourDown;
                }
            }
        }
        return Math.min(1, pourIn[query_row][query_glass]);
    }
}
