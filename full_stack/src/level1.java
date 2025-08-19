//********** LEVEL-1 *************************
import java.util.*;
//1-
class FindHarryAge {
    public static void main(String[] args) {

        // Fixed values
        int birthYear = 2000;
        int currentYear = 2024;

        // Calculate age
        int age = currentYear - birthYear;

        // Display result
        System.out.println("Harry's age in " + currentYear + " is " + age);
    }
}


//2-
class AveragePCMMarks {
    public static void main(String[] args) {

        // Fixed marks
        int mathsMarks = 94;
        int physicsMarks = 95;
        int chemistryMarks = 96;

        // Calculate average
        double averageMarks = (mathsMarks + physicsMarks + chemistryMarks) / 3.0;

        // Display result
        System.out.println("Sam's average mark in PCM is " + averageMarks);
    }
}


//3-

class KmToMilesConverter {
    public static void main(String[] args) {

        // Fixed values
        double kilometers = 10.8;
        double kmToMilesFactor = 1.6;

        // Convert km to miles
        double miles = kilometers * kmToMilesFactor;

        // Display result
        System.out.println("The distance " + kilometers + " km in miles is " + miles);
    }
}


//4-

class ProfitCalculator {
    public static void main(String[] args) {
        double costPrice = 129;
        double sellingPrice = 191;

        double profit = sellingPrice - costPrice;
        double profitPercent = (profit / costPrice) * 100;

        System.out.println(
                "The Cost Price is INR " + costPrice + " and Selling Price is INR " + sellingPrice + "\n" +
                        "The Profit is INR " + profit + " and the Profit Percentage is " + profitPercent
        );
    }
}


//6-

class DiscountedFee {
    public static void main(String[] args) {

        double fee = 125000;
        double discountPercent = 10;

        double discountAmount = (discountPercent / 100) * fee;
        double finalFee = fee - discountAmount;

        System.out.println("The discount amount is INR " + discountAmount + " and final discounted fee is INR " + finalFee);
    }
}


//7-
class EarthVolumeCalculator {
    public static void main(String[] args) {

        // Fixed values
        double radiusKm = 6378;
        double kmToMiles = 1.6;

        // Volume formula: (4/3) * π * r³
        double volumeKm3 = (4.0 / 3.0) * Math.PI * Math.pow(radiusKm, 3);
        double radiusMiles = radiusKm / kmToMiles;
        double volumeMiles3 = (4.0 / 3.0) * Math.PI * Math.pow(radiusMiles, 3);

        // Display result
        System.out.println("The volume of earth in cubic kilometers is " + volumeKm3 +
                " and cubic miles is " + volumeMiles3);
    }
}


//8-
class KmToMilesUserInput {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter distance in kilometers: ");
        double kilometers = input.nextDouble();

        double kmToMilesFactor = 1.6;
        double miles = kilometers / kmToMilesFactor;

        System.out.println("The total miles is " + miles + " mile for the given " + kilometers + " km");

        input.close();
    }
}


//9-
class DiscountedFeeUserInput {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the fee amount (INR): ");
        double fee = input.nextDouble();

        System.out.print("Enter discount percentage: ");
        double discountPercent = input.nextDouble();

        double discountAmount = (discountPercent / 100) * fee;
        double finalFee = fee - discountAmount;
        System.out.println("The discount amount is INR " + discountAmount + " and final discounted fee is INR " + finalFee);

        input.close();
    }
}


//10-
class HeightConverter {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your height in centimeters: ");
        double heightCm = input.nextDouble();

        double inchesTotal = heightCm / 2.54;
        int feet = (int) (inchesTotal / 12);
        double inchesRemaining = inchesTotal % 12;

        System.out.println("Your Height in cm is " + heightCm + " while in feet is " + feet + " and inches is " + inchesRemaining);

        input.close();
    }
}


//11-
class BasicCalculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double number1 = input.nextDouble();

        System.out.print("Enter second number: ");
        double number2 = input.nextDouble();
        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division = number1 / number2;

        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers " +
                number1 + " and " + number2 + " is " +
                addition + ", " + subtraction + ", " + multiplication + ", and " + division);

        input.close();
    }
}

//12-

class TriangleAreaCalculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter base in cm: ");
        double base = input.nextDouble();

        System.out.print("Enter height in cm: ");
        double height = input.nextDouble();

        double areaCm2 = 0.5 * base * height;

        double areaIn2 = areaCm2 / (2.54 * 2.54);

        System.out.println("The Area of the triangle in sq in is " + areaIn2 + " and sq cm is " + areaCm2);

        input.close();
    }
}


//13-
class SquareSideCalculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the perimeter of the square: ");
        double perimeter = input.nextDouble();

        double side = perimeter / 4;
        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);

        input.close();
    }
}


//14-
class FeetConverter {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the distance in feet: ");
        double distanceFeet = input.nextDouble();
        double yards = distanceFeet / 3;
        double miles = yards / 1760;
        System.out.println("The distance in yards is " + yards + " while the distance in miles is " + miles);

        input.close();
    }
}


//15-
class TotalPriceCalculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter unit price (INR): ");
        double unitPrice = input.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();
        double totalPrice = unitPrice * quantity;
        System.out.println("The total purchase price is INR " + totalPrice +
                " if the quantity " + quantity + " and unit price is INR " + unitPrice);

        input.close();
    }
}


//16-
class MaxHandshakesCalculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();
        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;
        System.out.println("The maximum number of possible handshakes is " + handshakes);

        input.close();
    }
}