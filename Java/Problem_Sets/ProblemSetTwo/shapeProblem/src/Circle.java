import static java.lang.Math.PI;

/**
 * Created by Taras_Derewecki on 9/20/16.
 */
public class Circle implements Shape
{
    protected double radius;

    public Circle(double radius) {this.radius = radius;}

    public double getRadius(){return radius;}

    public void setRadius(double radius){this.radius = radius;}

    public double area(){return (PI) * Math.pow(getRadius(), 2);}
}