package main.java.shapesandbodies;

import main.java.shapesandbodies.shapes.*;
import main.java.shapesandbodies.ui.ConsoleUI;

public class ShapeCalculator {
    private final ConsoleUI ui;

    public ShapeCalculator(ConsoleUI ui) {
        this.ui = ui;
    }

    public void run() {
        String[] shapes = {"Треугольник", "Квадрат", "Трапеция"};

        while (true) {
            ui.printMenu("ВЫБЕРИТЕ ФИГУРУ", shapes);
            int choice = ui.getMenuChoice(shapes.length);

            if (choice == -1) {
                System.out.println("Возврат в главное меню...");
                return;
            }

            Shape shape = createShape(choice);

            if (shape != null) {
                System.out.println();
                shape.print();
                System.out.println();

                if (!ui.askToContinue()) {
                    System.out.println("Возврат в главное меню...");
                    return;
                }
            }
        }
    }

    private Shape createShape(int choice) {
        switch (choice) {
            case 1: return createTriangle();
            case 2: return createSquare();
            case 3: return createTrapezoid();
            default: return null;
        }
    }

    private Triangle createTriangle() {
        System.out.println("\nВведите стороны треугольника:");
        double a = ui.readDouble("  сторона a: ");
        if (a == -1) return null;
        double b = ui.readDouble("  сторона b: ");
        if (b == -1) return null;
        double c = ui.readDouble("  сторона c: ");
        if (c == -1) return null;

        if (a + b <= c || a + c <= b || b + c <= a) {
            System.out.println("  Ошибка: треугольник с такими сторонами не существует");
            return null;
        }

        return new Triangle(a, b, c);
    }

    private Square createSquare() {
        System.out.println("\nВведите сторону квадрата:");
        double side = ui.readDouble("  сторона: ");
        if (side == -1) return null;
        return new Square(side);
    }

    private Trapezoid createTrapezoid() {
        System.out.println("\nВведите параметры трапеции:");
        double baseA = ui.readDouble("  первое основание: ");
        if (baseA == -1) return null;
        double baseB = ui.readDouble("  второе основание: ");
        if (baseB == -1) return null;
        double height = ui.readDouble("  высота: ");
        if (height == -1) return null;
        double sideC = ui.readDouble("  боковая сторона c: ");
        if (sideC == -1) return null;
        double sideD = ui.readDouble("  боковая сторона d: ");
        if (sideD == -1) return null;

        return new Trapezoid(baseA, baseB, height, sideC, sideD);
    }
}