import java.util.Scanner;
import java.util.Arrays;

//********** JAVA STRINGS LEVEL-1 PRACTICE PROGRAMS *************************

//--- Program 1: Compare two strings using charAt() ---
class StringComparator {

    /**
     * Compares two strings character by character.
     * @param s1 The first string.
     * @param s2 The second string.
     * @return true if the strings are equal, false otherwise.
     */
    public static boolean areEqualCustom(String s1, String s2) {
        // If lengths are different, they can't be equal.
        if (s1.length() != s2.length()) {
            return false;
        }
        // Compare each character.
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        // If all characters matched, the strings are equal.
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String str1 = input.next();
        System.out.print("Enter the second string: ");
        String str2 = input.next();

        // Compare using the custom method
        boolean customResult = areEqualCustom(str1, str2);
        System.out.println("Result from custom charAt() method: " + customResult);

        // Compare using the built-in equals() method
        boolean builtinResult = str1.equals(str2);
        System.out.println("Result from built-in equals() method: " + builtinResult);

        // Verify if both methods give the same result
        System.out.println("Do both methods produce the same result? " + (customResult == builtinResult));
        input.close();
    }
}

//--- Program 2: Create a substring using charAt() ---
class SubstringCreator {

    /**
     * Creates a substring from a given string using charAt().
     * @param text The original string.
     * @param start The starting index (inclusive).
     * @param end The ending index (exclusive).
     * @return The created substring.
     */
    public static String createSubstringCustom(String text, int start, int end) {
        StringBuilder sub = new StringBuilder();
        for (int i = start; i < end; i++) {
            sub.append(text.charAt(i));
        }
        return sub.toString();
    }

    // Re-using the comparison method from Program 1
    public static boolean areEqualCustom(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = input.next();
        System.out.print("Enter the start index: ");
        int startIndex = input.nextInt();
        System.out.print("Enter the end index: ");
        int endIndex = input.nextInt();

        // Create substring using custom method
        String customSubstring = createSubstringCustom(text, startIndex, endIndex);
        System.out.println("Substring from custom method: " + customSubstring);

        // Create substring using built-in method
        String builtinSubstring = text.substring(startIndex, endIndex);
        System.out.println("Substring from built-in method: " + builtinSubstring);

        // Compare the results
        boolean areSame = areEqualCustom(customSubstring, builtinSubstring);
        System.out.println("Are both substrings identical? " + areSame);
        input.close();
    }
}

//--- Program 3: Convert String to char array ---
class CharArrayConverter {

    /**
     * Converts a String to a character array manually.
     * @param text The string to convert.
     * @return A character array.
     */
    public static char[] toCharArrayCustom(String text) {
        char[] charArray = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            charArray[i] = text.charAt(i);
        }
        return charArray;
    }

    /**
     * Compares two character arrays.
     * @param arr1 The first array.
     * @param arr2 The second array.
     * @return true if they are equal, false otherwise.
     */
    public static boolean areCharArraysEqual(char[] arr1, char[] arr2) {
        return Arrays.equals(arr1, arr2); // Built-in array comparison is efficient
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = input.next();

        // Convert using custom method
        char[] customArray = toCharArrayCustom(text);
        System.out.println("Custom array: " + Arrays.toString(customArray));

        // Convert using built-in method
        char[] builtinArray = text.toCharArray();
        System.out.println("Built-in array: " + Arrays.toString(builtinArray));

        // Compare the two arrays
        boolean areSame = areCharArraysEqual(customArray, builtinArray);
        System.out.println("Are both character arrays identical? " + areSame);
        input.close();
    }
}

//--- Program 4: Demonstrate NullPointerException ---
class NullPointerExceptionDemo {

    // This method will generate the exception
    public static void generateException() {
        System.out.println("\nAttempting to generate NullPointerException...");
        String text = null;
        System.out.println("Length of null string is: " + text.length());
    }

