package main.java.shapesandbodies.ui;

import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
    }

    public void close() {
        scanner.close();
    }

    public void print(String message) {
        System.out.println(message);
    }

    public void printError(String message) {
        System.err.println("Ошибка: " + message);
    }

    public void printSeparator() {
        System.out.println("---");
    }

    public void printMenu(String title, String[] items) {
        System.out.println("\n=== " + title + " ===");
        for (int i = 0; i < items.length; i++) {
            System.out.println("  " + (i + 1) + " - " + items[i]);
        }
        System.out.print("Ваш выбор (1-" + items.length + ", или 'exit'): ");
    }

    public int getMenuChoice(int max) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (isExitCommand(input)) {
                return -1;
            }
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= max) {
                    return choice;
                }
                printError("Введите число от 1 до " + max);
            } catch (NumberFormatException e) {
                printError("Введите число или 'exit'");
            }
        }
    }

    public double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (isExitCommand(input)) {
                return -1;
            }
            try {
                double value = Double.parseDouble(input);
                if (value <= 0) {
                    printError("Значение должно быть больше 0");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                printError("Введите число (например: 5.5)");
            }
        }
    }

    public boolean askToContinue() {
        while (true) {
            System.out.print("Продолжить? (y/n): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("y") || answer.equals("yes")) {
                return true;
            }
            if (answer.equals("n") || answer.equals("no")) {
                return false;
            }
            printError("Введите y или n");
        }
    }

    private boolean isExitCommand(String input) {
        return input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit");
    }
}