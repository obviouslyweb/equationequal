import java.util.Random;
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
            
            if ( 1 == Integer.parseInt(userInput) ) {
                GameLoop(scanner);  
            } else {
                System.out.println("Incorrect");
            }
        }
        scanner.close();
    }

    public static void GameLoop(Scanner scanner)
    {
        Random rand_1 = new Random();

        int number = rand_1.nextInt(3); // Generate number
            
        System.out.println(number); // Print number DEV TEST
            
        String userInput = scanner.nextLine(); // Obtain user guess
            
        if ( number == Integer.parseInt(userInput) ) {
             System.out.println("Correct");
        } else {
             System.out.println("Incorrect");
        }

    }
}