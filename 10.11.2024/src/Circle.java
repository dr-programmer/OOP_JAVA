import java.util.Objects;
import java.util.Scanner;

public class Circle {
    private double radius;

    public Circle() {}
    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle circle)) return false;
        return Double.compare(radius, circle.radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(radius);
    }

    public static void main(String[] args) {
        System.out.println("Type the radius of the circle: ");
        Scanner sc = new Scanner(System.in);
        double radius = sc.nextDouble();
        sc.close();

        Circle circle = new Circle(radius);
        System.out.println("The area of the circle is " + circle.getArea());
        System.out.println("The perimeter of the circle is " + circle.getPerimeter());
        System.out.println("The radius of the circle is " + circle.getRadius());
        System.out.println("To string" + circle.toString());
    }
}
