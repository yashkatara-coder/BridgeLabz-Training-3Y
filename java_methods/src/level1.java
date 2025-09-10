import java.util.Scanner;
import java.util.Arrays;

//********** JAVA METHODS LEVEL-1 PRACTICE PROGRAMS *************************

//--- 1. Simple Interest Calculator ---
// File: SimpleInterestCalculator.java
class SimpleInterestCalculator {
    public double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100.0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SimpleInterestCalculator calculator = new SimpleInterestCalculator();

        System.out.println("--- Simple Interest Calculator ---");
        System.out.print("Enter Principal amount: ");
        double p = input.nextDouble();
        System.out.print("Enter Rate of Interest: ");
        double r = input.nextDouble();
        System.out.print("Enter Time in years: ");
        double t = input.nextDouble();

        double interest = calculator.calculateSimpleInterest(p, r, t);

        System.out.printf("The Simple Interest is %.2f for Principal %.2f, Rate of Interest %.2f, and Time %.2f years.\n", interest, p, r, t);
        input.close();
    }
}

//--- 2. Handshake Calculator ---
// File: HandshakeCalculator.java
class HandshakeCalculator {
    public int calculateHandshakes(int n) {
        if (n < 2) {
            return 0;
        }
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HandshakeCalculator calculator = new HandshakeCalculator();

        System.out.println("\n--- Handshake Calculator ---");
        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();

        int handshakes = calculator.calculateHandshakes(numberOfStudents);
        System.out.println("The maximum number of possible handshakes is: " + handshakes);
        input.close();
    }
}

//--- 3. Athlete's Park Run Calculator ---
// File: ParkRunCalculator.java
class ParkRunCalculator {
    public double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        double totalDistance = 5000; // 5 km in meters
        if (perimeter == 0) {
            return 0;
        }
        return totalDistance / perimeter;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ParkRunCalculator calculator = new ParkRunCalculator();

        System.out.println("\n--- Athlete's Run Calculator ---");
        System.out.print("Enter length of side 1 (meters): ");
        double s1 = input.nextDouble();
        System.out.print("Enter length of side 2 (meters): ");
        double s2 = input.nextDouble();
        System.out.print("Enter length of side 3 (meters): ");
        double s3 = input.nextDouble();

        double rounds = calculator.calculateRounds(s1, s2, s3);
        System.out.printf("The athlete must complete %.2f rounds to run 5 km.\n", rounds);
        input.close();
    }
}

//--- 4. Number Sign Checker ---
// File: NumberChecker.java
class NumberChecker {
    public int checkNumberSign(int number) {
        if (number > 0) return 1;
        if (number < 0) return -1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        NumberChecker checker = new NumberChecker();

        System.out.println("\n--- Number Sign Checker ---");
        System.out.print("Enter an integer: ");
        int num = input.nextInt();

        int result = checker.checkNumberSign(num);
        switch (result) {
            case 1: System.out.println("The number is positive."); break;
            case -1: System.out.println("The number is negative."); break;
            case 0: System.out.println("The number is zero."); break;
        }
        input.close();
    }
}

//--- 5. Spring Season Checker ---
// File: SpringSeasonChecker.java
class SpringSeasonChecker {
    public boolean isSpringSeason(int month, int day) {
        if (month == 3 && day >= 20) return true;
        if (month == 4 || month == 5) return true;
        if (month == 6 && day <= 20) return true;
        return false;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java SpringSeasonChecker <month> <day>");
            return;
        }
        SpringSeasonChecker checker = new SpringSeasonChecker();
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        if (checker.isSpringSeason(month, day)) {
            System.out.println("It's a Spring Season.");
        } else {
            System.out.println("Not a Spring Season.");
        }
    }
}

//--- 6. Sum of N Natural Numbers ---
// File: NaturalNumberSum.java
class NaturalNumberSum {
    public int sumUsingLoop(int n) {
        int sum = 0;
        if (n <= 0) return 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        NaturalNumberSum calculator = new NaturalNumberSum();

        System.out.println("\n--- Sum of N Natural Numbers ---");
        System.out.print("Enter a positive integer n: ");
        int num = input.nextInt();

        int sum = calculator.sumUsingLoop(num);
        System.out.println("The sum of the first " + num + " natural numbers is: " + sum);
        input.close();
    }
}

