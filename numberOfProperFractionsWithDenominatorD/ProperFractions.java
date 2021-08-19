package numberOfProperFractionsWithDenominatorD;

/** TODO:
 * Algorithm needs to be optimized (Linear solution can be done here I think ;))
 */

// https://www.codewars.com/kata/55b7bb74a0256d4467000070

public class ProperFractions {

    public static long properFractions(long n) {
        long counter = 0;
        for(long i = 1; i < n; i++) {
            if(GCD(n,i) == 1) {
                counter++;
            }
        }
        return counter;
    }


    public static long GCD(long a, long b) {
        return b == 0 ? a : GCD(b, a % b);
    }

}
