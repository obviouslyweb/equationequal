import java.util.Random;
import java.util.Scanner;

public class Main {

    // Attribute declaration
    static boolean menuActive = true;

    // Module declaration

    public static void main(String[] args)
    {
        Scanner scan_menu = new Scanner(System.in);

        while ( menuActive )
        {
            Menu.DisplayMenu(); // Display menu
            String userInput = scan_menu.nextLine(); // Obtain user input
            
            if ( 1 == Integer.parseInt(userInput) ) {
                GameLoop();  
            } else {
                System.out.println("Incorrect");
            }
        }
        scan_menu.close();
    }

    public static void GameLoop()
    {
        Scanner scan_game = new Scanner(System.in);
        Random rand_1 = new Random();

        int number = rand_1.nextInt(3); // Generate number
            
        System.out.println(number); // Print number DEV TEST
            
        String userInput = scan_game.nextLine(); // Obtain user guess
            
        if ( number == Integer.parseInt(userInput) ) {
             System.out.println("Correct");
        } else {
             System.out.println("Incorrect");
        }

        scan_game.close();
    }
}