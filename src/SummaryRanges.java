import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {0, 2, 3, 4, 6, 8, 9};
        List<String> ans = summaryRanges(nums);
        System.out.println(ans);
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        int startFlag = nums[0];
        int endFlag = nums[0];
        int startPos = 0;
        for (int i = 1; i < nums.length; i++) {
            if (startFlag + i - startPos == nums[i]) {
                endFlag = nums[i];
            } else {
                if (startFlag == endFlag) {
                    ans.add(String.format("%d", startFlag));
                } else {
                    ans.add(String.format("%d->%d", startFlag, endFlag));
                }
                startFlag = nums[i];
                endFlag = startFlag;
                startPos = i;
            }
        }
        if (startFlag == endFlag) {
            ans.add(String.format("%d", startFlag));
        } else {
            ans.add(String.format("%d->%d", startFlag, endFlag));
        }
        return ans;
    }
}
