import java.util.Scanner;

public class Main {

    // Attribute declaration
    static boolean menuActive = true;

    // Module declaration

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        while ( menuActive )
        {
            Menu.DisplayMenu(); // Display menu
            String userInput = scanner.nextLine(); // Obtain user input
            
            if ( 0 == Integer.parseInt(userInput) ) {
                menuActive = false;
            } else if ( 1 == Integer.parseInt(userInput) ) {
                Guesser.GameLoop(scanner); 
            } else if ( 2 == Integer.parseInt(userInput) ) {
                Settings(scanner);
            } else {
                System.out.println("Unacceptable input; please try again.");
            }
        }
        scanner.close();
    }

    public static void Settings(Scanner scanner)
    {
        while ( true ) {

            Menu.DisplaySettings();
            String userInput = scanner.nextLine();

            if ( 0 == Integer.parseInt(userInput) ) {
                break;
            } else {
                if ( 1 == Integer.parseInt(userInput)) {
                    // Option
                }   
            }
        }
    }

    // Likely more here eventually

}