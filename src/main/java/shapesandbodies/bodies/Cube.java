package main.java.shapesandbodies.bodies;

public class Cube implements Body {
    private final double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double getVolume() {
        return side * side * side;
    }

    @Override
    public String getType() {
        return "куб";
    }

    @Override
    public void print() {
        System.out.printf("это тело - %s с объёмом %.2f%n",
                getType(), getVolume());
    }
}