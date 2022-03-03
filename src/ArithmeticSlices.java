public class ArithmeticSlices {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4};
        int ans = numberOfArithmeticSlices(nums);
        System.out.println(ans);
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len - 2; i++) {
            int j = i;
            while (j + 2 < len) {
                if (nums[j + 1] - nums[j] == nums[j + 2] - nums[j + 1]) {
                    ans++;
                    j++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}
