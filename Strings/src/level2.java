import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

//********** JAVA STRINGS LEVEL-2 PRACTICE PROGRAMS *************************

//--- Program 1: Find String Length without length() method ---
class LengthFinder {

    /**
     * Finds the length of a string without using the built-in length() method.
     * It counts characters until an exception is thrown.
     * @param text The input string.
     * @return The length of the string.
     */
    public static int getStringLengthCustom(String text) {
        int count = 0;
        try {
            for (int i = 0; ; i++) {
                text.charAt(i);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // The exception indicates we have reached the end of the string.
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = input.next();

        // Get length from custom method
        int customLength = getStringLengthCustom(text);
        System.out.println("Length from custom method: " + customLength);

        // Get length from built-in method
        int builtinLength = text.length();
        System.out.println("Length from built-in method: " + builtinLength);

        System.out.println("Do both methods return the same length? " + (customLength == builtinLength));
        input.close();
    }
}

//--- Program 2: Split a string into words without split() method ---
class StringSplitter {

    /**
     * Splits a string into words based on spaces, without using the built-in split() method.
     * @param text The input text.
     * @return An array of words.
     */
    public static String[] splitStringCustom(String text) {
        // First, count the words to determine array size
        int wordCount = 0;
        if (!text.isEmpty()) {
            wordCount = 1;
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == ' ') {
                    wordCount++;
                }
            }
        }

        String[] words = new String[wordCount];
        StringBuilder currentWord = new StringBuilder();
        int wordIndex = 0;

        // Build words and add them to the array
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                currentWord.append(text.charAt(i));
            } else {
                words[wordIndex] = currentWord.toString();
                wordIndex++;
                currentWord.setLength(0); // Reset for the next word
            }
        }
        // Add the last word
        words[wordIndex] = currentWord.toString();

        return words;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String text = input.nextLine();

        // Split using custom method
        String[] customSplit = splitStringCustom(text);
        System.out.println("Words from custom split: " + Arrays.toString(customSplit));

        // Split using built-in method
        String[] builtinSplit = text.split(" ");
        System.out.println("Words from built-in split: " + Arrays.toString(builtinSplit));

        // Compare results
        boolean areSame = Arrays.equals(customSplit, builtinSplit);
        System.out.println("Are both results identical? " + areSame);
        input.close();
    }
}

//--- Program 3: Split words and return with their lengths ---
class WordLengthAnalyzer {

    // Reusing custom split method from Program 2
    public static String[] splitStringCustom(String text) {
        int wordCount = text.isEmpty() ? 0 : 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') wordCount++;
        }
        String[] words = new String[wordCount];
        StringBuilder currentWord = new StringBuilder();
        int wordIndex = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                currentWord.append(text.charAt(i));
            } else {
                words[wordIndex++] = currentWord.toString();
                currentWord.setLength(0);
            }
        }
        words[wordIndex] = currentWord.toString();
        return words;
    }

    /**
     * Creates a 2D array containing words and their corresponding lengths.
     * @param words An array of words.
     * @return A 2D String array where each row is [word, length].
     */
    public static String[][] getWordsAndLengths(String[] words) {
        String[][] data = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            data[i][0] = words[i];
            data[i][1] = String.valueOf(words[i].length()); // Using built-in length for simplicity here
        }
        return data;
    }

    /**
     * Displays a 2D array in a tabular format.
     * @param data The 2D array to display.
     */
    public static void displayWordsAndLengths(String[][] data) {
        System.out.println("\n--- Words and Their Lengths ---");
        System.out.println("Word\t\t| Length");
        System.out.println("----------------|--------");
        for (String[] row : data) {
            System.out.printf("%-15s | %s\n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String text = input.nextLine();

        String[] words = splitStringCustom(text);
        String[][] wordsAndLengths = getWordsAndLengths(words);
        displayWordsAndLengths(wordsAndLengths);
        input.close();
    }
}

//--- Program 4: Find Shortest and Longest Words ---
class ShortestLongestFinder {

    // Reusing custom split method
    public static String[] splitStringCustom(String text) {
        int wordCount = text.isEmpty() ? 0 : 1;
        for (int i = 0; i < text.length(); i++) if (text.charAt(i) == ' ') wordCount++;
        String[] words = new String[wordCount];
        StringBuilder currentWord = new StringBuilder();
        int wordIndex = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') currentWord.append(text.charAt(i));
            else {
                words[wordIndex++] = currentWord.toString();
                currentWord.setLength(0);
            }
        }
        words[wordIndex] = currentWord.toString();
        return words;
    }

    /**
     * Finds the shortest and longest words from an array of words.
     * @param words The array of words.
     * @return A String array containing the shortest word at index 0 and longest at index 1.
     */
    public static String[] findShortestAndLongest(String[] words) {
        if (words == null || words.length == 0) {
            return new String[]{"", ""};
        }
        String shortest = words[0];
        String longest = words[0];
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() < shortest.length()) {
                shortest = words[i];
            }
            if (words[i].length() > longest.length()) {
                longest = words[i];
            }
        }
        return new String[]{shortest, longest};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String text = input.nextLine();

        String[] words = splitStringCustom(text);
        String[] result = findShortestAndLongest(words);

        System.out.println("\nShortest word: " + result[0]);
        System.out.println("Longest word: " + result[1]);
        input.close();
    }
}

