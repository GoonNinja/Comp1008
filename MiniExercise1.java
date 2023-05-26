//Adam Miszkiewicz 200547405
//COMP1008 MiniExercise1 Week 3

import java.util.Scanner;
import java.util.Random;

public class MiniExercise1 {

    // Code runs through here
    public static void main(String[] args) {
        Task1();
        Task2();
    }

    public static void Task1() {
        // Asking the user for some input then saving into a variable
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements would you like to create? ");
        int numberOfElements = scanner.nextInt();

        // Creating an object array
        Object[] objectArray = new Object[numberOfElements];

        // Asking user to enter value for each element, looping through however many
        // elements user wanted
        for (int i = 0; i < numberOfElements; i++) {

            System.out.println("Enter value for element: " + i);
            int num = scanner.nextInt();

            if (num == 0 || num == 1) {
                objectArray[i] = (num != 0);
            } else if (num >= Byte.MIN_VALUE && num <= Byte.MAX_VALUE) {
                objectArray[i] = (byte) num;
            } else if (num >= Short.MIN_VALUE && num <= Short.MAX_VALUE) {
                objectArray[i] = (short) num;
            } else {
                objectArray[i] = num;
            }
        }

        // This will print out the numbers user entered into elements
        for (int i = 0; i < numberOfElements; i++) {
            System.out.println("Element " + i + ": " + objectArray[i]);
        }
    }

    public static void Task2() {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Creating an array handling 2 separate values
        int[][] multiplicationTable = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                multiplicationTable[i][j] = (i + 1) * (j + 1);
            }
        }

        // Asking user for input and storing it in variable
        System.out.println("How many questions can you handle??? ");
        int numberOfQuestions = scanner.nextInt();
        int correctAnswers = 0;

        for (int k = 0; k < numberOfQuestions; k++) {

            // Picking random numbers and printing question to user
            int num1 = random.nextInt(10);
            int num2 = random.nextInt(10);
            System.out.printf("What is %d x %d. %n ", num1 + 1, num2 + 1);
            int answer = scanner.nextInt();

            if (answer == multiplicationTable[num1][num2]) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.printf("Wrong. Correct answer was %d.%n", multiplicationTable[num1][num2]);
            }
        }

        // Calculates the percentage of correct answers and displays to user at the end
        // of program
        double percentage = (double) correctAnswers / numberOfQuestions * 100;
        System.out.printf("You got %d of %d correct.%nTotal %.0f%%.%n",
                correctAnswers, numberOfQuestions, percentage);
    }

}
