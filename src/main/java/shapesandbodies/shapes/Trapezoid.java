package main.java.shapesandbodies.shapes;

public class Trapezoid implements Shape {
    private final double baseA;
    private final double baseB;
    private final double height;
    private final double sideC;
    private final double sideD;

    public Trapezoid(double baseA, double baseB, double height, double sideC, double sideD) {
        this.baseA = baseA;
        this.baseB = baseB;
        this.height = height;
        this.sideC = sideC;
        this.sideD = sideD;
    }

    @Override
    public double getArea() {
        return (baseA + baseB) * height / 2;
    }

    @Override
    public double getPerimeter() {
        return baseA + baseB + sideC + sideD;
    }

    @Override
    public String getType() {
        return "трапеция";
    }
}