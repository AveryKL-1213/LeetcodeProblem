public class NumberOfOneBits {
    public static void main(String[] args) {
        int n = -3;
        int ans = hammingWeight(n);
        System.out.println(ans);
    }

    public static int hammingWeight(int n) {
        String binaryN = Integer.toBinaryString(n);
        int ans = 0;
        for (int i = 0; i < binaryN.length(); i++) {
            if (binaryN.charAt(i) == '1') {
                ans++;
            }
        }
        return ans;
    }
}
