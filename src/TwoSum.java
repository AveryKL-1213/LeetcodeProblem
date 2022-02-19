import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] ans = twoSum(nums, 9);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer requiredNum = target - nums[i];
            if (indexMap.containsKey(requiredNum)) {
                return new int[]{indexMap.get(requiredNum), i};
            }
            indexMap.put(nums[i], i);
        }
        return null;
    }

}
