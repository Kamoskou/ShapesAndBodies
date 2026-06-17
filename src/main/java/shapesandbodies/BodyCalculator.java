package main.java.shapesandbodies;

import main.java.shapesandbodies.bodies.*;
import main.java.shapesandbodies.ui.ConsoleUI;

public class BodyCalculator {
    private final ConsoleUI ui;

    public BodyCalculator(ConsoleUI ui) {
        this.ui = ui;
    }

    public void run() {
        String[] bodies = {"Куб", "Цилиндр", "Конус"};

        while (true) {
            ui.printMenu("ВЫБЕРИТЕ ТЕЛО", bodies);
            int choice = ui.getMenuChoice(bodies.length);

            if (choice == -1) {
                ui.print("Возврат в главное меню...");
                return;  // выход из метода run(), возврат в main
            }

            Body body = createBody(choice);
            if (body != null) {
                ui.printSeparator();
                String result = String.format("это тело - %s с объёмом %.2f",
                        body.getType(), body.getVolume());
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

    private Body createBody(int choice) {
        switch (choice) {
            case 1:
                return createCube();
            case 2:
                return createCylinder();
            case 3:
                return createCone();
            default:
                return null;
        }
    }

    private Cube createCube() {
        ui.print("\n--- КУБ ---");
        double side = ui.readDouble("Введите сторону куба: ");
        if (side == -1) return null;
        return new Cube(side);
    }

    private Cylinder createCylinder() {
        ui.print("\n--- ЦИЛИНДР ---");
        double radius = ui.readDouble("Введите радиус: ");
        if (radius == -1) return null;
        double height = ui.readDouble("Введите высоту: ");
        if (height == -1) return null;
        return new Cylinder(radius, height);
    }

    private Cone createCone() {
        ui.print("\n--- КОНУС ---");
        double radius = ui.readDouble("Введите радиус: ");
        if (radius == -1) return null;
        double height = ui.readDouble("Введите высоту: ");
        if (height == -1) return null;
        return new Cone(radius, height);
    }
}