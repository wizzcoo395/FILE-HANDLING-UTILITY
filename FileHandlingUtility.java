import java.io.*;
import java.util.Scanner;

/**
 * FileHandlingUtility
 * -------------------
 * This program demonstrates basic file operations in Java:
 * 1. Writing to a file
 * 2. Reading from a file
 * 3. Modifying file content
 */
public class FileHandlingUtility {

    static final String FILE_NAME = "sample.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== FILE HANDLING UTILITY =====");
            System.out.println("1. Write to File");
            System.out.println("2. Read from File");
            System.out.println("3. Modify File");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    writeFile(sc);
                    break;
                case 2:
                    readFile();
                    break;
                case 3:
                    modifyFile(sc);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);

        sc.close();
    }

    /**
     * Writes user input to the file (overwrites existing content)
     */
    public static void writeFile(Scanner sc) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            System.out.print("Enter text to write: ");
            String data = sc.nextLine();
            writer.write(data);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    /**
     * Reads and displays content from the file
     */
    public static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n--- File Content ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Modifies file content by appending new text
     */
    public static void modifyFile(Scanner sc) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            System.out.print("Enter text to append: ");
            String data = sc.nextLine();
            writer.newLine();
            writer.write(data);
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }
}