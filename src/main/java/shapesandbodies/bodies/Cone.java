package main.java.shapesandbodies.bodies;

public class Cone implements Body {
    private final double radius;
    private final double height;

    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.PI * radius * radius * height / 3;
    }

    @Override
    public String getType() {
        return "конус";
    }
}