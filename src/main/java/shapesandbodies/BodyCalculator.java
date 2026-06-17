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
                System.out.println("Возврат в главное меню...");
                return;
            }

            Body body = createBody(choice);

            if (body != null) {
                System.out.println();
                body.print();
                System.out.println();

                if (!ui.askToContinue()) {
                    System.out.println("Возврат в главное меню...");
                    return;
                }
            }
        }
    }

    private Body createBody(int choice) {
        switch (choice) {
            case 1: return createCube();
            case 2: return createCylinder();
            case 3: return createCone();
            default: return null;
        }
    }

    private Cube createCube() {
        System.out.println("\nВведите сторону куба:");
        double side = ui.readDouble("  сторона: ");
        if (side == -1) return null;
        return new Cube(side);
    }

    private Cylinder createCylinder() {
        System.out.println("\nВведите параметры цилиндра:");
        double radius = ui.readDouble("  радиус: ");
        if (radius == -1) return null;
        double height = ui.readDouble("  высота: ");
        if (height == -1) return null;
        return new Cylinder(radius, height);
    }

    private Cone createCone() {
        System.out.println("\nВведите параметры конуса:");
        double radius = ui.readDouble("  радиус: ");
        if (radius == -1) return null;
        double height = ui.readDouble("  высота: ");
        if (height == -1) return null;
        return new Cone(radius, height);
    }
}