import java.util.Scanner;

//********** LEVEL-3 PRACTICE PROGRAMS *************************

//--- Program 1: Leap Year (Multiple if-else) ---
class LeapYearCheckerMultipleIf {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a year (>= 1582): ");
        int year = input.nextInt();

        if (year >= 1582) {
            // A year is a leap year if it is divisible by 4
            if (year % 4 == 0) {
                // Unless it is a century year not divisible by 400
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        System.out.println(year + " is a Leap Year.");
                    } else {
                        System.out.println(year + " is not a Leap Year.");
                    }
                } else {
                    System.out.println(year + " is a Leap Year.");
                }
            } else {
                System.out.println(year + " is not a Leap Year.");
            }
        } else {
            System.out.println("Please enter a year in the Gregorian calendar (>= 1582).");
        }
        input.close();
    }
}

//--- Program 2: Leap Year (Single if with logical operators) ---
class LeapYearCheckerSingleIf {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a year (>= 1582): ");
        int year = input.nextInt();

        // Check if year is valid and then check leap year conditions in a single line
        if (year >= 1582 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
            System.out.println(year + " is a Leap Year.");
        } else {
            // This else covers invalid years and non-leap years
            System.out.println(year + " is not a Leap Year.");
        }
        input.close();
    }
}

//--- Program 3: Grade Calculator ---
class GradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter marks for Physics: ");
        int physics = input.nextInt();
        System.out.print("Enter marks for Chemistry: ");
        int chemistry = input.nextInt();
        System.out.print("Enter marks for Maths: ");
        int maths = input.nextInt();

        double averageMark = (physics + chemistry + maths) / 3.0;
        char grade;
        String remarks;

        if (averageMark >= 80) {
            grade = 'A';
            remarks = "(Level 4, above agency-normalized standards)";
        } else if (averageMark >= 70) {
            grade = 'B';
            remarks = "(Level 3, at agency-normalized standards)";
        } else if (averageMark >= 60) {
            grade = 'C';
            remarks = "(Level 2, below, but approaching agency-normalized standards)";
        } else if (averageMark >= 50) {
            grade = 'D';
            remarks = "(Level 1, well below agency-normalized standards)";
        } else if (averageMark >= 40) {
            grade = 'E';
            remarks = "(Level 1-, too below agency-normalized standards)";
        } else {
            grade = 'R';
            remarks = "(Remedial standards)";
        }

        System.out.println("\n--- Result ---");
        System.out.printf("Average Mark: %.2f%%\n", averageMark);
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);
        input.close();
    }
}

//--- Program 4: Prime Number Check ---
class PrimeNumberChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to check if it's prime: ");
        int number = input.nextInt();
        boolean isPrime = true;

        if (number <= 1) {
            isPrime = false;
        } else {
            // Loop from 2 to the square root of the number for efficiency
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
        input.close();
    }
}

//--- Program 5: Armstrong Number Check ---
class ArmstrongNumberChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to check if it's an Armstrong number: ");
        int number = input.nextInt();
        int originalNumber = number;
        int sum = 0;

        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, 3); // Sum of cubes of each digit
            number /= 10; // Remove the last digit
        }

        if (sum == originalNumber) {
            System.out.println(originalNumber + " is an Armstrong number.");
        } else {
            System.out.println(originalNumber + " is not an Armstrong number.");
        }
        input.close();
    }
}

//--- Program 6: Count Digits in an Integer ---
class DigitCounter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer to count its digits: ");
        int number = input.nextInt();
        int originalNumber = number;
        int count = 0;

        // Special case for 0
        if (number == 0) {
            count = 1;
        } else {
            // Loop until the number becomes 0
            while (number != 0) {
                number /= 10; // Remove the last digit
                count++;      // Increment the count
            }
        }
        System.out.println("The number of digits in " + originalNumber + " is: " + count);
        input.close();
    }
}

//--- Program 7: BMI Calculator ---
class BMICalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your weight in kg: ");
        double weight = input.nextDouble();
        System.out.print("Enter your height in cm: ");
        double heightCm = input.nextDouble();

        // Convert height from cm to meters
        double heightM = heightCm / 100.0;
        // Calculate BMI
        double bmi = weight / (heightM * heightM);

        String status;
        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi <= 24.9) {
            status = "Normal";
        } else if (bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        System.out.printf("\nYour BMI is: %.2f\n", bmi);
        System.out.println("Your weight status is: " + status);
        input.close();
    }
}

//--- Program 8: Harshad Number Check ---
class HarshadNumberChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to check if it's a Harshad Number: ");
        int number = input.nextInt();
        int originalNumber = number;
        int sumOfDigits = 0;

        // Calculate sum of digits
        while (number > 0) {
            sumOfDigits += number % 10;
            number /= 10;
        }

        // Check if the number is divisible by the sum of its digits
        if (originalNumber % sumOfDigits == 0) {
            System.out.println(originalNumber + " is a Harshad Number.");
        } else {
            System.out.println(originalNumber + " is not a Harshad Number.");
        }
        input.close();
    }
}

//--- Program 9: Abundant Number Check ---
class AbundantNumberChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to check if it's an Abundant Number: ");
        int number = input.nextInt();
        int sumOfDivisors = 0;

        // Find sum of all proper divisors
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sumOfDivisors += i;
            }
        }

        // Check if sum of divisors is greater than the number
        if (sumOfDivisors > number) {
            System.out.println(number + " is an Abundant Number.");
        } else {
            System.out.println(number + " is not an Abundant Number.");
        }
        input.close();
    }
}

//--- Program 10: Calculator using switch...case ---
class SwitchCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        double first = input.nextDouble();
        System.out.print("Enter the second number: ");
        double second = input.nextDouble();
        System.out.print("Enter an operator (+, -, *, /): ");
        String op = input.next();
        double result = 0;

        switch (op) {
            case "+":
                result = first + second;
                System.out.println(first + " + " + second + " = " + result);
                break;
            case "-":
                result = first - second;
                System.out.println(first + " - " + second + " = " + result);
                break;
            case "*":
                result = first * second;
                System.out.println(first + " * " + second + " = " + result);
                break;
            case "/":
                if (second != 0) {
                    result = first / second;
                    System.out.println(first + " / " + second + " = " + result);
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid Operator.");
        }
        input.close();
    }
}

//--- Program 11: Day of the Week ---
// Note: This program takes command-line arguments.
// To run: java DayOfWeek 8 19 2025 (for August 19, 2025)
class DayOfWeek {
    public static void main(String[] args) {
        // Get month, day, and year from command-line arguments
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);

        // Apply the formulas from the Gregorian calendar algorithm
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;

        System.out.println("The day of the week is: " + d0);
        System.out.println("(0=Sun, 1=Mon, 2=Tue, 3=Wed, 4=Thu, 5=Fri, 6=Sat)");
    }
}