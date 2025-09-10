import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

//********** JAVA METHODS LEVEL-2 PRACTICE PROGRAMS *************************

//--- 1. Factor Analysis ---
// File: FactorAnalysis.java
class FactorAnalysis {
    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    public static int sumFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    public static long productFactors(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    public static long sumOfSquareOfFactors(int[] factors) {
        long sumOfSquares = 0;
        for (int factor : factors) {
            sumOfSquares += Math.pow(factor, 2);
        }
        return sumOfSquares;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("--- Factor Analysis ---");
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int[] factors = findFactors(number);
        System.out.println("Factors: " + Arrays.toString(factors));
        System.out.println("Sum of factors: " + sumFactors(factors));
        System.out.println("Product of factors: " + productFactors(factors));
        System.out.println("Sum of squares of factors: " + sumOfSquareOfFactors(factors));
        input.close();
    }
}

//--- 2. Sum of Natural Numbers (Recursive) ---
// File: RecursiveSum.java
class RecursiveSum {
    public static int sumRecursive(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sumRecursive(n - 1);
    }

    public static int sumFormula(int n) {
        if (n <= 0) {
            return 0;
        }
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n--- Recursive Sum of Natural Numbers ---");
        System.out.print("Enter a natural number: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive natural number.");
        } else {
            int recursiveResult = sumRecursive(number);
            int formulaResult = sumFormula(number);

            System.out.println("Sum using recursion: " + recursiveResult);
            System.out.println("Sum using formula: " + formulaResult);

            if (recursiveResult == formulaResult) {
                System.out.println("Both computations are correct.");
            } else {
                System.out.println("There is a discrepancy in the computations.");
            }
        }
        input.close();
    }
}

//--- 3. Leap Year Checker ---
// File: LeapYearChecker.java
class LeapYearChecker {
    public static boolean isLeapYear(int year) {
        return (year >= 1582) && ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n--- Leap Year Checker ---");
        System.out.print("Enter a year (e.g., 2024): ");
        int year = input.nextInt();

        if (isLeapYear(year)) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is not a Leap Year.");
        }
        input.close();
    }
}

//--- 4, 5, & 6. Unit Converter Utility ---
// File: UnitConverter.java
class UnitConverter {
    // Problem 4 Conversions
    public static double convertKmToMiles(double km) { return km * 0.621371; }
    public static double convertMilesToKm(double miles) { return miles * 1.60934; }
    public static double convertMetersToFeet(double meters) { return meters * 3.28084; }
    public static double convertFeetToMeters(double feet) { return feet * 0.3048; }

    // Problem 5 Conversions
    public static double convertYardsToFeet(double yards) { return yards * 3; }
    public static double convertFeetToYards(double feet) { return feet / 3.0; }
    public static double convertMetersToInches(double meters) { return meters * 39.3701; }
    public static double convertInchesToMeters(double inches) { return inches * 0.0254; }
    public static double convertInchesToCm(double inches) { return inches * 2.54; }

    // Problem 6 Conversions
    public static double convertFahrenheitToCelsius(double fahrenheit) { return (fahrenheit - 32) * 5.0 / 9.0; }
    public static double convertCelsiusToFahrenheit(double celsius) { return (celsius * 9.0 / 5.0) + 32; }
    public static double convertPoundsToKilograms(double pounds) { return pounds * 0.453592; }
    public static double convertKilogramsToPounds(double kilograms) { return kilograms * 2.20462; }
    public static double convertGallonsToLiters(double gallons) { return gallons * 3.78541; }
    public static double convertLitersToGallons(double liters) { return liters * 0.264172; }

    // Main method to demonstrate the utility class
    public static void main(String[] args) {
        System.out.println("\n--- Unit Converter Demo ---");
        System.out.println("100 km is " + convertKmToMiles(100) + " miles.");
        System.out.println("5 feet is " + convertFeetToMeters(5) + " meters.");
        System.out.println("100°F is " + String.format("%.2f", convertFahrenheitToCelsius(100)) + "°C.");
        System.out.println("25°C is " + convertCelsiusToFahrenheit(25) + "°F.");
    }
}

//--- 7. Student Vote Checker ---
// File: StudentVoteChecker.java
class StudentVoteChecker {
    public boolean canStudentVote(int age) {
        if (age < 0) {
            return false;
        }
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentVoteChecker checker = new StudentVoteChecker();
        int[] studentAges = new int[10];

        System.out.println("\n--- Student Voting Eligibility ---");
        System.out.println("Enter the ages of 10 students:");
        for (int i = 0; i < studentAges.length; i++) {
            System.out.print("Student " + (i + 1) + " age: ");
            studentAges[i] = input.nextInt();
        }

        System.out.println("\n--- Results ---");
        for (int i = 0; i < studentAges.length; i++) {
            boolean canVote = checker.canStudentVote(studentAges[i]);
            System.out.println("Student " + (i + 1) + " (Age: " + studentAges[i] + ") can vote: " + canVote);
        }
        input.close();
    }
}

