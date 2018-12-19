public class Circle implements Shape {
    private final double radius;
    final double pie = Math.PI;

    public double getRadius() { return radius; }
    public double getPie() { return pie; }
    public Circle(double radius) { this.radius = radius; }
    public double area() { return pie * Math.pow(radius, 2); }
}