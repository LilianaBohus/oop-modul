package shape;

import static java.lang.Math.PI;

public class Circle extends Shape {
    double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double getPerimeter() {
        return 2 * r * PI;
    }

    @Override
    public double getArea() {
        return r * r * PI;
    }
}
