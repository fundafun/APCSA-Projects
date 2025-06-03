/*
Date: 09/16/2024
Purpose: Simple calculator
 */

import java.util.Scanner;

public class simpleCalculator {

    public static void main(String[] args) {
        // scanner object
        Scanner scanner = new Scanner(System.in);

        // first number
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();  // Read the first number

        // second number
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();  // Read the second number

        // operations
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient = num1 / num2;

        // results
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);

        scanner.close();
    }
}
