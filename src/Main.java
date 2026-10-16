public class Main {

    public static void main(String[] args) {
        System.out.println("power(2, 10) = " + power(2, 10));       // 1024
        System.out.println("sumDigits(1234) = " + sumDigits(1234)); // 10
        System.out.println("fibonacci(10) = " + fibonacci(10));     // 55

        System.out.println("radar -> " + isPalindrome("radar"));    // true
        System.out.println("level -> " + isPalindrome("level"));    // true
        System.out.println("java -> " + isPalindrome("java"));      // false
    }

    // base elevated to exp: 2^10 = 2 * 2^9 = 2 * 2 * 2^8 ...
    public static int power(int base, int exp) {
        if (exp == 0) {                        // base case: anything^0 = 1
            return 1;
        }
        return base * power(base, exp - 1);    // recursive case
    }

    // Sum of the digits: 1234 -> 4 + sumDigits(123) -> 4 + 3 + sumDigits(12) ...
    public static int sumDigits(int n) {
        if (n < 10) {                          // base case: only one digit left
            return n;
        }
        return n % 10 + sumDigits(n / 10);     // last digit + sum of the rest
    }

    // Fibonacci: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
    public static int fibonacci(int n) {
        if (n <= 1) {                          // base cases: fib(0) = 0, fib(1) = 1
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // "radar": 'r' == 'r' -> check "ada": 'a' == 'a' -> check "d" -> true
    public static boolean isPalindrome(String text) {
        if (text.length() <= 1) {              // base case: 0 or 1 character
            return true;
        }
        char first = text.charAt(0);
        char last = text.charAt(text.length() - 1);
        if (first != last) {                   // base case: found a difference
            return false;
        }
        String middle = text.substring(1, text.length() - 1);
        return isPalindrome(middle);           // recursive case: check the middle
    }
}