//--- Program 5: Count Vowels and Consonants ---
class VowelConsonantCounter {

    /**
     * Determines if a character is a vowel, consonant, or not a letter.
     * @param c The character to check.
     * @return A string indicating the character type.
     */
    public static String getCharType(char c) {
        // Convert to lowercase for easier checking
        if (c >= 'A' && c <= 'Z') {
            c = (char) (c + 32);
        }

        if (c >= 'a' && c <= 'z') {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    /**
     * Counts the total number of vowels and consonants in a string.
     * @param text The input string.
     * @return An int array where index 0 is vowel count and index 1 is consonant count.
     */
    public static int[] countVowelsAndConsonants(String text) {
        int vowelCount = 0;
        int consonantCount = 0;
        for (int i = 0; i < text.length(); i++) {
            String type = getCharType(text.charAt(i));
            if (type.equals("Vowel")) {
                vowelCount++;
            } else if (type.equals("Consonant")) {
                consonantCount++;
            }
        }
        return new int[]{vowelCount, consonantCount};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = input.nextLine();

        int[] counts = countVowelsAndConsonants(text);
        System.out.println("Total Vowels: " + counts[0]);
        System.out.println("Total Consonants: " + counts[1]);
        input.close();
    }
}

//--- Program 6: Display Vowel/Consonant for each character ---
class VowelConsonantIdentifier {

    // Reusing getCharType method from Program 5
    public static String getCharType(char c) {
        if (c >= 'A' && c <= 'Z') c = (char) (c + 32);
        if (c >= 'a' && c <= 'z') {
            return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? "Vowel" : "Consonant";
        }
        return "Not a Letter";
    }

    /**
     * Analyzes each character in a string and classifies it.
     * @param text The input string.
     * @return A 2D array where each row is [character, type].
     */
    public static String[][] analyzeCharacters(String text) {
        String[][] analysis = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            analysis[i][0] = String.valueOf(ch);
            analysis[i][1] = getCharType(ch);
        }
        return analysis;
    }

    /**
     * Displays the 2D array in a tabular format.
     * @param data The 2D array to display.
     */
    public static void displayAnalysis(String[][] data) {
        System.out.println("\n--- Character Analysis ---");
        System.out.println("Character | Type");
        System.out.println("----------|--------------");
        for (String[] row : data) {
            System.out.printf("%-9s | %s\n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = input.nextLine();

        String[][] analysis = analyzeCharacters(text);
        displayAnalysis(analysis);
        input.close();
    }
}


//--- Program 7: Trim String without trim() method ---
class CustomTrimmer {

    /**
     * Finds the start and end indexes of a string, excluding leading/trailing spaces.
     * @param text The input string.
     * @return An int array with [startIndex, endIndex].
     */
    public static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = text.length() - 1;

        // Find the first non-space character from the beginning
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }

        // Find the first non-space character from the end
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end + 1}; // end index for substring is exclusive
    }

    // A simple substring creator
    public static String createSubstring(String text, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for(int i = start; i < end; i++) {
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string with leading/trailing spaces: ");
        String text = input.nextLine();

        int[] indexes = findTrimIndexes(text);
        String customTrim = createSubstring(text, indexes[0], indexes[1]);
        System.out.println("Result from custom trim: '" + customTrim + "'");

        String builtinTrim = text.trim();
        System.out.println("Result from built-in trim: '" + builtinTrim + "'");

        System.out.println("Are both results identical? " + customTrim.equals(builtinTrim));
        input.close();
    }
}

//--- Program 8: Student Voting Eligibility with Random Ages ---
class StudentVotingRandom {

    /**
     * Generates an array of random 2-digit ages.
     * @param count The number of students.
     * @return An array of random ages.
     */
    public static int[] generateRandomAges(int count) {
        Random rand = new Random();
        int[] ages = new int[count];
        for (int i = 0; i < count; i++) {
            // Generates an age between 10 and 99
            ages[i] = 10 + rand.nextInt(90);
        }
        return ages;
    }

    /**
     * Checks voting eligibility for an array of ages.
     * @param ages The input array of ages.
     * @return A 2D String array with [age, eligibility status].
     */
    public static String[][] checkEligibility(int[] ages) {
        String[][] results = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            results[i][0] = String.valueOf(ages[i]);
            if (ages[i] >= 18) {
                results[i][1] = "Can Vote";
            } else {
                results[i][1] = "Cannot Vote";
            }
        }
        return results;
    }

