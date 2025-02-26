import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility {

    public static void readFile(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            System.out.println("Reading the file: " + filename);
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void writeFile(String filename, String content) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(content);
            writer.close();
            System.out.println("Content written to the file: " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }

    public static void appendToFile(String filename, String content) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.append(content);
            writer.close();
            System.out.println("Content appended to the file: " + filename);
        } catch (IOException e) {
            System.out.println("Error appending to the file: " + e.getMessage());
        }
    }

    public static void modifyFile(String filename, String oldLine, String newLine) {
        try {
            File file = new File(filename);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder fileContents = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.equals(oldLine)) {
                    fileContents.append(newLine).append("\n");
                } else {
                    fileContents.append(line).append("\n");
                }
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(fileContents.toString());
            writer.close();
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String filename = "sample.txt";

        System.out.println("Enter content to write to the file:");
        String content = scanner.nextLine();
        writeFile(filename, content);

        System.out.println("\nReading the content of the file:");
        readFile(filename);

        System.out.println("\nEnter the line you want to modify:");
        String oldLine = scanner.nextLine();
        System.out.println("Enter the new content for the line:");
        String newLine = scanner.nextLine();
        modifyFile(filename, oldLine, newLine);

        System.out.println("\nEnter content to append to the file:");
        String appendContent = scanner.nextLine();
        appendToFile(filename, appendContent);

        System.out.println("\nReading the modified content of the file:");
        readFile(filename);

        scanner.close();
    }
}
