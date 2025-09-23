import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentScoreManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> scoreList = new ArrayList<>();

        System.out.println("Enter student scores (type 'done' to finish):");

        // Input loop to gather scores [cite: 36]
        while (true) {
            System.out.print("Enter score: ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                int score = Integer.parseInt(input);
                if (score < 0 || score > 100) {
                    System.out.println("Invalid input: Score must be between 0 and 100.");
                    continue;
                }
                scoreList.add(score);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: Please enter a number or 'done'."); // [cite: 40]
            }
        }

        if (scoreList.isEmpty()) {
            System.out.println("No scores were entered.");
            return;
        }

        // Convert list to array
        int[] scores = scoreList.stream().mapToInt(i -> i).toArray();
        int sum = 0;
        int highest = scores[0];
        int lowest = scores[0];

        for (int score : scores) {
            sum += score;
            if (score > highest) highest = score; // [cite: 38]
            if (score < lowest) lowest = score;   // [cite: 38]
        }

        double average = (double) sum / scores.length; // [cite: 37]

        System.out.println("\n--- Score Analysis ---");
        System.out.printf("Average Score: %.2f\n", average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);

        System.out.println("\nScores above average:"); // [cite: 39]
        for (int score : scores) {
            if (score > average) {
                System.out.print(score + " ");
            }
        }
        System.out.println("\n--------------------");
        scanner.close();
    }
}