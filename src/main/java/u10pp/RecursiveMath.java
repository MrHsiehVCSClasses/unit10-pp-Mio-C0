package u10pp;
import java.math.BigInteger;
import java.math.*;

public class RecursiveMath {
    public static double pow(double base, int exponent) {
        // Pre condition n is non negative
        if (exponent >= 0) {

            // base case 
            if (exponent == 0 ) {
                return 1;
            
            // recursive case
            } else 
                return (base * pow(base, exponent - 1));
        } 

        // if n is negative
        return 0;
    }
    
    public static BigInteger getFactorial(int n) {
        BigInteger num = BigInteger.valueOf(n);
        BigInteger one = BigInteger.ONE;

        //Pre condition: n is non negative
        if (n >= 0) {

            // base case
            if (n == 0) {
                return one;

            //recursive case
            } else 
                return num.multiply(getFactorial(n-1)); 
        }

        // if n is negative
        return BigInteger.ZERO;
    }

    
    public static long getFibonacciNumber(int n) {
        // Pre condition n is non negative
        if ( n >= 0 ) {

            // base case
            if (n <= 1) {
            return n;

            // recursive case
            } else 
                return getFibonacciNumber(n-1) + getFibonacciNumber(n-2);
        }
        // if n is negative
        return 0;
    }
}