//--- 7. Smallest and Largest of Three Numbers ---
// File: MinMaxFinder.java
class MinMaxFinder {
    public int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int smallest = Math.min(number1, Math.min(number2, number3));
        int largest = Math.max(number1, Math.max(number2, number3));
        return new int[]{smallest, largest};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MinMaxFinder finder = new MinMaxFinder();

        System.out.println("\n--- Smallest and Largest Finder ---");
        System.out.print("Enter first number: ");
        int n1 = input.nextInt();
        System.out.print("Enter second number: ");
        int n2 = input.nextInt();
        System.out.print("Enter third number: ");
        int n3 = input.nextInt();

        int[] result = finder.findSmallestAndLargest(n1, n2, n3);
        System.out.println("The smallest number is: " + result[0]);
        System.out.println("The largest number is: " + result[1]);
        input.close();
    }
}

//--- 8. Quotient and Remainder ---
// File: DivisionCalculator.java
class DivisionCalculator {
    public int[] findRemainderAndQuotient(int number, int divisor) {
        if (divisor == 0) {
            System.out.println("Error: Cannot divide by zero.");
            return new int[]{0, 0};
        }
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DivisionCalculator calculator = new DivisionCalculator();

        System.out.println("\n--- Quotient and Remainder ---");
        System.out.print("Enter the number (dividend): ");
        int num = input.nextInt();
        System.out.print("Enter the divisor: ");
        int div = input.nextInt();

        int[] result = calculator.findRemainderAndQuotient(num, div);
        System.out.println("Quotient: " + result[0]);
        System.out.println("Remainder: " + result[1]);
        input.close();
    }
}

//--- 9. Chocolate Distribution ---
// File: ChocolateDistributor.java
class ChocolateDistributor {
    public int[] findRemainderAndQuotient(int numberOfChocolates, int numberOfChildren) {
        if (numberOfChildren <= 0) {
            System.out.println("Error: Number of children must be positive.");
            return new int[]{0, numberOfChocolates};
        }
        int eachGets = numberOfChocolates / numberOfChildren;
        int remaining = numberOfChocolates % numberOfChildren;
        return new int[]{eachGets, remaining};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ChocolateDistributor distributor = new ChocolateDistributor();

        System.out.println("\n--- Chocolate Distributor ---");
        System.out.print("Enter the number of chocolates: ");
        int chocolates = input.nextInt();
        System.out.print("Enter the number of children: ");
        int children = input.nextInt();

        int[] result = distributor.findRemainderAndQuotient(chocolates, children);
        System.out.println("Each child will get: " + result[0] + " chocolates.");
        System.out.println("Remaining chocolates: " + result[1]);
        input.close();
    }
}

//--- 10. Wind Chill Calculator ---
// File: WindChillCalculator.java
class WindChillCalculator {
    public double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + (0.6215 * temperature) + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        WindChillCalculator calculator = new WindChillCalculator();

        System.out.println("\n--- Wind Chill Calculator ---");
        System.out.print("Enter temperature in Fahrenheit: ");
        double temp = input.nextDouble();
        System.out.print("Enter wind speed in miles per hour: ");
        double speed = input.nextDouble();

        double windChill = calculator.calculateWindChill(temp, speed);
        System.out.printf("The wind chill temperature is: %.2f°F\n", windChill); // Semicolon added here
        input.close();
    }
}

//--- 11. Trigonometric Function Calculator ---
// File: TrigFunctionCalculator.java
class TrigFunctionCalculator {
    public double[] calculateTrigonometricFunctions(double angleInDegrees) {
        double angleInRadians = Math.toRadians(angleInDegrees);

        double sine = Math.sin(angleInRadians);
        double cosine = Math.cos(angleInRadians);
        double tangent = Math.tan(angleInRadians);

        return new double[]{sine, cosine, tangent};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TrigFunctionCalculator calculator = new TrigFunctionCalculator();

        System.out.println("\n--- Trigonometric Calculator ---");
        System.out.print("Enter an angle in degrees: ");
        double angle = input.nextDouble();

        double[] results = calculator.calculateTrigonometricFunctions(angle);
        System.out.printf("For an angle of %.2f degrees:\n", angle);
        System.out.printf("  Sine:   %.4f\n", results[0]);
        System.out.printf("  Cosine: %.4f\n", results[1]);
        System.out.printf("  Tangent:%.4f\n", results[2]);
        input.close();
    }
}