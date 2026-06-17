package main.java.shapesandbodies;

import main.java.shapesandbodies.ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        ConsoleUI ui = new ConsoleUI();

        String[] mainMenu = {"Фигуры (площадь и периметр)", "Тела (объём)"};

        while (true) {
            ui.printMenu("КАЛЬКУЛЯТОР ФИГУР И ТЕЛ", mainMenu);
            int choice = ui.getMenuChoice(mainMenu.length);

            if (choice == -1) break;

            if (choice == 1) {
                new ShapeCalculator(ui).run();
            } else {
                new BodyCalculator(ui).run();
            }
        }

        ui.close();
        ui.print("Программа завершена.");
    }
}