import java.lang.Math;

public class EX03
{
    public static void main(String[] args)
    {
        Rectangle rc = new Rectangle(3, 5);
        System.out.print("Area of rectangle of 3x5: " + rc.getArea() + "\n");
        System.out.print("Perimeter of rectangle of 3x5: " + rc.getPerimeter() + "\n");

        RtTriangle tr = new RtTriangle(3, 4);
        System.out.print("\nArea of right triangle of 3x4: " + tr.getArea() + "\n");
        System.out.print("Perimeter of right triangle of 3x4: " + tr.getPerimeter() + "\n");
    }
}

abstract class Shape
{
    private int numSides;
    public Shape()
    {
        numSides = 3;
    }
    public Shape(int _numSides)
    {
        numSides = _numSides;
    }
    public int getnumSides()
    {
        return numSides;
    }
    public abstract double getArea();
    public abstract double getPerimeter();
}

class Rectangle extends Shape
{
    private double Width, Height;

    public Rectangle()
    {
        super(4);
        Width = 3;
        Height = 2;
    }
    public Rectangle(double width, double height)
    {
        super(4);
        Width = width;
        Height = height;
    }
    @Override
    public double getArea()
    {
        return (Width * Height);
    }
    @Override
    public double getPerimeter()
    {
        return (Width + Height) * 2;
    }
}

class RtTriangle extends Shape
{
    private double Width, Height;
    public RtTriangle()
    {
        super();
        Width = 3;
        Height = 4;
    }
    public RtTriangle(double width, double height)
    {
        super();
        Width = width;
        Height = height;
    }
    @Override
    public double getArea()
    {
        return (Width * Height) / 2;
    }
    @Override
    public double getPerimeter() {
        return Width + Height + Math.sqrt(Width*Width + Height*Height);
    }
}