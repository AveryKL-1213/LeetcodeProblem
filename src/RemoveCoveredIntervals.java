import java.util.Arrays;

public class RemoveCoveredIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {3, 6}, {2, 8}};
        int ans = leftIntervalsNum(intervals);
        System.out.println(ans);
    }

    public static int leftIntervalsNum(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        int count = 0, cur = 0;
        for(int[] interval : intervals){
            if(cur < interval[1]){
                cur = interval[1];
                count++;
            }
        }
        return count;
    }
}
