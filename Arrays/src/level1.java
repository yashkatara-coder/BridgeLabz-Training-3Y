import java.util.Scanner;
import java.util.Arrays;

//********** JAVA ARRAYS LEVEL-1 PRACTICE PROGRAMS *************************

//--- Program 1: Voting Eligibility Checker ---
class VotingEligibility {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] studentAges = new int[10];

        // Take user input for ages
        System.out.println("Enter the age for 10 students:");
        for (int i = 0; i < studentAges.length; i++) {
            System.out.print("Student " + (i + 1) + " age: ");
            studentAges[i] = input.nextInt();
        }

        // Check voting eligibility for each student
        System.out.println("\n--- Voting Eligibility Report ---");
        for (int i = 0; i < studentAges.length; i++) {
            int age = studentAges[i];
            if (age < 0) {
                System.out.println("Student with age " + age + " has an invalid age.");
            } else if (age >= 18) {
                System.out.println("The student with the age " + age + " can vote.");
            } else {
                System.out.println("The student with the age " + age + " cannot vote.");
            }
        }
        input.close();
    }
}

//--- Program 2: Number Properties & Comparison ---
class NumberProperties {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];

        // Get 5 numbers from user
        System.out.println("Enter 5 integer numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        // Check properties of each number
        System.out.println("\n--- Number Properties ---");
        for (int num : numbers) {
            if (num > 0) {
                if (num % 2 == 0) {
                    System.out.println(num + " is a positive even number.");
                } else {
                    System.out.println(num + " is a positive odd number.");
                }
            } else if (num < 0) {
                System.out.println(num + " is a negative number.");
            } else {
                System.out.println(num + " is zero.");
            }
        }

        // Compare first and last elements
        System.out.println("\n--- First and Last Element Comparison ---");
        int first = numbers[0];
        int last = numbers[numbers.length - 1];
        if (first > last) {
            System.out.println("The first element (" + first + ") is greater than the last element (" + last + ").");
        } else if (first < last) {
            System.out.println("The first element (" + first + ") is less than the last element (" + last + ").");
        } else {
            System.out.println("The first element (" + first + ") is equal to the last element (" + last + ").");
        }
        input.close();
    }
}

//--- Program 3: Multiplication Table in Array ---
class MultiplicationTableArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to generate its multiplication table: ");
        int number = input.nextInt();

        int[] multiplicationTable = new int[10];

        // Store results in the array
        for (int i = 1; i <= 10; i++) {
            multiplicationTable[i - 1] = number * i;
        }

        // Display the result from the array
        System.out.println("\n--- Multiplication Table for " + number + " ---");
        for (int i = 0; i < multiplicationTable.length; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + multiplicationTable[i]);
        }
        input.close();
    }
}

//--- Program 4: Store up to 10 Numbers or until Zero/Negative ---
class DynamicInputSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        System.out.println("Enter up to 10 numbers (enter 0 or a negative number to stop):");

        // Infinite loop to take input
        while (true) {
            if (index == 10) {
                System.out.println("Maximum array capacity of 10 reached.");
                break;
            }
            System.out.print("Enter number " + (index + 1) + ": ");
            double userEntry = input.nextDouble();

            if (userEntry <= 0) {
                System.out.println("Stopping input.");
                break;
            }
            numbers[index] = userEntry;
            index++;
        }

        // Display numbers and calculate sum
        System.out.println("\n--- Numbers Entered ---");
        for (int i = 0; i < index; i++) { // Loop only up to the count of numbers entered
            System.out.println(numbers[i]);
            total += numbers[i];
        }

        System.out.println("\nThe sum of all entered numbers is: " + total);
        input.close();
    }
}

//--- Program 5: Multiplication Table 6-9 in Array ---
class MultiplicationTable6to9Array {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number for its multiplication table: ");
        int number = input.nextInt();

        // There are 4 results (for 6, 7, 8, 9)
        int[] multiplicationResult = new int[4];

