import java.math.BigInteger; // Import BigInteger class for handling very large integers
import java.util.Scanner; // Import Scanner class for user input

public class TetranacciCalculator1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create Scanner object for reading user input
        String input;

        while (true) { // Infinite loop to repeatedly prompt user
            System.out.print("Enter a non-negative integer n (or type 'exit' to quit): ");
            input = scanner.nextLine(); // Read input from user

            if (input.equalsIgnoreCase("exit")) { // Check if user wants to exit
                System.out.println("Exiting program. Goodbye!");
                break; // Exit the loop
            }

            try {
                int n = Integer.parseInt(input); // Attempt to parse the input to an integer

                if (n < 0) { // Check for non-negative condition
                    System.out.println("Please enter a non-negative integer.");
                    continue; // Ask for input again
                }

                long startTime = System.nanoTime(); // Record start time for performance measurement

                BigInteger result = linearTetranacci(n); // Calculate the Tetranacci number

                long endTime = System.nanoTime(); // Record end time
                long duration = endTime - startTime; // Calculate execution time
                double seconds = duration / 1_000_000_000.0; // Convert to seconds

                // Display the result and execution time
                System.out.println("Tetranacci(" + n + ") = " + result);
                System.out.println("Execution time: " + seconds + " seconds");
            } catch (NumberFormatException e) {
                // Handle invalid input that cannot be parsed to an integer
                System.out.println("Invalid input. Please enter a valid non-negative integer or 'exit'.");
            }
        }

        scanner.close(); // Close the scanner
    }

    // Method to compute Tetranacci number using a linear recursive helper
    public static BigInteger linearTetranacci(int n) {
        // Base cases as per the Tetranacci sequence definition
        if (n == 0 || n == 1 || n == 2) {
            return BigInteger.ZERO;
        } else if (n == 3) {
            return BigInteger.ONE;
        } else {
            // Call the helper method starting from index 4
            return tetranacciCompute(n, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ONE, 4);
        }
    }

    // Recursive helper function to compute Tetranacci linearly
    private static BigInteger tetranacciCompute(int n, BigInteger t0, BigInteger t1, BigInteger t2, BigInteger t3,
            int currentIndex) {
        if (currentIndex > n) {
            return t3; // Return the nth Tetranacci number
        }

        // Compute the next Tetranacci number in the sequence
        BigInteger next = t0.add(t1).add(t2).add(t3);

        // Recursive call with updated values and index
        return tetranacciCompute(n, t1, t2, t3, next, currentIndex + 1);
    }
}
