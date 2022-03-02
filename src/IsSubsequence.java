public class IsSubsequence {
    public static void main(String[] args) {
        String s = "";
        String t = "ahbgdc";
        boolean ans = isSubsequence(s, t);
        System.out.println(ans);
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int sFlag = 0;
        int tFlag;
        for (tFlag = 0; tFlag < t.length(); tFlag++) {
            if (t.charAt(tFlag) == s.charAt(sFlag)) {
                sFlag++;
            }
            if (sFlag == s.length()) {
                return true;
            }
        }
        return false;
    }
}
