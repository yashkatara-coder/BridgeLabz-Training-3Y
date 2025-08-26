import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

//********** JAVA STRINGS LEVEL-3 PRACTICE PROGRAMS *************************

//--- Program 1: BMI Calculator for a Team ---
class TeamBMICalculator {

    /**
     * Gathers weight and height data for a team of 10.
     * @param input Scanner object for user input.
     * @return A 2D double array with [weight, height] for each person.
     */
    public static double[][] getTeamData(Scanner input) {
        double[][] data = new double[10][2];
        System.out.println("Enter data for 10 team members:");
        for (int i = 0; i < 10; i++) {
            System.out.println("--- Member " + (i + 1) + " ---");
            System.out.print("Enter weight (kg): ");
            data[i][0] = input.nextDouble();
            System.out.print("Enter height (cm): ");
            data[i][1] = input.nextDouble();
        }
        return data;
    }

    /**
     * Processes the raw data to calculate BMI and determine status.
     * @param teamData A 2D array of weights and heights.
     * @return A 2D String array with full report data [weight, height, BMI, status].
     */
    public static String[][] processBMIData(double[][] teamData) {
        String[][] report = new String[teamData.length][4];
        for (int i = 0; i < teamData.length; i++) {
            double weight = teamData[i][0];
            double heightCm = teamData[i][1];
            double heightM = heightCm / 100.0;
            double bmi = weight / (heightM * heightM);

            String status;
            if (bmi <= 18.4) status = "Underweight";
            else if (bmi <= 24.9) status = "Normal";
            else if (bmi <= 39.9) status = "Overweight";
            else status = "Obese";

            report[i][0] = String.format("%.1f", weight);
            report[i][1] = String.format("%.1f", heightCm);
            report[i][2] = String.format("%.2f", bmi);
            report[i][3] = status;
        }
        return report;
    }

    /**
     * Displays the final BMI report in a formatted table.
     * @param report The 2D String array containing the report data.
     */
    public static void displayReport(String[][] report) {
        System.out.println("\n--- Team BMI Report ---");
        System.out.println("---------------------------------------------------------");
        System.out.printf("| %-6s | %-10s | %-10s | %-7s | %-12s |\n", "Member", "Weight(kg)", "Height(cm)", "BMI", "Status");
        System.out.println("---------------------------------------------------------");
        for (int i = 0; i < report.length; i++) {
            System.out.printf("| %-6d | %-10s | %-10s | %-7s | %-12s |\n", (i + 1), report[i][0], report[i][1], report[i][2], report[i][3]);
        }
        System.out.println("---------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] teamData = getTeamData(input);
        String[][] bmiReport = processBMIData(teamData);
        displayReport(bmiReport);
        input.close();
    }
}

//--- Program 2: Find Unique Characters in a String ---
class UniqueCharacterFinder {

    /**
     * Finds all unique characters in a given string.
     * @param text The input string.
     * @return A character array containing only the unique characters.
     */
    public static char[] findUniqueCharacters(String text) {
        char[] tempUnique = new char[text.length()];
        int uniqueCount = 0;

        for (int i = 0; i < text.length(); i++) {
            boolean isUnique = true;
            for (int j = 0; j < uniqueCount; j++) {
                if (text.charAt(i) == tempUnique[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                tempUnique[uniqueCount] = text.charAt(i);
                uniqueCount++;
            }
        }

        // Create final array with the exact size
        return Arrays.copyOf(tempUnique, uniqueCount);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string to find unique characters: ");
        String text = input.nextLine();

        char[] uniqueChars = findUniqueCharacters(text);
        System.out.println("Unique characters: " + Arrays.toString(uniqueChars));
        input.close();
    }
}

//--- Program 3: Find First Non-Repeating Character ---
class FirstNonRepeatingFinder {

    /**
     * Finds the first character that does not repeat in a string.
     * @param text The input string.
     * @return The first non-repeating character, or '\0' if none exists.
     */
    public static char findFirstNonRepeating(String text) {
        int[] frequency = new int[256]; // For all ASCII characters

        // First pass: count frequencies
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        // Second pass: find the first character with a frequency of 1
        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        return '\0'; // Return null character if no unique character is found
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = input.nextLine();

        char firstUnique = findFirstNonRepeating(text);
        if (firstUnique != '\0') {
            System.out.println("The first non-repeating character is: '" + firstUnique + "'");
        } else {
            System.out.println("There are no non-repeating characters in the string.");
        }
        input.close();
    }
}

//--- Program 4: Find Frequency of All Characters ---
class AllCharacterFrequency {

    /**
     * Calculates the frequency of every character that appears in a string.
     * @param text The input string.
     * @return A 2D String array where each row is [character, frequency].
     */
    public static String[][] getCharacterFrequencies(String text) {
        int[] frequency = new int[256]; // For ASCII
        int uniqueCharCount = 0;

        // Populate frequency array
        for (char c : text.toCharArray()) {
            if (frequency[c] == 0) {
                uniqueCharCount++;
            }
            frequency[c]++;
        }

        String[][] result = new String[uniqueCharCount][2];
        int resultIndex = 0;

        // Populate result array with characters that appeared
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                result[resultIndex][0] = String.valueOf((char) i);
                result[resultIndex][1] = String.valueOf(frequency[i]);
                resultIndex++;
            }
        }
        return result;
    }

