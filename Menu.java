public class Menu {

    // Attribute declaration
    private static int UnlockLevel = 1;
    private static String Menu1 = "Number Guesser Main Menu\n1) Start game\n2) Quit game\nSelection: ";
    private static String Menu2 = "";
    
    // Module declaration

    public static void DisplayMenu() {
        System.out.print(Menu1);
    }

    public static void UpdateLevel(){
        UnlockLevel++;
    }
}