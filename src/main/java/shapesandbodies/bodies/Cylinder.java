package main.java.shapesandbodies.bodies;

public class Cylinder implements Body {
    private final double radius;
    private final double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.PI * radius * radius * height;
    }

    @Override
    public String getType() {
        return "цилиндр";
    }

    @Override
    public void print() {
        System.out.printf("это тело - %s с объёмом %.2f%n",
                getType(), getVolume());
    }
}