    public static void displayFrequencies(String[][] data) {
        System.out.println("\n--- Character Frequencies ---");
        System.out.printf("%-10s | %s\n", "Character", "Frequency");
        System.out.println("-----------|-----------");
        for (String[] row : data) {
            System.out.printf("    %-7s| %s\n", "'" + row[0] + "'", row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = input.nextLine();

        String[][] frequencies = getCharacterFrequencies(text);
        displayFrequencies(frequencies);
        input.close();
    }
}

//--- Program 5: Find Frequency of Unique Characters ---
class UniqueCharacterFrequency {

    // Reusing findUniqueCharacters from Program 2
    public static char[] findUniqueCharacters(String text) {
        char[] temp = new char[text.length()];
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            boolean isUnique = true;
            for (int j = 0; j < count; j++) {
                if (text.charAt(i) == temp[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) temp[count++] = text.charAt(i);
        }
        return Arrays.copyOf(temp, count);
    }

    /**
     * Calculates frequency of only the unique characters.
     * @param text The input string.
     * @return A 2D String array of [unique_character, frequency].
     */
    public static String[][] getUniqueCharFrequencies(String text) {
        char[] uniqueChars = findUniqueCharacters(text);
        String[][] result = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            int count = 0;
            for (int j = 0; j < text.length(); j++) {
                if (uniqueChars[i] == text.charAt(j)) {
                    count++;
                }
            }
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(count);
        }
        return result;
    }

    // Reusing display method from Program 4
    public static void displayFrequencies(String[][] data) {
        System.out.println("\n--- Unique Character Frequencies ---");
        System.out.printf("%-10s | %s\n", "Character", "Frequency");
        System.out.println("-----------|-----------");
        for (String[] row : data) {
            System.out.printf("    %-7s| %s\n", "'" + row[0] + "'", row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = input.nextLine();

        String[][] frequencies = getUniqueCharFrequencies(text);
        displayFrequencies(frequencies);
        input.close();
    }
}

//--- Program 6: Frequency using Nested Loops ---
class NestedLoopFrequency {

    public static void findFrequencies(String text) {
        char[] chars = text.toCharArray();
        int[] freq = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            freq[i] = 1; // Each char appears at least once
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    // Mark the duplicate char so it's not counted again
                    chars[j] = '0';
                }
            }
        }

        System.out.println("\n--- Character Frequencies (Nested Loop Method) ---");
        for (int i = 0; i < freq.length; i++) {
            if (chars[i] != ' ' && chars[i] != '0') {
                System.out.println("'" + chars[i] + "' : " + freq[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = input.nextLine();
        findFrequencies(text);
        input.close();
    }
}

//--- Program 7: Palindrome Check (3 Logics) ---
class PalindromeChecker {

    // Logic 1: Using a loop with two pointers
    public static boolean isPalindromeLoop(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Using recursion
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true; // Base case
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Logic 3: Using character arrays
    public static boolean isPalindromeArray(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        return Arrays.equals(original, reversed);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text to check for palindrome: ");
        String text = input.nextLine().toLowerCase(); // Ignore case for palindrome check

        System.out.println("\n--- Palindrome Check Results ---");
        System.out.println("Logic 1 (Loop): Is palindrome? " + isPalindromeLoop(text));
        System.out.println("Logic 2 (Recursion): Is palindrome? " + isPalindromeRecursive(text, 0, text.length() - 1));
        System.out.println("Logic 3 (Arrays): Is palindrome? " + isPalindromeArray(text));
        input.close();
    }
}


//--- Program 8: Anagram Check ---
class AnagramChecker {

    public static boolean areAnagrams(String s1, String s2) {
        // Remove spaces and convert to lowercase
        s1 = s1.replaceAll("\\s", "").toLowerCase();
        s2 = s2.replaceAll("\\s", "").toLowerCase();

        if (s1.length() != s2.length()) {
            return false;
        }

        int[] charFrequencies = new int[26]; // For a-z

        // Increment for s1, decrement for s2
        for (int i = 0; i < s1.length(); i++) {
            charFrequencies[s1.charAt(i) - 'a']++;
            charFrequencies[s2.charAt(i) - 'a']--;
        }

        // If they are anagrams, all frequencies should be 0
        for (int freq : charFrequencies) {
            if (freq != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String text1 = input.nextLine();
        System.out.print("Enter the second string: ");
        String text2 = input.nextLine();

        if (areAnagrams(text1, text2)) {
            System.out.println("The texts are anagrams.");
        } else {
            System.out.println("The texts are not anagrams.");
        }
        input.close();
    }
}

//--- Program 9: Display Calendar ---
class CalendarPrinter {

    public static void displayCalendar(int month, int year) {
        System.out.println("\n    " + getMonthName(month) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int startDay = getFirstDayOfMonth(month, year);
        int numDays = getNumberOfDaysInMonth(month, year);

        // Print leading spaces
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        // Print days of the month
        for (int i = 1; i <= numDays; i++) {
            System.out.printf("%3d ", i);
            if ((i + startDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static String getMonthName(int month) {
        String[] months = {"", "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return months[month];
    }

    public static int getNumberOfDaysInMonth(int month, int year) {
        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getFirstDayOfMonth(int m, int y) {
        // Using Gregorian calendar algorithm (d=1 for first day)
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        return (1 + x + (31 * m0) / 12) % 7;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = input.nextInt();
        System.out.print("Enter year: ");
        int year = input.nextInt();
        displayCalendar(month, year);
        input.close();
    }
}

//--- Program 10: Deck of Cards ---
class DeckOfCards {

    public static String[] initializeDeck(String[] suits, String[] ranks) {
        String[] deck = new String[suits.length * ranks.length];
        int i = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[i++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    public static void shuffleDeck(String[] deck) {
        Random rand = new Random();
        for (int i = deck.length - 1; i > 0; i--) {
            // Pick a random index from 0 to i
            int j = rand.nextInt(i + 1);
            // Swap deck[i] with the element at random index
            String temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    public static String[][] distributeCards(String[] deck, int numPlayers, int numCards) {
        if (numPlayers * numCards > deck.length) {
            return null; // Not enough cards
        }
        String[][] playerHands = new String[numPlayers][numCards];
        int cardIndex = 0;
        for (int i = 0; i < numCards; i++) {
            for (int j = 0; j < numPlayers; j++) {
                playerHands[j][i] = deck[cardIndex++];
            }
        }
        return playerHands;
    }

    public static void printPlayerHands(String[][] playerHands) {
        if (playerHands == null) {
            System.out.println("Could not distribute cards as requested.");
            return;
        }
        for (int i = 0; i < playerHands.length; i++) {
            System.out.println("\n--- Player " + (i + 1) + "'s Hand ---");
            System.out.println(Arrays.toString(playerHands[i]));
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        String[] deck = initializeDeck(suits, ranks);
        System.out.println("Initialized Deck (first 5 cards): " + Arrays.toString(Arrays.copyOf(deck, 5)));

        shuffleDeck(deck);
        System.out.println("Shuffled Deck (first 5 cards): " + Arrays.toString(Arrays.copyOf(deck, 5)));

        System.out.print("\nEnter number of players: ");
        int numPlayers = input.nextInt();
        System.out.print("Enter number of cards per player: ");
        int numCards = input.nextInt();

        String[][] playerHands = distributeCards(deck, numPlayers, numCards);
        printPlayerHands(playerHands);
        input.close();
    }
}
