//************* Level-2 ****************
import java.util.*;


//1-
class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take user inputs
        System.out.print("Enter first number: ");
        double number1 = input.nextDouble();

        System.out.print("Enter second number: ");
        double number2 = input.nextDouble();

        // Perform operations
        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division = number1 / number2;

        // Display results
        System.out.println("The addition, subtraction, multiplication, and division value of 2 numbers "
                + number1 + " and " + number2 + " is "
                + addition + ", " + subtraction + ", " + multiplication + ", and " + division);

        input.close();
    }
}


//2-
class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take base and height in cm
        System.out.print("Enter base of the triangle (cm): ");
        double baseCm = input.nextDouble();

        System.out.print("Enter height of the triangle (cm): ");
        double heightCm = input.nextDouble();

        // Calculate area in square centimeters
        double areaCm2 = 0.5 * baseCm * heightCm;

        // Convert to square inches (1 inch = 2.54 cm)
        double areaInches2 = areaCm2 / (2.54 * 2.54);

        // Display results
        System.out.println("The Area of the triangle in sq in is " + areaInches2
                + " and sq cm is " + areaCm2);

        input.close();
    }
}


//3-
class SquareSideFromPerimeter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter perimeter of the square: ");
        double perimeter = input.nextDouble();

        double sideLength = perimeter / 4;
        System.out.println("The length of the side is " + sideLength + " whose perimeter is " + perimeter);

        input.close();
    }
}


//4-
class DistanceConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter distance in feet: ");
        double distanceFeet = input.nextDouble();
        double distanceYards = distanceFeet / 3;
        double distanceMiles = distanceYards / 1760;

        System.out.println("The distance in yards is " + distanceYards
                + " while the distance in miles is " + distanceMiles);

        input.close();
    }
}


//5-
class PurchasePrice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();

        System.out.print("Enter unit price (INR): ");
        double unitPrice = input.nextDouble();

        double totalPrice = quantity * unitPrice;

        System.out.println("Total purchase price is INR " + totalPrice + " if the quantity is "
                + quantity + " and unit price is INR " + unitPrice);

        input.close();
    }
}


//6-
class QuotientRemainder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int number1 = input.nextInt();

        System.out.print("Enter second number: ");
        int number2 = input.nextInt();

        int quotient = number1 / number2;
        int remainder = number1 % number2;

        System.out.println("The Quotient is " + quotient + " and Remainder is " + remainder
                + " of two numbers " + number1 + " and " + number2);

        input.close();
    }
}


//7-
class IntOperation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter value for a: ");
        int a = input.nextInt();

        System.out.print("Enter value for b: ");
        int b = input.nextInt();

        System.out.print("Enter value for c: ");
        int c = input.nextInt();

        int result1 = a + b * c;
        int result2 = a * b + c;
        int result3 = c + a / b;
        int result4 = a % b + c;

        System.out.println("The results of Int Operations are " + result1 + ", "
                + result2 + ", " + result3 + ", and " + result4);

        input.close();
    }
}


//8-
class DoubleOpt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter value for a: ");
        double a = input.nextDouble();

        System.out.print("Enter value for b: ");
        double b = input.nextDouble();

        System.out.print("Enter value for c: ");
        double c = input.nextDouble();

        double result1 = a + b * c;
        double result2 = a * b + c;
        double result3 = c + a / b;
        double result4 = a % b + c;

        System.out.println("The results of Double Operations are " + result1 + ", "
                + result2 + ", " + result3 + ", and " + result4);

        input.close();
    }
}