package lab;


import java.util.*;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Choose operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            if (choice == 5) {
                System.out.println("Exiting the calculator. Goodbye!");
                break;
            }

            System.out.println("Enter two numbers:");
            double num1 = sc.nextDouble();
            double num2 = sc.nextDouble();

            performOperation(choice, num1, num2);

        } while (true);

       sc.close();
    }

    private static void performOperation(int choice, double num1, double num2) {
        switch (choice) {
            case 1:
                System.out.println("Result: " + add(num1, num2));
                break;
            case 2:
                System.out.println("Result: " + subtract(num1, num2));
                break;
            case 3:
                System.out.println("Result: " + multiply(num1, num2));
                break;
            case 4:
                System.out.println("Result: " + divide(num1, num2));
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static double add(double num1, double num2) {
        return num1 + num2;
    }

    private static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    private static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    private static double divide(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            System.out.println("Cannot divide by zero");
            return Double.NaN; 
        }
    }
}
