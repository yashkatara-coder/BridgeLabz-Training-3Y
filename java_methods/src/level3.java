import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

//********** JAVA METHODS LEVEL-3 PRACTICE PROGRAMS *************************

//--- 1. Football Team Height Analysis ---
// File: src/level3/FootballTeamAnalysis.java


class FootballTeamAnalysis {
    public int[] generateRandomHeights(int size) {
        Random rand = new Random();
        int[] heights = new int[size];
        for (int i = 0; i < size; i++) {
            heights[i] = 150 + rand.nextInt(100);
        }
        return heights;
    }

    public double meanHeight(int[] heights) {
        if (heights.length == 0) return 0;
        int sum = 0;
        for (int height : heights) sum += height;
        return (double) sum / heights.length;
    }

    public int shortestHeight(int[] heights) {
        if (heights.length == 0) return 0;
        int shortest = heights[0];
        for (int height : heights) if (height < shortest) shortest = height;
        return shortest;
    }

    public int tallestHeight(int[] heights) {
        if (heights.length == 0) return 0;
        int tallest = heights[0];
        for (int height : heights) if (height > tallest) tallest = height;
        return tallest;
    }

    public static void main(String[] args) {
        FootballTeamAnalysis analyzer = new FootballTeamAnalysis();
        int[] heights = analyzer.generateRandomHeights(11);

        System.out.println("--- Football Team Height Analysis ---");
        System.out.println("Player Heights (cm): " + Arrays.toString(heights));
        System.out.println("Shortest Height: " + analyzer.shortestHeight(heights) + " cm");
        System.out.println("Tallest Height: " + analyzer.tallestHeight(heights) + " cm");
        System.out.printf("Mean Height: %.2f cm\n", analyzer.meanHeight(heights));
    }
}

//--- 2. Number Properties (Duck, Armstrong, Min/Max Digits) ---
// File: src/level3/NumberProperties.java


class NumberProperties {
    private static int[] getDigitsArray(long n) {
        String s = String.valueOf(Math.abs(n));
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = Character.getNumericValue(s.charAt(i));
        }
        return digits;
    }

    public static boolean isDuckNumber(long n) {
        return String.valueOf(n).contains("0") && String.valueOf(n).charAt(0) != '0';
    }

    public static boolean isArmstrongNumber(long n) {
        int[] digits = getDigitsArray(n);
        long sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, digits.length);
        }
        return sum == n;
    }

    public static int[] findLargestAndSecondLargest(long n) {
        int[] digits = getDigitsArray(n);
        int largest = -1, secondLargest = -1;
        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }
        return new int[]{largest, secondLargest};
    }

    public static int[] findSmallestAndSecondSmallest(long n) {
        int[] digits = getDigitsArray(n);
        int smallest = 10, secondSmallest = 10;
        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }
        return new int[]{smallest, secondSmallest};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n--- Number Properties Demo ---");
        System.out.print("Enter a number: ");
        long num = input.nextLong();
        System.out.println("Is Duck Number? " + isDuckNumber(num));
        System.out.println("Is Armstrong Number? " + isArmstrongNumber(num));
        System.out.println("Largest & 2nd Largest Digits: " + Arrays.toString(findLargestAndSecondLargest(num)));
        System.out.println("Smallest & 2nd Smallest Digits: " + Arrays.toString(findSmallestAndSecondSmallest(num)));
        input.close();
    }
}

//--- 3. Number Analysis (Harshad, Frequencies, Sums) ---
// File: src/level3/NumberAnalysis.java


class NumberAnalysis {
    private static int[] getDigitsArray(long n) {
        String s = String.valueOf(Math.abs(n));
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = Character.getNumericValue(s.charAt(i));
        }
        return digits;
    }

    public static int sumOfDigits(long n) {
        int sum = 0;
        for (int digit : getDigitsArray(n)) sum += digit;
        return sum;
    }

    public static long sumOfSquareOfDigits(long n) {
        long sum = 0;
        for (int digit : getDigitsArray(n)) sum += Math.pow(digit, 2);
        return sum;
    }

    public static boolean isHarshadNumber(long n) {
        return n != 0 && n % sumOfDigits(n) == 0;
    }

    public static int[][] getDigitFrequency(long n) {
        int[] freq = new int[10];
        int uniqueCount = 0;
        for (int digit : getDigitsArray(n)) {
            if (freq[digit] == 0) uniqueCount++;
            freq[digit]++;
        }
        int[][] result = new int[uniqueCount][2];
        int index = 0;
        for(int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                result[index++] = new int[]{i, freq[i]};
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n--- Number Analysis Demo ---");
        System.out.print("Enter a number: ");
        long num = input.nextLong();
        System.out.println("Sum of Digits: " + sumOfDigits(num));
        System.out.println("Sum of Square of Digits: " + sumOfSquareOfDigits(num));
        System.out.println("Is Harshad Number? " + isHarshadNumber(num));
        System.out.println("Digit Frequencies: " + Arrays.deepToString(getDigitFrequency(num)));
        input.close();
    }
}

