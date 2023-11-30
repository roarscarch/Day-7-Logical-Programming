public class PrimeNumber {

    public static boolean isPrime(int n) {// remember sqrt(n) and not till n/2.
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        boolean ans= isPrime(4);
        System.out.println(ans);
    }
    
}
