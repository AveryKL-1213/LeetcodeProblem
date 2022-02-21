import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int ans = majorityElement(nums);
        System.out.println(ans);
    }

    public static int majorityElement(int[] nums) {
        ArrayList<Integer[]> ansList = new ArrayList<>();
        ArrayList<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            if (!numList.contains(num)) {
                numList.add(num);
                Integer[] tmp = {num, 1};
                ansList.add(tmp);
            } else {
                int index = numList.indexOf(num);
                Integer[] tmp = ansList.get(index);
                tmp[1] = tmp[1] + 1;
                ansList.set(index, tmp);
            }
        }
        int max = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        for (Integer[] tmp : ansList) {
            if (tmp[1] >= max) {
                max = tmp[1];
                ans = tmp[0];
            }
        }
        return ans;
    }

//    public static int majorityElement(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            if (map.containsKey(num)) {
//                map.put(num, map.get(num) + 1);
//            } else {
//                map.put(num, 1);
//            }
//        }
//        int majority = (nums.length / 2);
//        int result = 0;
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() > majority) {
//                result = entry.getKey();
//            }
//        }
//        return result;
//    }

}