//--- 4. Palindrome and Array Reversal ---
// File: src/level3/PalindromeAndArrayOps.java


class PalindromeAndArrayOps {
    private static int[] getDigitsArray(long n) {
        String s = String.valueOf(Math.abs(n));
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = Character.getNumericValue(s.charAt(i));
        }
        return digits;
    }

    public static int[] reverseDigitsArray(long n) {
        int[] digits = getDigitsArray(n);
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    public static boolean areArraysEqual(int[] arr1, int[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    public static boolean isPalindrome(long n) {
        return areArraysEqual(getDigitsArray(n), reverseDigitsArray(n));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n--- Palindrome and Array Ops Demo ---");
        System.out.print("Enter a number: ");
        long num = input.nextLong();
        System.out.println("Original Digits Array: " + Arrays.toString(getDigitsArray(num)));
        System.out.println("Reversed Digits Array: " + Arrays.toString(reverseDigitsArray(num)));
        System.out.println("Is Palindrome? " + isPalindrome(num));
        input.close();
    }
}

//--- 5. Special Number Types ---
// File: src/level3/SpecialNumberChecker.java


class SpecialNumberChecker {
    private static int sumOfDigits(long n) {
        int sum = 0;
        String s = String.valueOf(Math.abs(n));
        for(char c : s.toCharArray()) sum += Character.getNumericValue(c);
        return sum;
    }

    public static boolean isPrime(long n) {
        if (n <= 1) return false;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean isNeonNumber(long n) {
        return sumOfDigits(n * n) == n;
    }

    public static boolean isSpyNumber(long n) {
        String s = String.valueOf(Math.abs(n));
        long sum = 0, product = 1;
        for (char c : s.toCharArray()) {
            int digit = Character.getNumericValue(c);
            sum += digit;
            product *= digit;
        }
        return sum == product;
    }

    public static boolean isAutomorphicNumber(long n) {
        return String.valueOf(n * n).endsWith(String.valueOf(n));
    }

    public static boolean isBuzzNumber(long n) {
        return n % 7 == 0 || n % 10 == 7;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n--- Special Number Types Demo ---");
        System.out.print("Enter a number: ");
        long num = input.nextLong();
        System.out.println("Is Prime? " + isPrime(num));
        System.out.println("Is Neon Number? " + isNeonNumber(num));
        System.out.println("Is Spy Number? " + isSpyNumber(num));
        System.out.println("Is Automorphic? " + isAutomorphicNumber(num));
        System.out.println("Is Buzz Number? " + isBuzzNumber(num));
        input.close();
    }
}

//--- 6. Divisor-Based Number Types ---
// File: src/level3/DivisorBasedNumberChecker.java


class DivisorBasedNumberChecker {
    private static long sumOfProperDivisors(long n) {
        if (n <= 1) return 0;
        long sum = 1;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i * i != n) sum += n / i;
            }
        }
        return sum;
    }

    public static boolean isPerfectNumber(long n) { return n != 0 && sumOfProperDivisors(n) == n; }
    public static boolean isAbundantNumber(long n) { return sumOfProperDivisors(n) > n; }
    public static boolean isDeficientNumber(long n) { return sumOfProperDivisors(n) < n; }

    public static boolean isStrongNumber(long n) {
        if (n == 0) return false;
        long sumOfFactorials = 0;
        String s = String.valueOf(n);
        for (char c : s.toCharArray()) {
            int digit = Character.getNumericValue(c);
            long fact = 1;
            for (int i = 1; i <= digit; i++) fact *= i;
            sumOfFactorials += fact;
        }
        return sumOfFactorials == n;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n--- Divisor-Based Number Types Demo ---");
        System.out.print("Enter a number: ");
        long num = input.nextLong();
        System.out.println("Is Perfect Number? " + isPerfectNumber(num));
        System.out.println("Is Abundant Number? " + isAbundantNumber(num));
        System.out.println("Is Deficient Number? " + isDeficientNumber(num));
        System.out.println("Is Strong Number? " + isStrongNumber(num));
        input.close();
    }
}

