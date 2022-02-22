public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        String title = "ZY";
        int ans = titleToNumber(title);
        System.out.println(ans);
    }

    public static int titleToNumber(String columnTitle) {
        int len = columnTitle.length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int tmp = columnTitle.charAt(i);
            ans += Math.pow(26, len - i - 1) * (tmp - 64);
        }
        return ans;
    }
}
