public class PerfectNumber {

    public static Boolean perfectNumber(int n) {
        int sum = 1; // Start with 1 since every number is divisible by 1
        for (int i = 2; i <= n / 2; i++) {// remember n/2 not sqrt(n)
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum == n;
    }

    public static void main(String args[]) {
        int n = 28;
        Boolean ans = perfectNumber(n);
        System.out.println(ans);
    }
}