//--- 7. Factor Analysis Extended ---
// File: src/level3/FactorAnalysisExtended.java


class FactorAnalysisExtended {
    public int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) if (number % i == 0) count++;
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) if (number % i == 0) factors[index++] = i;
        return factors;
    }

    public int greatestFactor(int[] factors) {
        if (factors.length < 2) return 0;
        return factors[factors.length - 2];
    }

    public double productOfCubeOfFactors(int[] factors) {
        double product = 1.0;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FactorAnalysisExtended analyzer = new FactorAnalysisExtended();
        System.out.println("\n--- Factor Analysis Extended ---");
        System.out.print("Enter a number: ");
        int num = input.nextInt();

        int[] factors = analyzer.findFactors(num);
        System.out.println("Factors: " + Arrays.toString(factors));
        System.out.println("Greatest Factor (besides itself): " + analyzer.greatestFactor(factors));
        System.out.println("Product of Cubes of Factors: " + analyzer.productOfCubeOfFactors(factors));
        input.close();
    }
}

//--- 8. OTP Generator and Validator ---
// File: src/level3/OtpGenerator.java


class OtpGenerator {
    public int generateSixDigitOtp() {
        return 100000 + new Random().nextInt(900000);
    }

    public boolean areOtpsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        OtpGenerator generator = new OtpGenerator();
        int[] otps = new int[10];

        System.out.println("\n--- Generating 10 OTPs ---");
        for (int i = 0; i < 10; i++) {
            otps[i] = generator.generateSixDigitOtp();
        }
        System.out.println("Generated OTPs: " + Arrays.toString(otps));
        System.out.println("Are all 10 generated OTPs unique? " + generator.areOtpsUnique(otps));
    }
}

//--- 9. Calendar Printer ---
// File: src/level3/CalendarPrinter.java


class CalendarPrinter {
    public void displayCalendar(int month, int year) {
        System.out.println("\n    " + getMonthName(month) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        int startDay = getFirstDayOfMonth(month, year);
        int numDays = getNumberOfDaysInMonth(month, year);
        for (int i = 0; i < startDay; i++) System.out.print("    ");
        for (int i = 1; i <= numDays; i++) {
            System.out.printf("%3d ", i);
            if ((i + startDay) % 7 == 0) System.out.println();
        }
        System.out.println();
    }

    public String getMonthName(int month) {
        return new String[]{"", "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"}[month];
    }

    public int getNumberOfDaysInMonth(int month, int year) {
        if (month == 2) return isLeapYear(year) ? 29 : 28;
        if (month == 4 || month == 6 || month == 9 || month == 11) return 30;
        return 31;
    }

    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public int getFirstDayOfMonth(int m, int y) {
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        return (1 + x + (31 * m0) / 12) % 7;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CalendarPrinter printer = new CalendarPrinter();
        System.out.println("\n--- Calendar Printer ---");
        System.out.print("Enter month (1-12): ");
        int month = input.nextInt();
        System.out.print("Enter year: ");
        int year = input.nextInt();
        printer.displayCalendar(month, year);
        input.close();
    }
}

//--- 10. Collinearity Checker ---
// File: src/level3/CollinearityChecker.java


class CollinearityChecker {
    public boolean checkBySlope(double x1, double y1, double x2, double y2, double x3, double y3) {
        if (x1 == x2 && x2 == x3) return true;
        if (x1 == x2 || x2 == x3) return false;
        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);
        return Math.abs(slopeAB - slopeBC) < 1e-9;
    }

