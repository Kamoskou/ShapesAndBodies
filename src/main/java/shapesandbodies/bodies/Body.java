package main.java.shapesandbodies.bodies;

import main.java.shapesandbodies.Printable;

public interface Body extends Printable {
    double getVolume();
    String getType();
}