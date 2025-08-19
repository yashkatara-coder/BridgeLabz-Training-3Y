import java.util.Scanner;

//********** LEVEL-1 PRACTICE PROGRAMS *************************

//--- Program 1: Check if a number is divisible by 5 ---
class DivisibleByFiveChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        if (number % 5 == 0) {
            System.out.println("Is the number " + number + " divisible by 5? true");
        } else {
            System.out.println("Is the number " + number + " divisible by 5? false");
        }
        input.close();
    }
}

//--- Program 2: Check if the first is the smallest of 3 numbers ---
class SmallestOfThreeChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int number1 = input.nextInt();
        System.out.print("Enter second number: ");
        int number2 = input.nextInt();
        System.out.print("Enter third number: ");
        int number3 = input.nextInt();
        if (number1 < number2 && number1 < number3) {
            System.out.println("Is the first number the smallest? true");
        } else {
            System.out.println("Is the first number the smallest? false");
        }
        input.close();
    }
}

//--- Program 3: Check which of the three numbers is the largest ---
class LargestOfThreeChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int number1 = input.nextInt();
        System.out.print("Enter second number: ");
        int number2 = input.nextInt();
        System.out.print("Enter third number: ");
        int number3 = input.nextInt();
        System.out.println("Is the first number the largest? " + (number1 > number2 && number1 > number3));
        System.out.println("Is the second number the largest? " + (number2 > number1 && number2 > number3));
        System.out.println("Is the third number the largest? " + (number3 > number1 && number3 > number2));
        input.close();
    }
}

//--- Program 4: Check for natural number and find the sum ---
class NaturalNumberSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        if (n > 0) {
            int sum = n * (n + 1) / 2;
            System.out.println("The sum of " + n + " natural numbers is " + sum);
        } else {
            System.out.println("The number " + n + " is not a natural number");
        }
        input.close();
    }
}

//--- Program 5: Check voting eligibility ---
class VotingEligibilityChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = input.nextInt();
        if (age >= 18) {
            System.out.println("The person's age is " + age + " and can vote.");
        } else {
            System.out.println("The person's age is " + age + " and cannot vote.");
        }
        input.close();
    }
}

//--- Program 6: Check if a number is positive, negative, or zero ---
class NumberSignChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        if (number > 0) {
            System.out.println("The number is positive.");
        } else if (number < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }
        input.close();
    }
}

//--- Program 7: Spring Season ---
// Note: This program takes command-line arguments, not Scanner input.
// To run: java SpringSeason 4 15
class SpringSeason {
    public static void main(String[] args) {
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);
        boolean isSpring = (month == 3 && day >= 20 && day <= 31) ||
                (month == 4 && day >= 1 && day <= 30) ||
                (month == 5 && day >= 1 && day <= 31) ||
                (month == 6 && day >= 1 && day <= 20);
        if (isSpring) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}

//--- Program 8: Countdown using while loop ---
class RocketCountdownWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter countdown start number: ");
        int counter = input.nextInt();
        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }
        System.out.println("Launch!");
        input.close();
    }
}

//--- Program 9: Countdown using for loop ---
class RocketCountdownFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter countdown start number: ");
        int startNumber = input.nextInt();
        for (int i = startNumber; i >= 1; i--) {
            System.out.println(i);
        }
        System.out.println("Launch!");
        input.close();
    }
}

//--- Program 10: Sum of numbers until user enters 0 ---
class SumUntilZero {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double total = 0.0;
        double number;
        System.out.print("Enter a number (enter 0 to stop): ");
        number = input.nextDouble();
        while (number != 0) {
            total += number;
            System.out.print("Enter another number (enter 0 to stop): ");
            number = input.nextDouble();
        }
        System.out.println("The total value is " + total);
        input.close();
    }
}

//--- Program 11: Sum until 0 or negative using while and break ---
class SumUntilNegativeOrZero {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double total = 0.0;
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double number = input.nextDouble();
            if (number <= 0) {
                break;
            }
            total += number;
        }
        System.out.println("The total value is " + total);
        input.close();
    }
}

//--- Program 12: Sum of n natural numbers (while loop vs. formula) ---
class SumNaturalNumbersWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = input.nextInt();
        if (n > 0) {
            int formulaSum = n * (n + 1) / 2;
            int loopSum = 0;
            int i = 1;
            while (i <= n) {
                loopSum += i;
                i++;
            }
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Sum using while loop: " + loopSum);
            System.out.println("Both computations were correct: " + (formulaSum == loopSum));
        } else {
            System.out.println("The number is not a natural number.");
        }
        input.close();
    }
}

//--- Program 13: Sum of n natural numbers (for loop vs. formula) ---
class SumNaturalNumbersFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = input.nextInt();
        if (n > 0) {
            int formulaSum = n * (n + 1) / 2;
            int loopSum = 0;
            for (int i = 1; i <= n; i++) {
                loopSum += i;
            }
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Sum using for loop: " + loopSum);
            System.out.println("Both computations were correct: " + (formulaSum == loopSum));
        } else {
            System.out.println("The number is not a natural number.");
        }
        input.close();
    }
}

//--- Program 14: Factorial using while loop ---
class FactorialWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();
        long factorial = 1;
        if (number >= 0) {
            int i = 1;
            while (i <= number) {
                factorial *= i;
                i++;
            }
            System.out.println("The factorial of " + number + " is " + factorial);
        } else {
            System.out.println("Please enter a positive integer.");
        }
        input.close();
    }
}

//--- Program 15: Factorial using for loop ---
class FactorialFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();
        long factorial = 1;
        if (number >= 0) {
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            System.out.println("The factorial of " + number + " is " + factorial);
        } else {
            System.out.println("Please enter a positive integer.");
        }
        input.close();
    }
}

//--- Program 16: Print odd and even numbers ---
class OddEvenPrinter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number = input.nextInt();
        if (number > 0) {
            for (int i = 1; i <= number; i++) {
                if (i % 2 == 0) {
                    System.out.println(i + " is an even number.");
                } else {
                    System.out.println(i + " is an odd number.");
                }
            }
        } else {
            System.out.println("Please enter a natural number.");
        }
        input.close();
    }
}

//--- Program 17: Employee bonus ---
class EmployeeBonusCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter salary: ");
        double salary = input.nextDouble();
        System.out.print("Enter years of service: ");
        int yearsOfService = input.nextInt();
        if (yearsOfService > 5) {
            double bonusAmount = salary * 0.05;
            System.out.println("The bonus amount is: " + bonusAmount);
        } else {
            System.out.println("No bonus is awarded.");
        }
        input.close();
    }
}

//--- Program 18: Multiplication table from 6 to 9 ---
class MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
        }
        input.close();
    }
}