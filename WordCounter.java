import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Word Counter!");
        System.out.print("Enter 'text' to input text manually or 'file' to provide a file: ");
        String choice = scanner.nextLine().trim();

        if (choice.equalsIgnoreCase("text")) {
            System.out.print("Enter the text: ");
            String inputText = scanner.nextLine();
            int wordCount = countWords(inputText);
            System.out.println("Total words: " + wordCount);
        } else if (choice.equalsIgnoreCase("file")) {
            System.out.print("Enter the file path: ");
            String filePath = scanner.nextLine();
            try {
                String fileContent = readFile(filePath);
                int wordCount = countWords(fileContent);
                System.out.println("Total words: " + wordCount);
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    public static int countWords(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    }

    public static String readFile(String filePath) throws FileNotFoundException {
        StringBuilder content = new StringBuilder();
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine()) {
                content.append(fileScanner.nextLine()).append("\n");
            }
        }
        return content.toString();
    }
}