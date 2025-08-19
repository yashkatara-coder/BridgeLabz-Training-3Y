import java.util.Scanner;

//********** LEVEL-2 PRACTICE PROGRAMS *************************

//--- Program 1: Print odd and even numbers ---
class OddevenPrinter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Natural Number: ");
        int number = input.nextInt();

        if (number > 0) {
            System.out.println("Odd and Even numbers from 1 to " + number + ":");
            for (int i = 1; i <= number; i++) {
                if (i % 2 == 0) {
                    System.out.println(i + " is an even number.");
                } else {
                    System.out.println(i + " is an odd number.");
                }
            }
        } else {
            System.out.println("Please enter a valid Natural Number.");
        }
        input.close();
    }
}

//--- Program 2: Employee Bonus Calculator ---
class EmployeeBonus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter employee's salary: ");
        double salary = input.nextDouble();

        System.out.print("Enter employee's years of service: ");
        int yearsOfService = input.nextInt();

        if (yearsOfService > 5) {
            double bonusAmount = salary * 0.05;
            System.out.println("The bonus amount is: " + bonusAmount);
        } else {
            System.out.println("No bonus is applicable.");
        }
        input.close();
    }
}

//--- Program 3: Multiplication Table from 6 to 9 ---
class MultiplicationTable6to9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number for its multiplication table: ");
        int number = input.nextInt();

        System.out.println("Multiplication table for " + number + " from 6 to 9:");
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
        }
        input.close();
    }
}

//--- Program 4: FizzBuzz using for loop ---
class FizzBuzzForLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer for FizzBuzz: ");
        int number = input.nextInt();

        if (number > 0) {
            for (int i = 1; i <= number; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else if (i % 3 == 0) {
                    System.out.println("Fizz");
                } else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(i);
                }
            }
        } else {
            System.out.println("Please enter a positive integer.");
        }
        input.close();
    }
}

//--- Program 5: FizzBuzz using while loop ---
class FizzBuzzWhileLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer for FizzBuzz: ");
        int number = input.nextInt();

        if (number > 0) {
            int i = 1;
            while (i <= number) {
                if (i % 15 == 0) { // Check for both first
                    System.out.println("FizzBuzz");
                } else if (i % 3 == 0) {
                    System.out.println("Fizz");
                } else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(i);
                }
                i++;
            }
        } else {
            System.out.println("Please enter a positive integer.");
        }
        input.close();
    }
}

//--- Program 6: Youngest and Tallest Friend ---
class FriendComparer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input for Amar
        System.out.print("Enter Amar's age: ");
        int amarAge = input.nextInt();
        System.out.print("Enter Amar's height: ");
        double amarHeight = input.nextDouble();

        // Input for Akbar
        System.out.print("Enter Akbar's age: ");
        int akbarAge = input.nextInt();
        System.out.print("Enter Akbar's height: ");
        double akbarHeight = input.nextDouble();

        // Input for Anthony
        System.out.print("Enter Anthony's age: ");
        int anthonyAge = input.nextInt();
        System.out.print("Enter Anthony's height: ");
        double anthonyHeight = input.nextDouble();

        // Find the youngest
        if (amarAge < akbarAge && amarAge < anthonyAge) {
            System.out.println("Amar is the youngest.");
        } else if (akbarAge < amarAge && akbarAge < anthonyAge) {
            System.out.println("Akbar is the youngest.");
        } else {
            System.out.println("Anthony is the youngest.");
        }

        // Find the tallest
        if (amarHeight > akbarHeight && amarHeight > anthonyHeight) {
            System.out.println("Amar is the tallest.");
        } else if (akbarHeight > amarHeight && akbarHeight > anthonyHeight) {
            System.out.println("Akbar is the tallest.");
        } else {
            System.out.println("Anthony is the tallest.");
        }
        input.close();
    }
}

//--- Program 7: Factors of a number (for loop) ---
class FactorsForLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer to find its factors: ");
        int number = input.nextInt();

        if (number > 0) {
            System.out.print("Factors of " + number + " are: ");
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } else {
            System.out.println("Please enter a positive integer.");
        }
        input.close();
    }
}

//--- Program 8: Factors of a number (while loop) ---
class FactorsWhileLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer to find its factors: ");
        int number = input.nextInt();

        if (number > 0) {
            System.out.print("Factors of " + number + " are: ");
            int counter = 1;
            while (counter <= number) {
                if (number % counter == 0) {
                    System.out.print(counter + " ");
                }
                counter++;
            }
            System.out.println();
        } else {
            System.out.println("Please enter a positive integer.");
        }
        input.close();
    }
}

//--- Program 9: Greatest factor besides itself (for loop) ---
class GreatestFactorForLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        int greatestFactor = 1;

        for (int i = number - 1; i >= 1; i--) {
            if (number % i == 0) {
                greatestFactor = i;
                break;
            }
        }
        System.out.println("The greatest factor of " + number + " besides itself is " + greatestFactor);
        input.close();
    }
}

//--- Program 10: Greatest factor besides itself (while loop) ---
class GreatestFactorWhileLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        int greatestFactor = 1;
        int counter = number - 1;

        while (counter >= 1) {
            if (number % counter == 0) {
                greatestFactor = counter;
                break;
            }
            counter--;
        }
        System.out.println("The greatest factor of " + number + " besides itself is " + greatestFactor);
        input.close();
    }
}

//--- Program 11: Multiples of a number below 100 (for loop) ---
class MultiplesBelow100For {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive number (<100): ");
        int number = input.nextInt();

        if (number > 0 && number < 100) {
            System.out.print("Multiples of " + number + " below 100 are: ");
            for (int i = 1; (i * number) < 100; i++) {
                System.out.print((i * number) + " ");
            }
            System.out.println();
        } else {
            System.out.println("Please enter a positive number less than 100.");
        }
        input.close();
    }
}

//--- Program 12: Power of a number (for loop) ---
class PowerOfNumberFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the base number: ");
        int number = input.nextInt();
        System.out.print("Enter the power: ");
        int power = input.nextInt();
        long result = 1;

        if (number >= 0 && power >= 0) {
            for (int i = 1; i <= power; i++) {
                result *= number;
            }
            System.out.println(number + " to the power of " + power + " is " + result);
        } else {
            System.out.println("Please enter positive integers for base and power.");
        }
        input.close();
    }
}

//--- Program 13: Multiples of a number below 100 (while loop) ---
class MultiplesBelow100While {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive number (<100): ");
        int number = input.nextInt();

        if (number > 0 && number < 100) {
            System.out.print("Multiples of " + number + " below 100 are: ");
            int i = 1;
            while ((i * number) < 100) {
                System.out.print((i * number) + " ");
                i++;
            }
            System.out.println();
        } else {
            System.out.println("Please enter a positive number less than 100.");
        }
        input.close();
    }
}

//--- Program 14: Power of a number (while loop) ---
class PowerOfNumberWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the base number: ");
        int number = input.nextInt();
        System.out.print("Enter the power: ");
        int power = input.nextInt();
        long result = 1;
        int counter = 1;

        if (number >= 0 && power >= 0) {
            while (counter <= power) {
                result *= number;
                counter++;
            }
            System.out.println(number + " to the power of " + power + " is " + result);
        } else {
            System.out.println("Please enter positive integers for base and power.");
        }
        input.close();
    }
}