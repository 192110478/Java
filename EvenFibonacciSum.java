public class EvenFibonacciSum {
    public static void main(String[] args) {
        int limit = 4000000; // Assuming the sum is until the Fibonacci number less than 4 million
        int first = 1, second = 2, sum = 0;

        while (second <= limit) {
            if (second % 2 == 0) {
                sum += second;
            }
            int next = first + second;
            first = second;
            second = next;
        }

        System.out.println("Sum of even Fibonacci numbers less than " + limit + " is: " + sum);
    }
}