    public boolean checkByArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        return 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) == 0;
    }

    public static void main(String[] args) {
        CollinearityChecker checker = new CollinearityChecker();
        System.out.println("\n--- Collinearity Checker ---");
        double x1=2, y1=4, x2=4, y2=6, x3=6, y3=8;
        System.out.println("Checking points A(2,4), B(4,6), C(6,8)...");
        System.out.println("Collinear by Slope Method? " + checker.checkBySlope(x1, y1, x2, y2, x3, y3));
        System.out.println("Collinear by Area Method? " + checker.checkByArea(x1, y1, x2, y2, x3, y3));
    }
}

//--- 11. Employee Bonus System ---
// File: src/level3/EmployeeBonusSystem.java


class EmployeeBonusSystem {
    public double[][] generateSalariesAndService(int numEmployees) {
        Random rand = new Random();
        double[][] data = new double[numEmployees][2];
        for(int i = 0; i < numEmployees; i++) {
            data[i][0] = 10000 + rand.nextInt(90000);
            data[i][1] = 1 + rand.nextInt(10);
        }
        return data;
    }

    public double[][] calculateBonuses(double[][] salaryAndService) {
        double[][] newData = new double[salaryAndService.length][2];
        for(int i = 0; i < salaryAndService.length; i++) {
            double salary = salaryAndService[i][0];
            double years = salaryAndService[i][1];
            double bonus = (years > 5) ? (salary * 0.05) : (salary * 0.02);
            newData[i][0] = salary + bonus;
            newData[i][1] = bonus;
        }
        return newData;
    }

    public void displayReport(double[][] salaryAndService, double[][] bonusData) {
        double totalOldSalary = 0, totalNewSalary = 0, totalBonus = 0;
        System.out.println("\n--- Employee Bonus Report ---");
        System.out.println("Emp | Old Salary | Years | Bonus    | New Salary");
        System.out.println("----|------------|-------|----------|-----------");
        for(int i=0; i < salaryAndService.length; i++) {
            double oldSal = salaryAndService[i][0];
            double years = salaryAndService[i][1];
            double bonus = bonusData[i][1];
            double newSal = bonusData[i][0];
            System.out.printf("%-3d | %-10.2f | %-5.0f | %-8.2f | %-10.2f\n", (i+1), oldSal, years, bonus, newSal);
            totalOldSalary += oldSal;
            totalNewSalary += newSal;
            totalBonus += bonus;
        }
        System.out.println("-------------------------------------------------");
        System.out.printf("Total Old Salary: %.2f\n", totalOldSalary);
        System.out.printf("Total Bonus Payout: %.2f\n", totalBonus);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);
    }

    public static void main(String[] args) {
        EmployeeBonusSystem system = new EmployeeBonusSystem();
        double[][] salaryData = system.generateSalariesAndService(10);
        double[][] bonusData = system.calculateBonuses(salaryData);
        system.displayReport(salaryData, bonusData);
    }
}

//--- 12. Euclidean Distance and Line Equation ---
// File: src/level3/GeometryCalculator.java


class GeometryCalculator {
    public double findEuclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public double[] findLineEquation(double x1, double y1, double x2, double y2) {
        if (x1 == x2) return null;
        double slope = (y2 - y1) / (x2 - x1);
        double yIntercept = y1 - slope * x1;
        return new double[]{slope, yIntercept};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GeometryCalculator calculator = new GeometryCalculator();
        System.out.println("\n--- Geometry Calculator ---");
        System.out.print("Enter x1: "); double x1 = input.nextDouble();
        System.out.print("Enter y1: "); double y1 = input.nextDouble();
        System.out.print("Enter x2: "); double x2 = input.nextDouble();
        System.out.print("Enter y2: "); double y2 = input.nextDouble();

        double distance = calculator.findEuclideanDistance(x1, y1, x2, y2);
        System.out.printf("Euclidean Distance: %.2f\n", distance);

        double[] equation = calculator.findLineEquation(x1, y1, x2, y2);
        if (equation != null) {
            System.out.printf("Line Equation: y = %.2fx + %.2f\n", equation[0], equation[1]);
        } else {
            System.out.println("Line is vertical: x = " + x1);
        }
        input.close();
    }
}

//--- 13. Student Scorecard ---
// File: src/level3/StudentScorecardGenerator.java


class StudentScorecardGenerator {
    public int[][] generateRandomScores(int numStudents) {
        Random rand = new Random();
        int[][] scores = new int[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = rand.nextInt(91) + 10;
            scores[i][1] = rand.nextInt(91) + 10;
            scores[i][2] = rand.nextInt(91) + 10;
        }
        return scores;
    }

