import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        List<Integer> ans = partitionLabels(s);
        System.out.println("ans: " + ans);
    }

    public static List<Integer> partitionLabels(String s) {
        int[][] range = new int[26][2];
        boolean[] seen = new boolean[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char tmp = s.charAt(i);
            if (!seen[tmp - 'a']) {
                seen[tmp - 'a'] = true;
                range[tmp - 'a'][0] = i + 1;
            } else {
                range[tmp - 'a'][1] = i + 1;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (range[i][0] > range[i][1]) {
                range[i][1] = range[i][0];
            }
        }
        ArrayList<int[]> usable = new ArrayList<>();
        for (int[] tmp : range) {
            int start = tmp[0];
            if (tmp[0] != 0) {
                int i;
                for (i = 0; i < usable.size(); i++) {
                    if (usable.get(i)[0] >= start) {
                        break;
                    }
                }
                usable.add(i, tmp);
            }
        }
        ArrayList<int[]> rangeList = new ArrayList<>();
        for (int[] tmp : usable) {
            if (tmp[0] == 0 && tmp[1] == 0) {
                continue;
            }
            boolean add = false;
            for (int[] tmpRange : rangeList) {
                if ((tmpRange[0] <= tmp[0] && tmpRange[1] >= tmp[0]) || (tmpRange[0] <= tmp[1] && tmpRange[1] >= tmp[1]) ||
                        (tmp[0] <= tmpRange[0] && tmp[1] >= tmpRange[0]) || (tmp[0] <= tmpRange[1] && tmp[1] >= tmpRange[1])) {
                    tmpRange[0] = Math.min(tmpRange[0], tmp[0]);
                    tmpRange[1] = Math.max(tmpRange[1], tmp[1]);
                    add = true;
                    break;
                }
            }
            if (!add) {
                rangeList.add(tmp);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int[] tmp : rangeList) {
            ans.add(tmp[1] - tmp[0] + 1);
        }
        return ans;
    }
}
