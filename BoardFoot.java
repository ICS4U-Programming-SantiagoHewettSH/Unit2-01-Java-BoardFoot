import java.util.Scanner;

/**
 * This program calculates the required length of a board
 * when given its width and height, so that its volume
 * equals exactly 1 board foot (144 cubic inches).
 *
 * @author  Santiago Hewett
 * @version 1.0
 * @since   2025/03/20
 */
final class BoardFoot {

   /**
    * A board foot is defined as 144 cubic inches.
    */
   public static final double BOARD_FOOT = 144;

   /**
    * Private constructor to prevent this utility class from being instantiated.
    */
   private BoardFoot() {
       throw new IllegalStateException("Utility class");
   }

   /**
    * Main method that drives the program.
    *
    * @param args Unused command-line arguments.
    */
   public static void main(final String[] args) {
       // Display a welcome message and explain the program's purpose
       System.out.print("This program calculates the required length "
               + "of a piece of wood given its width and height.");
       System.out.println(" It ensures the total volume equals exactly "
               + "1 board foot (144 cubic inches).");

       // Create a scanner object to read user input
       Scanner scanner = new Scanner(System.in);

       // Variables to store user input for height and width
       double userHeightDouble = 0;
       double userWidthDouble = 0;

       // Loop until the user enters valid dimensions
       do {
           // Prompt the user for the height of the wood
           System.out.println("Please enter the height of ");
           System.out.print(" the piece of wood (in inches): ");
           String userHeightString = scanner.nextLine();

           // Prompt the user for the width of the wood
           System.out.println("Please enter the width of ");
           System.out.print("the piece of wood (in inches): ");
           String userWidthString = scanner.nextLine();

           // Try to convert the input into numerical values
           try {
               userHeightDouble = Double.parseDouble(userHeightString);
               userWidthDouble = Double.parseDouble(userWidthString);

               // Ensure the values are positive
               if (userWidthDouble <= 0 || userHeightDouble <= 0) {
                   System.out.println("Invalid input: " + userHeightString
                           + " and/or " + userWidthString
                           + ". Please enter positive numbers.");
               }
           } catch (NumberFormatException error) {
               // Handle cases where the input isn't a valid number
               System.out.println("Invalid input: " + userHeightString
                       + " and/or " + userWidthString
                       + ". Please enter numerical values greater than 0.");
           }

       // Keep looping until valid values are entered
       } while (userWidthDouble <= 0 || userHeightDouble <= 0);

       // Calculate the required length using the helper method
       double length = calculateBoardFoot(userWidthDouble, userHeightDouble);

       // Display the calculated length to the user
       System.out.print("To make exactly 1 board foot, ");
       System.out.print("the required length is ");
       System.out.format("%.2f", length);
       System.out.println(" inches.");

       // Close the scanner to prevent resource leaks
       scanner.close();
   }

   /**
    * Calculates the required length of wood to achieve 1 board foot.
    *
    * @param userWidthDouble The width of the wood in inches.
    * @param userHeightDouble The height of the wood in inches.
    * @return The required length in inches.
    */
   public static double calculateBoardFoot(
           final double userWidthDouble, final double userHeightDouble) {
       return BOARD_FOOT / (userWidthDouble * userHeightDouble);
   }
}
