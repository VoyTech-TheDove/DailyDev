package com.goleb.wojciech.dailyDev;

/**
 * This is a simple program that takes numbers from input and displays a sum when "0" is inputed.
 *
 * @author Wojciech Golebiewski
 * @Date 24 03 2023
 */

import java.util.Scanner;

public class IntegerInputOutputSumApplication {

    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String EXIT_COMMAND = "0";

    public void start() {
        System.out.println("Hi! \nPlease enter some numbers when prompted.\nEntering 0 will display sum of those numbers.");

        long sum = 0;

        while (true) {
            String inputFromUser = getInputFromUser();
            if (inputFromUser.equals(EXIT_COMMAND)) {
                displaySum(sum);
                break;
            }
            try {
                long newNumber = Long.parseLong(inputFromUser);
                sum += sumTheDigitsOfLong(newNumber);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input");
                break;
            }
        }
    }

    private static long sumTheDigitsOfLong(long number) {
        long sum = 0;
        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }

    private static String getInputFromUser() {
        String line;
        System.out.println("Enter a number:");
        line = SCANNER.nextLine();
        return line;
    }

    private static void displaySum(long sum) {
        displaySumOfNumbers(sum);
    }

    private static void displaySumOfNumbers(long sum) {
        System.out.println("Sum of numbers " + sum);
    }
}
