public class MathUtils {


    public static long factorial(int n) {
        if (n < 0) return -1; // Edge case: negative number
        if (n == 0 || n == 1) return 1; // Edge case: zero or one
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }


    public static boolean isPrime(int n) {
        if (n <= 1) return false; // Edge case: 0, 1, and negatives
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }


    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    public static long findFibonacci(int n) {
        if (n < 0) return -1; // Edge case: negative
        if (n <= 1) return n; // Edge case: 0 or 1
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Is 17 prime? " + isPrime(17));
        System.out.println("Is 15 prime? " + isPrime(15));
        System.out.println("GCD of 54 and 24: " + findGCD(54, 24));
        System.out.println("10th Fibonacci number: " + findFibonacci(10));
    }
}