    /**
     * Displays a 2D array in a table format.
     * @param data The 2D array.
     */
    public static void displayTable(String[][] data, String header1, String header2) {
        System.out.printf("\n--- %s / %s Report ---\n", header1, header2);
        System.out.printf("%-10s | %s\n", header1, header2);
        System.out.println("-----------|--------------");
        for(String[] row : data) {
            System.out.printf("%-10s | %s\n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        int[] ages = generateRandomAges(10); // For 10 students
        String[][] eligibilityReport = checkEligibility(ages);
        displayTable(eligibilityReport, "Age", "Eligibility");
    }
}

//--- Program 9: Rock-Paper-Scissors Game ---
class RockPaperScissors {

    /**
     * Generates a random choice for the computer.
     * @return A string "rock", "paper", or "scissors".
     */
    public static String getComputerChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        Random rand = new Random();
        return choices[rand.nextInt(3)];
    }

    /**
     * Determines the winner of a single round.
     * @param playerChoice The user's choice.
     * @param computerChoice The computer's choice.
     * @return A string "Player", "Computer", or "Tie".
     */
    public static String findWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "Tie";
        }
        switch (playerChoice) {
            case "rock":
                return (computerChoice.equals("scissors")) ? "Player" : "Computer";
            case "paper":
                return (computerChoice.equals("rock")) ? "Player" : "Computer";
            case "scissors":
                return (computerChoice.equals("paper")) ? "Player" : "Computer";
            default:
                return "Invalid";
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many games would you like to play? ");
        int numGames = input.nextInt();

        int playerWins = 0;
        int computerWins = 0;

        for (int i = 1; i <= numGames; i++) {
            System.out.print("\nGame " + i + ": Enter your choice (rock, paper, or scissors): ");
            String playerChoice = input.next().toLowerCase();

            if (!playerChoice.equals("rock") && !playerChoice.equals("paper") && !playerChoice.equals("scissors")) {
                System.out.println("Invalid choice. Skipping game.");
                continue;
            }

            String computerChoice = getComputerChoice();
            System.out.println("Computer chose: " + computerChoice);

            String winner = findWinner(playerChoice, computerChoice);
            System.out.println("Winner: " + winner);

            if (winner.equals("Player")) {
                playerWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            }
        }

        // Display stats
        System.out.println("\n--- Final Stats ---");
        System.out.println("Total Games: " + numGames);
        System.out.println("Player Wins: " + playerWins);
        System.out.println("Computer Wins: " + computerWins);
        System.out.println("Ties: " + (numGames - playerWins - computerWins));

        double playerWinPercentage = (double) playerWins / numGames * 100;
        double computerWinPercentage = (double) computerWins / numGames * 100;

        System.out.printf("Player Win Percentage: %.2f%%\n", playerWinPercentage);
        System.out.printf("Computer Win Percentage: %.2f%%\n", computerWinPercentage);
        input.close();
    }
}

//--- Program 10: Student Scorecard with Random Marks ---
class StudentScorecard {

    /**
     * Generates a 2D array of random 2-digit scores for students.
     * @param numStudents The number of students.
     * @return A 2D array where each row is [Physics, Chemistry, Math] scores.
     */
    public static int[][] generateRandomScores(int numStudents) {
        Random rand = new Random();
        int[][] scores = new int[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = rand.nextInt(91) + 10; // Score between 10-100
            scores[i][1] = rand.nextInt(91) + 10;
            scores[i][2] = rand.nextInt(91) + 10;
        }
        return scores;
    }

    /**
     * Calculates total, average, and percentage for each student.
     * @param scores The 2D array of scores.
     * @return A 2D double array with [total, average, percentage].
     */
    public static double[][] calculateMetrics(int[][] scores) {
        double[][] metrics = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100; // Assuming max marks 100 per subject

            metrics[i][0] = total;
            metrics[i][1] = Math.round(average * 100.0) / 100.0;
            metrics[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return metrics;
    }

    /**
     * Calculates grades based on percentage.
     * @param metrics The 2D array of metrics (needs percentage at index 2).
     * @return A char array of grades.
     */
    public static char[] calculateGrades(double[][] metrics) {
        char[] grades = new char[metrics.length];
        for (int i = 0; i < metrics.length; i++) {
            double percentage = metrics[i][2];
            if (percentage >= 80) grades[i] = 'A';
            else if (percentage >= 70) grades[i] = 'B';
            else if (percentage >= 60) grades[i] = 'C';
            else if (percentage >= 50) grades[i] = 'D';
            else if (percentage >= 40) grades[i] = 'E';
            else grades[i] = 'R';
        }
        return grades;
    }

    /**
     * Displays the complete student scorecard.
     */
    public static void displayScorecard(int[][] scores, double[][] metrics, char[] grades) {
        System.out.println("\n--- Student Scorecard ---");
        System.out.println("Std | Physics | Chemistry | Math | Total | Average | Percentage | Grade");
        System.out.println("----|---------|-----------|------|-------|---------|------------|-------");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-3d | %-7d | %-9d | %-4d | %-5.0f | %-7.2f | %-10.2f%% | %c\n",
                    (i + 1), scores[i][0], scores[i][1], scores[i][2],
                    metrics[i][0], metrics[i][1], metrics[i][2], grades[i]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = input.nextInt();

        int[][] scores = generateRandomScores(numStudents);
        double[][] metrics = calculateMetrics(scores);
        char[] grades = calculateGrades(metrics);

        displayScorecard(scores, metrics, grades);
        input.close();
    }
}
