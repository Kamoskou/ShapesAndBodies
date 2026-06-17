package main.java.shapesandbodies.shapes;

public class Triangle implements Shape {
    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public String getType() {
        return "треугольник";
    }

    @Override
    public void print() {
        System.out.printf("это фигура - %s с периметром %.2f и площадью %.2f%n",
                getType(), getPerimeter(), getArea());
    }
}