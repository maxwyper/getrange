import java.util.Scanner;

public class InputHelper {

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int result = 0;
        boolean validInput = false;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: "); // Append the range to the prompt
            if (pipe.hasNextInt()) { // Check if the input is a valid integer
                result = pipe.nextInt(); // Read the integer
                pipe.nextLine(); // Clear the input buffer (newline fix)
                if (result >= low && result <= high) { // Check if the integer is within range
                    validInput = true; // Valid input received
                } else {
                    System.out.println("Invalid input: " + result + " is out of range. Please enter a number between " + low + " and " + high + ".");
                }
            } else {
                String trash = pipe.nextLine(); // Read and discard the invalid input
                System.out.println("Invalid input: \"" + trash + "\". Please enter a valid integer.");
            }
        } while (!validInput);

        return result;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int userInt = getRangedInt(console, "Enter an integer", 1, 10);
        System.out.println("You entered: " + userInt);
    }
}
