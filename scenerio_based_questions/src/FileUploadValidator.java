import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

// Custom Exception
class InvalidFileFormatException extends Exception {
    public InvalidFileFormatException(String message) {
        super(message);
    }
}

public class FileUploadValidator {

    public static void validateAndReadFile(String filePath, List<String> requiredHeaders) throws InvalidFileFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String headerLine = reader.readLine();
            if (headerLine == null) {
                throw new InvalidFileFormatException("File is empty or corrupted.");
            }

            String[] headers = headerLine.split(",");
            List<String> headerList = Arrays.asList(headers);

            // Check if all required headers are present [cite: 61]
            for (String requiredHeader : requiredHeaders) {
                if (!headerList.contains(requiredHeader)) {
                    throw new InvalidFileFormatException("Missing required header: " + requiredHeader);
                }
            }
            System.out.println("File validation successful. Headers are correct.");

            // Continue processing the file...
            String line;
            while ((line = reader.readLine()) != null) {
                // Process data rows
                System.out.println("Data: " + line);
            }

        }
    }

    public static void main(String[] args) {
        // Create a dummy CSV file for testing
        // In a real scenario, this file would exist on the filesystem.
        // For this example, let's simulate by checking for a non-existent file.
        String correctFilePath = "data.csv"; // Assume this file has "ID,Name,Email"
        String wrongHeaderPath = "bad_data.csv"; // Assume this file is missing "Email"
        String nonExistentPath = "no_file.csv";

        List<String> headers = Arrays.asList("ID", "Name", "Email");

        try {
            System.out.println("--- Testing with non-existent file ---");
            validateAndReadFile(nonExistentPath, headers);
        } catch (IOException e) {
            // Catches and logs IOExceptions [cite: 62]
            System.err.println("Error reading file: " + e.getMessage());
        } catch (InvalidFileFormatException e) {
            System.err.println("File format error: " + e.getMessage());
        }
    }
}