import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompareVersionNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String[] version = input.split(" ");
        String version1 = version[0];
        String version2 = version[1];
        int ans = compareVersion(version1, version2);
        System.out.println(ans);
    }

    public static int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int len = Math.max(split1.length, split2.length);
        for (int i = 0; i < len; i++) {
            int a = i >= split1.length ? 0 : Integer.parseInt(split1[i]);
            int b = i >= split2.length ? 0 : Integer.parseInt(split2[i]);
            if (a < b)
                return -1;
            else if (a > b)
                return 1;
        }
        return 0;
    }
}
