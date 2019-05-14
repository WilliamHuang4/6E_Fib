/** 
  Calculate Fibonacci number n
  3 implementations
  @precondition: n >= 1
  
  Use type "long" instead of "int", because rabbits.
 */

public class Fib {
    /** 
      @return the nth Fibonacci number
              by implementing the recurrence relation
     */
    public static long fib_recurrence( int n) {
      if (n <= 2) // decision between base and recursive cases
            return 1; // solution to base case
        else // solution to recursive case
            return fib_recurrence(n - 1) + fib_recurrence(n - 2); // recursive abstraction
            //     ^leftover processing  ^combination  ^leftover processing
    }
     /* These are class methods because there are no instances of a Fib object.
    */


    /** 
      @return the nth Fibonacci number
              calculated via the 8th-grade algorithm
     */
    public static long fib_grade8( int n) {
    int first = 1;
        int second = 1;
        int temp; // temporary variable to store second and transfer to first
        for (int counter = 2; counter < n; counter++) { //counter is 2 because if n is less than or equal to 2, the fib number is 1
            temp = second;
            second += first;
            first = temp;
        }
        return second; //second is not actually (n-1), as in fib_recurrence, but rather the sum of (n-1) and (n-2), a.k.a the fib number.
    }
    /* Time complexity:
       Consider the size of the problem to be n
       
       As the proxy for the time required, count mathematical operations.
       
       Then cost of the the recurrence algorithm
       grows linearly 
       as the size of the problem increases,
       because the problem runs through a 'for' loop, running a static number
       of calculations for each 'n' (courtesy of Brian Moses)
     */


    /** 
      @return the nth Fibonacci number
              calculated via Binet's formula.
              Type is double so that this exercise can
              ignore rounding issues.
     */
    public static double fib_Binet( int n) {
        double phi = (1 + Math.sqrt(5)) / 2;
        double psi = (1 - Math.sqrt(5)) / 2;

        return Math.floor(
        (Math.pow(phi, n) - Math.pow(psi, n))
            / Math.sqrt(5));
    }
    /* Time complexity: Constant
       Consider the size of the problem to be n
       
       As the proxy for the time required, count mathematical operations
       
       Then cost of the the recurrence algorithm does not
       grow 
       as the size of the problem increases,
       because it is static and does not run through any loops. 
     */
}