    // This method will handle the exception
    public static void handleException() {
        System.out.println("\nAttempting to handle NullPointerException...");
        String text = null;
        try {
            System.out.println("Length of null string is: " + text.length());
        } catch (NullPointerException e) {
            System.err.println("Caught Exception: The string is null and has no length. " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Call the method that generates the exception
        try {
            generateException();
        } catch (NullPointerException e) {
            System.err.println("Caught in main: The program would have crashed, but we caught it. " + e.getMessage());
        }

        // Call the method that handles the exception itself
        handleException();
    }
}

//--- Program 5: Demonstrate StringIndexOutOfBoundsException ---
class StringIndexOutOfBoundsDemo {

    public static void generateException(String text) {
        System.out.println("\nAttempting to generate StringIndexOutOfBoundsException...");
        // Accessing an index that does not exist
        System.out.println("Character at invalid index: " + text.charAt(text.length()));
    }

    public static void handleException(String text) {
        System.out.println("\nAttempting to handle StringIndexOutOfBoundsException...");
        try {
            System.out.println("Character at invalid index: " + text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("Caught Exception: The index is out of the string's bounds. " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String sample = "Hello";
        try {
            generateException(sample);
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("Caught in main: The program would have crashed. " + e.getMessage());
        }
        handleException(sample);
    }
}


//--- Program 6: Demonstrate IllegalArgumentException ---
class IllegalArgumentDemo {

    public static void generateException(String text) {
        System.out.println("\nAttempting to generate IllegalArgumentException...");
        // Start index (5) is greater than end index (2)
        text.substring(5, 2);
    }

    public static void handleException(String text) {
        System.out.println("\nAttempting to handle IllegalArgumentException...");
        try {
            text.substring(5, 2);
        } catch (IllegalArgumentException e) {
            System.err.println("Caught Exception: Invalid arguments for substring method. " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String sample = "SomeText";
        try {
            generateException(sample);
        } catch (IllegalArgumentException e) {
            System.err.println("Caught in main: The program would have crashed. " + e.getMessage());
        }
        handleException(sample);
    }
}

//--- Program 7: Demonstrate NumberFormatException ---
class NumberFormatDemo {

    public static void generateException(String text) {
        System.out.println("\nAttempting to generate NumberFormatException...");
        int number = Integer.parseInt(text);
        System.out.println("Parsed number: " + number);
    }

    public static void handleException(String text) {
        System.out.println("\nAttempting to handle NumberFormatException...");
        try {
            int number = Integer.parseInt(text);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.err.println("Caught Exception: The string cannot be parsed into an integer. " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String badNumber = "abc";
        try {
            generateException(badNumber);
        } catch (NumberFormatException e) {
            System.err.println("Caught in main: The program would have crashed. " + e.getMessage());
        }
        handleException(badNumber);
    }
}

//--- Program 8: Demonstrate ArrayIndexOutOfBoundsException ---
class ArrayIndexOutOfBoundsDemo {

    public static void generateException(String[] names) {
        System.out.println("\nAttempting to generate ArrayIndexOutOfBoundsException...");
        // Accessing an index that doesn't exist
        System.out.println("Accessing element at invalid index: " + names[names.length]);
    }

    public static void handleException(String[] names) {
        System.out.println("\nAttempting to handle ArrayIndexOutOfBoundsException...");
        try {
            System.out.println("Accessing element at invalid index: " + names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Caught Exception: The array index is out of bounds. " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String[] names = {"Zara", "Eric", "Sam"};
        try {
            generateException(names);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Caught in main: The program would have crashed. " + e.getMessage());
        }
        handleException(names);
    }
}

//--- Program 9: Convert to Uppercase ---
class ToUpperCaseConverter {

    public static String toUpperCaseCustom(String text) {
        StringBuilder upper = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // Check if it's a lowercase letter
            if (ch >= 'a' && ch <= 'z') {
                // Convert to uppercase by subtracting 32 from its ASCII value
                upper.append((char) (ch - 32));
            } else {
                upper.append(ch);
            }
        }
        return upper.toString();
    }

    // Re-using the comparison method from Program 1
    public static boolean areEqualCustom(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a text to convert to uppercase: ");
        String text = input.nextLine();

        String customUpper = toUpperCaseCustom(text);
        System.out.println("Result from custom method: " + customUpper);

        String builtinUpper = text.toUpperCase();
        System.out.println("Result from built-in method: " + builtinUpper);

        boolean areSame = areEqualCustom(customUpper, builtinUpper);
        System.out.println("Are both results identical? " + areSame);
        input.close();
    }
}

//--- Program 10: Convert to Lowercase ---
class ToLowerCaseConverter {

    public static String toLowerCaseCustom(String text) {
        StringBuilder lower = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // Check if it's an uppercase letter
            if (ch >= 'A' && ch <= 'Z') {
                // Convert to lowercase by adding 32 to its ASCII value
                lower.append((char) (ch + 32));
            } else {
                lower.append(ch);
            }
        }
        return lower.toString();
    }

    // Re-using the comparison method from Program 1
    public static boolean areEqualCustom(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a text to convert to lowercase: ");
        String text = input.nextLine();

        String customLower = toLowerCaseCustom(text);
        System.out.println("Result from custom method: " + customLower);

        String builtinLower = text.toLowerCase();
        System.out.println("Result from built-in method: " + builtinLower);

        boolean areSame = areEqualCustom(customLower, builtinLower);
        System.out.println("Are both results identical? " + areSame);
        input.close();
    }
}
