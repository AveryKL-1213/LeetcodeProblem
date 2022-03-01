import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        int num = 5;
        int[] ans = countBits(num);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            String tmp = Integer.toBinaryString(i);
            int len = tmp.length();
            int tmpAns = 0;
            for (int j = 0; j < len; j++) {
                if (tmp.charAt(j) == '1') {
                    tmpAns++;
                }
            }
            ans[i] = tmpAns;
        }
        return ans;
    }
}
