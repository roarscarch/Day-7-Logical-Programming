/*
 * Learnt the difference between
 * Math.random() and Random.nextInt()
 * Math.random is a method which outputs a random number between 0 and 1
 * Random.nextInt is a method which outputs a random number between 0 and max
 * 
 */



import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CoupanNumbers {

    // generate a random coupon number
    private static int generateRandomCoupon(int max) {
        Random random = new Random();
        return random.nextInt(max) + 1;
    }

    
    public static int findDistinctCoupons(int couponNumbers) {
        int distinctCount = couponNumbers;
        Set<Integer> collectedCoupons = new HashSet<>();
        int randomCount = 0;

        while (collectedCoupons.size() < distinctCount) {
            int randomCoupon = generateRandomCoupon(distinctCount);

            
            if (!collectedCoupons.contains(randomCoupon)) {
                collectedCoupons.add(randomCoupon);
            }

            randomCount++;
        }

        return randomCount;
    }

    public static void main(String[] args) {
        
        int coupanNumbers=7; 


        
        int totalRandomNumbrs = findDistinctCoupons(coupanNumbers);
        System.out.println("Total random numbers needed: " + totalRandomNumbrs);
    }
}
