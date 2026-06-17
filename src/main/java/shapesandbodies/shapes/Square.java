package main.java.shapesandbodies.shapes;

public class Square implements Shape {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public String getType() {
        return "квадрат";
    }

    @Override
    public void print() {
        System.out.printf("это фигура - %s с периметром %.2f и площадью %.2f%n",
                getType(), getPerimeter(), getArea());
    }
}