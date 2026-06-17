package main.java.shapesandbodies.shapes;

import main.java.shapesandbodies.Printable;

public interface Shape extends Printable {
    double getArea();
    double getPerimeter();
    String getType();
}