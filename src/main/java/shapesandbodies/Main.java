package main.java.shapesandbodies;

import main.java.shapesandbodies.bodies.*;
import main.java.shapesandbodies.shapes.*;
import main.java.shapesandbodies.ui.ConsoleUI;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n=== Демонстрация полиморфизма ===");
        System.out.println("(Один интерфейс Printable, один вызов print()");
        System.out.println(" работает по-разному для каждой фигуры/тела)\n");

        List<Printable> printables = new ArrayList<>();
        printables.add(new Triangle(3, 4, 5));
        printables.add(new Square(5));
        printables.add(new Trapezoid(6, 4, 3, 2, 2));
        printables.add(new Cube(3));
        printables.add(new Cylinder(2, 5));
        printables.add(new Cone(3, 4));

        for (Printable p : printables) {
            p.print();
            System.out.println();
        }

        System.out.println("=== Конец демонстрации ===\n");
        
        ConsoleUI ui = new ConsoleUI();
        String[] mainMenu = {"Фигуры (площадь и периметр)", "Тела (объём)"};

        while (true) {
            ui.printMenu("КАЛЬКУЛЯТОР ФИГУР И ТЕЛ", mainMenu);
            int choice = ui.getMenuChoice(mainMenu.length);

            if (choice == -1) break;

            System.out.println();

            if (choice == 1) {
                System.out.println("--- Фигуры ---");
                new ShapeCalculator(ui).run();
            } else {
                System.out.println("--- Тела ---");
                new BodyCalculator(ui).run();
            }
        }

        ui.close();
        System.out.println("\nПрограмма завершена.");
    }
}