        // Store results in the array
        int arrayIndex = 0;
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[arrayIndex] = number * i;
            arrayIndex++;
        }

        // Display results from the array
        System.out.println("\n--- Multiplication Table for " + number + " from 6 to 9 ---");
        arrayIndex = 0;
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[arrayIndex]);
            arrayIndex++;
        }
        input.close();
    }
}

//--- Program 6: Mean Height of Football Team ---
class MeanHeightCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] heights = new double[11];
        double sumOfHeights = 0.0;

        // Get heights of 11 players
        System.out.println("Enter the heights of 11 players (in cm):");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + " height: ");
            heights[i] = input.nextDouble();
            sumOfHeights += heights[i];
        }

        // Calculate and display mean height
        double meanHeight = sumOfHeights / heights.length;
        System.out.printf("\nThe mean height of the football team is: %.2f cm\n", meanHeight);
        input.close();
    }
}

//--- Program 7: Separate Odd/Even Numbers into Arrays ---
class OddEvenSeparator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Natural Number: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.err.println("Error: Not a Natural Number. Exiting.");
            System.exit(0);
        }

        // Calculate sizes for even and odd arrays
        int evenSize = number / 2;
        int oddSize = number - evenSize;

        int[] evenNumbers = new int[evenSize];
        int[] oddNumbers = new int[oddSize];
        int evenIndex = 0;
        int oddIndex = 0;

        // Iterate and save numbers into respective arrays
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex] = i;
                evenIndex++;
            } else {
                oddNumbers[oddIndex] = i;
                oddIndex++;
            }
        }

        // Print the arrays
        System.out.println("\nEven Numbers Array: " + Arrays.toString(evenNumbers));
        System.out.println("Odd Numbers Array: " + Arrays.toString(oddNumbers));
        input.close();
    }
}

//--- Program 8: Factors in a Dynamically Resizing Array ---
class DynamicFactorFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to find its factors: ");
        int number = input.nextInt();

        int maxFactors = 10;
        int[] factors = new int[maxFactors];
        int index = 0;

        // Find factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                // Check if array needs resizing
                if (index == maxFactors) {
                    maxFactors *= 2; // Double the size
                    int[] tempArray = new int[maxFactors];
                    System.arraycopy(factors, 0, tempArray, 0, factors.length);
                    factors = tempArray;
                }
                factors[index] = i;
                index++;
            }
        }

        // Create a final array with the exact size and display
        int[] finalFactors = new int[index];
        System.arraycopy(factors, 0, finalFactors, 0, index);
        System.out.println("\nThe factors of " + number + " are: " + Arrays.toString(finalFactors));
        input.close();
    }
}

//--- Program 9: Copy 2D Array to 1D Array ---
class Copy2Dto1D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = input.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = input.nextInt();

        int[][] matrix = new int[rows][cols];

        // Get elements for the 2D array
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        // Copy elements to a 1D array
        int[] singleDimArray = new int[rows * cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                singleDimArray[index] = matrix[i][j];
                index++;
            }
        }

        // Display the 1D array
        System.out.println("\nThe 1D array after copying is: " + Arrays.toString(singleDimArray));
        input.close();
    }
}

//--- Program 10: FizzBuzz in Array ---
class FizzBuzzArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer for FizzBuzz: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.err.println("Please enter a positive integer.");
            System.exit(0);
        }

        // Array size is number + 1 to include index 0 to number
        String[] results = new String[number + 1];

        // Loop and save FizzBuzz results to the array
        for (int i = 0; i <= number; i++) {
            if (i > 0 && i % 15 == 0) {
                results[i] = "FizzBuzz";
            } else if (i > 0 && i % 3 == 0) {
                results[i] = "Fizz";
            } else if (i > 0 && i % 5 == 0) {
                results[i] = "Buzz";
            } else {
                results[i] = Integer.toString(i);
            }
        }

        // Loop again to show the results
        System.out.println("\n--- FizzBuzz Results ---");
        for (int i = 1; i <= number; i++) { // Start from 1 for cleaner output
            System.out.println("Position " + i + " = " + results[i]);
        }
        input.close();
    }
}
