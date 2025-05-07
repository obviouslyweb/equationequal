import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveLoad {

    public static void UpdateOptions(int topbound, int bottombound, ArrayList<Equation> missedequations)
    {
        try {
            FileWriter writer = new FileWriter("options.txt");
            writer.write("bottombound:" + bottombound + "\ntopbound:" + topbound);
            writer.write("\nmissedequations:");
            for (int i = 0; i < missedequations.size(); i++) {
                writer.write(missedequations.get(i).SerializeEquation());
                if (i < missedequations.size() - 1) {
                    writer.write(";");
                }
            }
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred when attempting to write to 'options.txt'. Please let me know if you see this!");
            e.printStackTrace();
        }
    }

    public static void ReadOptions()
    {
        try {
            File options = new File("options.txt");
            Scanner scanner_file = new Scanner(options);
            while (scanner_file.hasNextLine()) {
                String line = scanner_file.nextLine();
                String[] parts = line.split(":");
    
                if (parts.length == 2) {
                    String key = parts[0].trim();
    
                    if (key.equals("bottombound")) {
                        int value = Integer.parseInt(parts[1].trim());
                        Equation.SetBottomBound(value);
                    } else if (key.equals("topbound")) {
                        int value = Integer.parseInt(parts[1].trim());
                        Equation.SetTopBound(value);
                    } else if (key.equals("missedequations")) {
                        String[] serializedEquations = parts[1].trim().split(";");
                        for (String s : serializedEquations) {
                            if (!s.isBlank()) {
                                Equation equation = Equation.DeserializeEquation(s);
                                Guesser.AddToMissedEquations(equation);
                            }
                        }
                    }
                } else {
                    System.out.println("Invalid line format in 'options.txt': " + line + ". If you see this, please let me know!");
                }
            }    
            scanner_file.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred; 'options.txt' couldn't be found. If you see this, please let me know!");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number from 'options.txt.'' If you see this, please let me know!");
            e.printStackTrace();
        }
    }
}