//--- 8. Youngest and Tallest Friend ---
// File: FriendComparer.java
class FriendComparer {
    public String findYoungest(String[] names, int[] ages) {
        int minAge = ages[0];
        int youngestIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < minAge) {
                minAge = ages[i];
                youngestIndex = i;
            }
        }
        return names[youngestIndex];
    }

    public String findTallest(String[] names, double[] heights) {
        double maxHeight = heights[0];
        int tallestIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                tallestIndex = i;
            }
        }
        return names[tallestIndex];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FriendComparer comparer = new FriendComparer();

        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        System.out.println("\n--- Friend Comparer ---");
        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter age for " + names[i] + ": ");
            ages[i] = input.nextInt();
            System.out.print("Enter height for " + names[i] + " (cm): ");
            heights[i] = input.nextDouble();
        }

        String youngest = comparer.findYoungest(names, ages);
        String tallest = comparer.findTallest(names, heights);

        System.out.println("The youngest friend is: " + youngest);
        System.out.println("The tallest friend is: " + tallest);
        input.close();
    }
}

//--- 9. Number Properties Checker ---
// File: NumberPropertyChecker.java
class NumberPropertyChecker {
    public boolean isPositive(int num) { return num > 0; }
    public boolean isEven(int num) { return num % 2 == 0; }
    public int compare(int num1, int num2) {
        if (num1 > num2) return 1;
        if (num1 < num2) return -1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        NumberPropertyChecker checker = new NumberPropertyChecker();
        int[] numbers = new int[5];

        System.out.println("\n--- Number Properties ---");
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextInt();
        }

        System.out.println("\n--- Analysis ---");
        for (int num : numbers) {
            if (checker.isPositive(num)) {
                if (checker.isEven(num)) {
                    System.out.println(num + " is positive and even.");
                } else {
                    System.out.println(num + " is positive and odd.");
                }
            } else if (num < 0) {
                System.out.println(num + " is negative.");
            } else {
                System.out.println(num + " is zero.");
            }
        }

        System.out.println("\n--- Comparison of First and Last ---");
        int comparisonResult = checker.compare(numbers[0], numbers[numbers.length - 1]);
        if (comparisonResult == 1) System.out.println("First element is greater than the last.");
        else if (comparisonResult == -1) System.out.println("First element is less than the last.");
        else System.out.println("First and last elements are equal.");
        input.close();
    }
}

//--- 10. BMI Calculator for a Team ---
// File: TeamBMICalculator.java
class TeamBMICalculator {
    public void calculateBMIs(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100.0;
            data[i][2] = weight / (heightM * heightM);
        }
    }

    public String[] getBMIStatuses(double[][] data) {
        String[] statuses = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi <= 18.4) statuses[i] = "Underweight";
            else if (bmi <= 24.9) statuses[i] = "Normal";
            else if (bmi <= 39.9) statuses[i] = "Overweight";
            else statuses[i] = "Obese";
        }
        return statuses;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TeamBMICalculator calculator = new TeamBMICalculator();
        double[][] data = new double[10][3];

        System.out.println("\n--- BMI Calculator for 10 People ---");
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            data[i][0] = input.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            data[i][1] = input.nextDouble();
        }

        calculator.calculateBMIs(data);
        String[] statuses = calculator.getBMIStatuses(data);

        System.out.println("\n--- BMI Report ---");
        System.out.println("Person | Weight(kg) | Height(cm) | BMI   | Status");
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-6d | %-10.1f | %-10.1f | %-5.2f | %s\n",
                    (i + 1), data[i][0], data[i][1], data[i][2], statuses[i]);
        }
        input.close();
    }
}

//--- 11. Quadratic Root Finder ---
// File: QuadraticRootFinder.java
class QuadraticRootFinder {
    public double[] findRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - (4 * a * c);

        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{root1, root2};
        } else if (delta == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        } else {
            return new double[0];
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        QuadraticRootFinder finder = new QuadraticRootFinder();

        System.out.println("\n--- Quadratic Root Finder (ax^2 + bx + c) ---");
        System.out.print("Enter a: ");
        double a = input.nextDouble();
        System.out.print("Enter b: ");
        double b = input.nextDouble();
        System.out.print("Enter c: ");
        double c = input.nextDouble();

        double[] roots = finder.findRoots(a, b, c);

        if (roots.length == 2) {
            System.out.println("Two real roots: " + roots[0] + " and " + roots[1]);
        } else if (roots.length == 1) {
            System.out.println("One real root: " + roots[0]);
        } else {
            System.out.println("No real roots.");
        }
        input.close();
    }
}

//--- 12. Random Number Analysis ---
// File: RandomNumberAnalyzer.java
class RandomNumberAnalyzer {
    public int[] generate4DigitRandomArray(int size) {
        Random rand = new Random();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = 1000 + rand.nextInt(9000);
        }
        return numbers;
    }

    public double[] findAverageMinMax(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return new double[]{0, 0, 0};
        }

        int min = numbers[0];
        int max = numbers[0];
        double sum = 0;

        for (int num : numbers) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        double average = sum / numbers.length;
        return new double[]{average, (double)min, (double)max};
    }

    public static void main(String[] args) {
        RandomNumberAnalyzer analyzer = new RandomNumberAnalyzer();

        System.out.println("\n--- Random Number Analysis ---");
        int[] randomNumbers = analyzer.generate4DigitRandomArray(5);
        System.out.println("Generated Numbers: " + Arrays.toString(randomNumbers));

        double[] results = analyzer.findAverageMinMax(randomNumbers);
        System.out.printf("Average: %.2f\n", results[0]);
        System.out.printf("Minimum: %.0f\n", results[1]);
        System.out.printf("Maximum: %.0f\n", results[2]);
    }
}