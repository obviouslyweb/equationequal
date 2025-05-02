import java.util.Scanner;

public class InputHandler {

    private InputHandler() {
        // Prevent instantiation
    }

    public static int ObtainIntInput(Scanner scanner, int messageType)
    {
        while ( true ) {
            String userInput = scanner.nextLine();

            if ( VerifyInput(userInput ) ) {
                return Integer.parseInt(userInput);
            } else {
                System.out.println("That is not an acceptable input; please type an integer.");
                if ( messageType == 1 ) {
                    System.out.print("Selection: ");
                }
            }
        }
    }

    public static boolean VerifyInput(String input)
    {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}