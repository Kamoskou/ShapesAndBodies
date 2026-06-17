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
                ui.print("Возврат в главное меню...");
                return;  // выход из метода run(), возврат в main
            }

            Shape shape = createShape(choice);
            if (shape != null) {
                ui.printSeparator();
                String result = String.format("это фигура - %s с периметром %.2f и площадью %.2f",
                        shape.getType(), shape.getPerimeter(), shape.getArea());
                ui.print(result);
                ui.printSeparator();
            }

            // Спрашиваем только после успешного вычисления
            if (!ui.askToContinue()) {
                ui.print("Возврат в главное меню...");
                return;
            }
            ui.printSeparator();
        }
    }

    private Shape createShape(int choice) {
        switch (choice) {
            case 1:
                return createTriangle();
            case 2:
                return createSquare();
            case 3:
                return createTrapezoid();
            default:
                return null;
        }
    }

    private Triangle createTriangle() {
        ui.print("\n--- ТРЕУГОЛЬНИК ---");
        double a = ui.readDouble("Введите сторону a: ");
        if (a == -1) return null;
        double b = ui.readDouble("Введите сторону b: ");
        if (b == -1) return null;
        double c = ui.readDouble("Введите сторону c: ");
        if (c == -1) return null;

        if (a + b <= c || a + c <= b || b + c <= a) {
            ui.printError("Треугольник с такими сторонами не существует");
            return null;
        }

        return new Triangle(a, b, c);
    }

    private Square createSquare() {
        ui.print("\n--- КВАДРАТ ---");
        double side = ui.readDouble("Введите сторону квадрата: ");
        if (side == -1) return null;
        return new Square(side);
    }

    private Trapezoid createTrapezoid() {
        ui.print("\n--- ТРАПЕЦИЯ ---");
        double baseA = ui.readDouble("Введите первое основание: ");
        if (baseA == -1) return null;
        double baseB = ui.readDouble("Введите второе основание: ");
        if (baseB == -1) return null;
        double height = ui.readDouble("Введите высоту: ");
        if (height == -1) return null;
        double sideC = ui.readDouble("Введите боковую сторону c: ");
        if (sideC == -1) return null;
        double sideD = ui.readDouble("Введите боковую сторону d: ");
        if (sideD == -1) return null;

        return new Trapezoid(baseA, baseB, height, sideC, sideD);
    }
}