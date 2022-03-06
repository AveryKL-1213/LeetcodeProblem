import java.util.Scanner;

public class CountAllValidPickupAndDeliveryOptions {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int ans = countOrders(n);
        System.out.println(ans);
    }

    public static int countOrders(int n) {
        long ans = 1;
        for (int i = n; i > 0; i--) {
            ans = ans * i * (i * 2L - 1) % ((int) Math.pow(10, 9) + 7);
        }
        return (int) ans;
    }
}
