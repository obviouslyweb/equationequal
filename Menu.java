public class Menu {

    // Attribute declaration
    private static int UnlockLevel = 1;
    private static String Menu1 = 
                "--- Number Guesser Main Menu ---\n" +
                "0) Quit to terminal\n" +
                "1) Start game" +
                "\n2) Options" +
                "\nSelection: ";
    private static String Menu2 = "";
    private static String SettingsMenu1 = 
                "--- Options Menu ---\n" +
                "0) Return to main menu\n" +
                "1) Change number bounds\n" +
                "Selection: ";
    
    // Module declaration

    public static void DisplayMenu() {
        System.out.print(Menu1);
    }

    public static void DisplaySettings() {
        System.out.print(SettingsMenu1);
    }

    public static void UpdateLevel(){
        UnlockLevel++;
    }
}