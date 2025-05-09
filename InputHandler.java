import java.util.Scanner;

public class InputHandler {

    public static int ObtainIntInput(Scanner scanner, int messageType)
    {
        while ( true ) {
            
            String userInput = scanner.nextLine();

            if (VerifyInput(userInput)) {
                int value = Integer.parseInt(userInput);
                if (value < 0) {
                    System.out.println("Negative numbers are not allowed; please enter a non-negative integer.");
                } else {
                    return value;
                }
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

    public static String ObtainGameInput(Scanner scanner)
    {
        while ( true ) {
            
            String userInput = scanner.nextLine();

            if ( VerifyInput(userInput) ) {
                return userInput;
            } else {
                if ( userInput.equals("end")) {
                    return userInput;
                } else {
                    System.out.println("That is not an acceptable input; please type an integer.");
                }
            }
        }
    }
}