    public double[][] calculateMetrics(int[][] scores) {
        double[][] metrics = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            metrics[i][0] = total;
            metrics[i][1] = Math.round((total / 3.0) * 100.0) / 100.0;
            metrics[i][2] = Math.round((total / 300.0) * 100.0 * 100.0) / 100.0;
        }
        return metrics;
    }

    public void displayScorecard(int[][] scores, double[][] metrics) {
        System.out.println("\n--- Student Scorecard ---");
        System.out.println("Std | Physics | Chemistry | Math | Total | Average | Percentage");
        System.out.println("----|---------|-----------|------|-------|---------|------------");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-3d | %-7d | %-9d | %-4d | %-5.0f | %-7.2f | %.2f%%\n",
                    (i + 1), scores[i][0], scores[i][1], scores[i][2],
                    metrics[i][0], metrics[i][1], metrics[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentScorecardGenerator generator = new StudentScorecardGenerator();
        System.out.println("\n--- Student Scorecard Generator ---");
        System.out.print("Enter number of students: ");
        int num = input.nextInt();

        int[][] scores = generator.generateRandomScores(num);
        double[][] metrics = generator.calculateMetrics(scores);
        generator.displayScorecard(scores, metrics);
        input.close();
    }
}

//--- 14. Matrix Operations ---
// File: src/level3/MatrixOperations.java


class MatrixOperations {
    public int[][] createRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10);
            }
        }
        return matrix;
    }

    public void displayMatrix(int[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix is null.");
            return;
        }
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public int[][] addMatrices(int[][] A, int[][] B) {
        if (A.length != B.length || A[0].length != B[0].length) return null;
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    public int[][] multiplyMatrices(int[][] A, int[][] B) {
        if (A[0].length != B.length) return null;
        int[][] result = new int[A.length][B[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MatrixOperations ops = new MatrixOperations();
        System.out.println("\n--- Matrix Operations ---");
        int[][] A = ops.createRandomMatrix(2, 3);
        int[][] B = ops.createRandomMatrix(3, 2);

        System.out.println("Matrix A (2x3):");
        ops.displayMatrix(A);
        System.out.println("\nMatrix B (3x2):");
        ops.displayMatrix(B);

        System.out.println("\nMatrix Multiplication (A * B):");
        int[][] C = ops.multiplyMatrices(A, B);
        ops.displayMatrix(C);
    }
}

//--- 15. Advanced Matrix Operations ---
// File: src/level3/AdvancedMatrixOps.java


class AdvancedMatrixOps {
    public void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) System.out.println(Arrays.toString(row));
    }

    public void displayDoubleMatrix(double[][] matrix) {
        if (matrix == null) return;
        for(double[] row : matrix) {
            System.out.print("[");
            for(int i = 0; i < row.length; i++) {
                System.out.printf("%.2f" + (i == row.length - 1 ? "" : ", "), row[i]);
            }
            System.out.println("]");
        }
    }

    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transpose = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    public int determinant2x2(int[][] matrix) {
        if (matrix.length != 2 || matrix[0].length != 2) return 0;
        return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
    }

    public double[][] inverse2x2(int[][] matrix) {
        int det = determinant2x2(matrix);
        if (det == 0) return null;

        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] / (double)det;
        inverse[0][1] = -matrix[0][1] / (double)det;
        inverse[1][0] = -matrix[1][0] / (double)det;
        inverse[1][1] = matrix[0][0] / (double)det;
        return inverse;
    }

    public static void main(String[] args) {
        AdvancedMatrixOps ops = new AdvancedMatrixOps();
        System.out.println("\n--- Advanced Matrix Operations ---");
        int[][] M = {{4, 7}, {2, 6}};

        System.out.println("Original Matrix M (2x2):");
        ops.displayMatrix(M);

        System.out.println("\nTranspose of M:");
        ops.displayMatrix(ops.transpose(M));

        System.out.println("\nDeterminant of M: " + ops.determinant2x2(M));

        System.out.println("\nInverse of M:");
        double[][] inv = ops.inverse2x2(M);
        if (inv != null) {
            ops.displayDoubleMatrix(inv);
        } else {
            System.out.println("Matrix is singular, inverse does not exist.");
        }
    }
}