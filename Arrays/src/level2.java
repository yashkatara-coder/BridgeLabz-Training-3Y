import java.util.Scanner;
import java.util.Arrays;

//********** JAVA ARRAYS LEVEL-2 PRACTICE PROGRAMS *************************

//--- Program 1: Employee Bonus Calculator ---
class EmployeeBonusCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numEmployees = 10;

        double[] salaries = new double[numEmployees];
        double[] yearsOfService = new double[numEmployees];
        double[] bonuses = new double[numEmployees];
        double[] newSalaries = new double[numEmployees];

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        // Take input for salary and years of service
        System.out.println("Enter details for " + numEmployees + " employees:");
        for (int i = 0; i < numEmployees; ) {
            System.out.print("Enter salary for employee " + (i + 1) + ": ");
            double salary = input.nextDouble();
            System.out.print("Enter years of service for employee " + (i + 1) + ": ");
            double years = input.nextDouble();

            if (salary < 0 || years < 0) {
                System.err.println("Invalid input. Salary and years cannot be negative. Please enter again.");
                continue; // Ask for the same employee's details again
            }
            salaries[i] = salary;
            yearsOfService[i] = years;
            i++; // Move to the next employee only if input is valid
        }

        // Calculate bonus and new salary
        for (int i = 0; i < numEmployees; i++) {
            if (yearsOfService[i] > 5) {
                bonuses[i] = salaries[i] * 0.05; // 5% bonus
            } else {
                bonuses[i] = salaries[i] * 0.02; // 2% bonus
            }
            newSalaries[i] = salaries[i] + bonuses[i];

            totalOldSalary += salaries[i];
            totalBonus += bonuses[i];
            totalNewSalary += newSalaries[i];
        }

        // Print the total amounts
        System.out.println("\n--- Company Payout Summary ---");
        System.out.printf("Total Old Salary Payout: %.2f\n", totalOldSalary);
        System.out.printf("Total Bonus Payout: %.2f\n", totalBonus);
        System.out.printf("Total New Salary Payout: %.2f\n", totalNewSalary);
        input.close();
    }
}

//--- Program 2: Youngest and Tallest Friend ---
class FriendComparer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Take input for age and height
        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter age for " + names[i] + ": ");
            ages[i] = input.nextInt();
            System.out.print("Enter height for " + names[i] + " (in cm): ");
            heights[i] = input.nextDouble();
        }

        // Find the youngest and tallest
        int youngestIndex = 0;
        int tallestIndex = 0;
        for (int i = 1; i < names.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        System.out.println("\nThe youngest friend is: " + names[youngestIndex]);
        System.out.println("The tallest friend is: " + names[tallestIndex]);
        input.close();
    }
}

//--- Program 3: Largest and Second Largest Digit (Fixed Array) ---
class LargestDigitsFixed {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        int tempNumber = Math.abs(number);

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        // Store digits in the array up to a max of 10
        while (tempNumber > 0) {
            if (index == maxDigit) {
                System.err.println("Warning: Number has more than 10 digits. Only first 10 will be considered.");
                break;
            }
            digits[index] = tempNumber % 10;
            tempNumber /= 10;
            index++;
        }

        // Find the largest and second largest digits
        int largest = -1;
        int secondLargest = -1;
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
        input.close();
    }
}

//--- Program 4: Largest and Second Largest Digit (Dynamic Array) ---
class LargestDigitsDynamic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long number = input.nextLong();
        long tempNumber = Math.abs(number);

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        // Store all digits in a dynamically resizing array
        while (tempNumber > 0) {
            if (index == maxDigit) {
                maxDigit += 10; // Increase size
                int[] tempArray = new int[maxDigit];
                System.arraycopy(digits, 0, tempArray, 0, digits.length);
                digits = tempArray;
            }
            digits[index] = (int) (tempNumber % 10);
            tempNumber /= 10;
            index++;
        }

        // Find the largest and second largest digits
        int largest = -1;
        int secondLargest = -1;
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
        input.close();
    }
}

//--- Program 5: Reverse Number using Array ---
class ReverseNumberWithArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to reverse: ");
        int number = input.nextInt();
        int tempNumber = Math.abs(number);
        String numStr = Integer.toString(tempNumber);

        int[] digits = new int[numStr.length()];

        // Find the digits and save them in an array
        for (int i = 0; i < digits.length; i++) {
            digits[i] = tempNumber % 10;
            tempNumber /= 10;
        }

        // Display the array which now holds the number in reverse
        System.out.print("The reversed number is: ");
        if (number < 0) {
            System.out.print("-");
        }
        for (int digit : digits) {
            System.out.print(digit);
        }
        System.out.println();
        input.close();
    }
}

//--- Program 6: BMI for Multiple Persons ---
class MultiPersonBMICalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of persons: ");
        int numPersons = input.nextInt();

        double[] weights = new double[numPersons];
        double[] heights = new double[numPersons];
        double[] bmis = new double[numPersons];
        String[] statuses = new String[numPersons];

        // Take input for weight and height
        for (int i = 0; i < numPersons; i++) {
            System.out.println("--- Person " + (i + 1) + " ---");
            System.out.print("Enter weight (kg): ");
            weights[i] = input.nextDouble();
            System.out.print("Enter height (cm): ");
            heights[i] = input.nextDouble();
        }

        // Calculate BMI and status
        for (int i = 0; i < numPersons; i++) {
            double heightM = heights[i] / 100.0;
            bmis[i] = weights[i] / (heightM * heightM);
            if (bmis[i] <= 18.4) statuses[i] = "Underweight";
            else if (bmis[i] <= 24.9) statuses[i] = "Normal";
            else if (bmis[i] <= 39.9) statuses[i] = "Overweight";
            else statuses[i] = "Obese";
        }

        // Display the report
        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("Person %d: Weight=%.1f kg, Height=%.1f cm, BMI=%.2f, Status=%s\n",
                    (i + 1), weights[i], heights[i], bmis[i], statuses[i]);
        }
        input.close();
    }
}

