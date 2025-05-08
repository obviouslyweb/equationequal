public class Menu {

    // Attribute declaration
    private static String Menu1 = 
                "\n[[ -- EquationEqual -- ]]\n" +
                "0) Quit to terminal\n" +
                "1) Start game" +
                "\n2) Replay missed questions" +
                "\n3) Options" +
                "\nSelection: ";
    private static String SettingsMenu1 = 
                "\n[--- Options Menu ---]\n" +
                "0) Return to main menu\n" +
                "1) Change number selection bounds\n" +
                "2) Delete all missed equations\n" +
                "Selection: ";
    
    // Module declaration

    public static void DisplayMenu() {
        System.out.print(Menu1);
    }

    public static void DisplaySettings() {
        System.out.print(SettingsMenu1);
    }
}