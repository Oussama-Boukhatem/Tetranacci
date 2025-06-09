import java.math.BigInteger; // Import BigInteger to handle very large integers
import java.util.Scanner; // Import Scanner for reading user input

public class TetranacciCalculator2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for input
        String input;

        while (true) { // Loop continuously until user types 'exit'
            System.out.print("Enter a non-negative integer n (or type 'exit' to quit): ");
            input = scanner.nextLine(); // Read user input

            if (input.equalsIgnoreCase("exit")) { // Exit condition
                System.out.println("Exiting program. Goodbye!");
                break; // Exit the loop
            }

            try {
                int n = Integer.parseInt(input); // Convert input string to integer

                if (n < 0) { // Ensure the number is non-negative
                    System.out.println("Please enter a non-negative integer.");
                    continue;
                }

                long startTime = System.nanoTime(); // Start timing the computation

                BigInteger result = multipleTetranacci(n); // Compute the Tetranacci number using recursive method

                long endTime = System.nanoTime(); // End timing
                long duration = (endTime - startTime); // Calculate duration
                double seconds = duration / 1_000_000_000.0; // Convert to seconds

                // Display the result and execution time
                System.out.println("Tetranacci(" + n + ") = " + result);
                System.out.println("Execution time: " + seconds + " seconds");
            } catch (NumberFormatException e) {
                // Handle case when input is not a valid integer
                System.out.println("Invalid input. Please enter a valid non-negative integer or 'exit'.");
            }
        }

        scanner.close(); // Close the scanner resource
    }

    // Recursive method to compute Tetranacci numbers
    public static BigInteger multipleTetranacci(int n) {
        // Base cases of the Tetranacci sequence
        if (n == 0 || n == 1 || n == 2) {
            return BigInteger.ZERO;
        } else if (n == 3) {
            return BigInteger.ONE;
        } else {
            // Recursive call: T(n) = T(n-1) + T(n-2) + T(n-3) + T(n-4)
            return multipleTetranacci(n - 1)
                    .add(multipleTetranacci(n - 2))
                    .add(multipleTetranacci(n - 3))
                    .add(multipleTetranacci(n - 4));
        }
    }
}