//--- Program 7: BMI with 2D Array ---
class MultiPersonBMI2DArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of persons: ");
        int numPersons = input.nextInt();

        // [row][0]=weight, [row][1]=height, [row][2]=BMI
        double[][] personData = new double[numPersons][3];
        String[] weightStatus = new String[numPersons];

        // Take input and calculate
        for (int i = 0; i < numPersons; ) {
            System.out.println("--- Person " + (i + 1) + " ---");
            System.out.print("Enter weight (kg): ");
            double weight = input.nextDouble();
            System.out.print("Enter height (cm): ");
            double height = input.nextDouble();

            if (weight <= 0 || height <= 0) {
                System.err.println("Weight and height must be positive. Please enter again.");
                continue;
            }

            personData[i][0] = weight;
            personData[i][1] = height;

            double heightM = height / 100.0;
            double bmi = weight / (heightM * heightM);
            personData[i][2] = bmi;

            if (bmi <= 18.4) weightStatus[i] = "Underweight";
            else if (bmi <= 24.9) weightStatus[i] = "Normal";
            else if (bmi <= 39.9) weightStatus[i] = "Overweight";
            else weightStatus[i] = "Obese";
            i++;
        }

        // Display the report
        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("Person %d: Weight=%.1f kg, Height=%.1f cm, BMI=%.2f, Status=%s\n",
                    (i + 1), personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
        input.close();
    }
}

//--- Program 8: Student Grades ---
class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = input.nextInt();

        int[] physics = new int[numStudents];
        int[] chemistry = new int[numStudents];
        int[] maths = new int[numStudents];
        double[] percentages = new double[numStudents];
        char[] grades = new char[numStudents];

        // Input marks
        for (int i = 0; i < numStudents; ) {
            System.out.println("--- Student " + (i + 1) + " ---");
            System.out.print("Physics marks: ");
            int p = input.nextInt();
            System.out.print("Chemistry marks: ");
            int c = input.nextInt();
            System.out.print("Maths marks: ");
            int m = input.nextInt();

            if (p < 0 || c < 0 || m < 0) {
                System.err.println("Marks cannot be negative. Please enter again.");
                continue;
            }
            physics[i] = p;
            chemistry[i] = c;
            maths[i] = m;
            i++;
        }

        // Calculate percentage and grade
        for (int i = 0; i < numStudents; i++) {
            percentages[i] = (physics[i] + chemistry[i] + maths[i]) / 3.0;
            if (percentages[i] >= 80) grades[i] = 'A';
            else if (percentages[i] >= 70) grades[i] = 'B';
            else if (percentages[i] >= 60) grades[i] = 'C';
            else if (percentages[i] >= 50) grades[i] = 'D';
            else if (percentages[i] >= 40) grades[i] = 'E';
            else grades[i] = 'R';
        }

        // Display report
        System.out.println("\n--- Student Grade Report ---");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("Student %d: Marks(P,C,M)=(%d,%d,%d), Percentage=%.2f%%, Grade=%c\n",
                    (i + 1), physics[i], chemistry[i], maths[i], percentages[i], grades[i]);
        }
        input.close();
    }
}

//--- Program 9: Student Grades with 2D Array ---
class StudentGrade2DArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = input.nextInt();

        // [row][0]=Physics, [row][1]=Chemistry, [row][2]=Maths
        int[][] marks = new int[numStudents][3];
        double[] percentages = new double[numStudents];
        char[] grades = new char[numStudents];

        // Input marks
        for (int i = 0; i < numStudents; i++) {
            System.out.println("--- Student " + (i + 1) + " ---");
            System.out.print("Physics marks: ");
            marks[i][0] = input.nextInt();
            System.out.print("Chemistry marks: ");
            marks[i][1] = input.nextInt();
            System.out.print("Maths marks: ");
            marks[i][2] = input.nextInt();
        }

        // Calculate percentage and grade
        for (int i = 0; i < numStudents; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = total / 3.0;
            if (percentages[i] >= 80) grades[i] = 'A';
            else if (percentages[i] >= 70) grades[i] = 'B';
            else if (percentages[i] >= 60) grades[i] = 'C';
            else if (percentages[i] >= 50) grades[i] = 'D';
            else if (percentages[i] >= 40) grades[i] = 'E';
            else grades[i] = 'R';
        }

        // Display report
        System.out.println("\n--- Student Grade Report ---");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("Student %d: Percentage=%.2f%%, Grade=%c\n",
                    (i + 1), percentages[i], grades[i]);
        }
        input.close();
    }
}

//--- Program 10: Digit Frequency ---
class DigitFrequency {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to find the frequency of its digits: ");
        long number = input.nextLong();
        long tempNumber = Math.abs(number);

        // Array to store frequency of digits 0-9
        int[] frequency = new int[10];

        // Count frequency of each digit
        while (tempNumber > 0) {
            int digit = (int) (tempNumber % 10);
            frequency[digit]++;
            tempNumber /= 10;
        }

        // Display the frequency
        System.out.println("\n--- Digit Frequency ---");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                System.out.println("Frequency of digit " + i + ": " + frequency[i]);
            }
        }
        input.close();
    }
}
