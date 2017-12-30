/**
 * Created by Taras_Derewecki on 9/20/16.
 */
public class Rectangle implements Shape
{
    protected double length;
    protected double width;

    public Rectangle(double length, double width)
    {
        this.length = length;
        this.width = width;
    }

    public double getLength(){return length;}
    public double getWidth(){return width;}

    public void setLength(double length){this.length = length;}
    public void setWidth(double width){this.width = width;}


    @Override
    public double area(){return getLength() * getWidth();}
}
