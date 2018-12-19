public class Rectangle implements Shape{
    private final double length, width;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }
    public double getLength() {
        return length;
    }
    public double area() { return width * length; }
}