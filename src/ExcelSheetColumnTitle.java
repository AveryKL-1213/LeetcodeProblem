public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        int no = 702;
        String ans = convertToTitle(no);
        System.out.println(ans);
    }

    public static String convertToTitle(int columnNumber) {
        int tmp = columnNumber;
        StringBuilder ans = new StringBuilder();
        while (true) {
            int a = tmp / 26;
            int b = tmp % 26;
            if (b == 0 && a > 0) {
                b = 26;
                a--;
            }
            char tmpAns = (char) (b + 64);
            ans.insert(0, tmpAns);
            if (a <= 26 && a > 0) {
                tmpAns = (char) (a + 64);
                ans.insert(0, tmpAns);
                break;
            } else if (a == 0) {
                break;
            } else {
                tmp = a;
            }
        }
        return ans.toString();
    }
}
