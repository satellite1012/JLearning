package lab;

abstract class Shape
{
    protected String name;
    Shape()
    {
        this("Shape");
    }
    Shape(String name)
    {
        this.name = name;
    }
}
abstract class TwoDemensionalShape extends Shape
{
    protected double x_axis, y_axis;
    public TwoDemensionalShape()
    {
        this("TwoDemensionalShape");
    }
    public TwoDemensionalShape(String name)
    {
        this(name, 0, 0);
    }
    public TwoDemensionalShape(String name, double x_axis, double y_axis)
    {
        super(name);
        this.x_axis = x_axis;
        this.y_axis = y_axis;
    }

    abstract public double getArea();
}
class Circle extends TwoDemensionalShape
{
    public Circle()
    {
        this(1);
    }
    public Circle(double radius)
    {
        super("Circle", radius, radius);
    }

	@Override
    public double getArea()
    {
		return Math.PI*2*x_axis;
	}
}
class Square extends TwoDemensionalShape
{
    public Square()
    {
        this(1);
    }
    public Square(double edge)
    {
        super("Square", edge, edge);
    }
    @Override
    public double getArea()
    {
        return x_axis*y_axis;
    }
}
class Triangle extends TwoDemensionalShape
{
    public Triangle()
    {
        this(1, 1);
    }
    public Triangle(double width, double height)
    {
        super("Triangle", width, height);
    }
    @Override
    public double getArea()
    {
        return (x_axis*y_axis)/2;
    }
    
}

abstract class ThreeDemensionalShape extends Shape
{
    protected double x_axis, y_axis, z_axis;
    public ThreeDemensionalShape()
    {
        this("ThreeDemensionalShape");
    }
    public ThreeDemensionalShape(String name)
    {
        this(name, 0, 0, 0);
    }
    public ThreeDemensionalShape(String name, double x_axis, double y_axis, double z_axis)
    {
        super(name);
        this.x_axis = x_axis;
        this.y_axis = y_axis;
        this.z_axis = z_axis;
    }
    abstract public double getArea();
    abstract public double getVolume();
}
class Sphere extends ThreeDemensionalShape
{
    public Sphere()
    {
        this("Sphere");
    }
    public Sphere(String name)
    {
        this(name, 0);
    }
    public Sphere(String name, double radius)
    {
        super(name, radius, radius, radius);
    }

    @Override
    public double getArea()
    {
        return 0;
    }

    @Override
    public double getVolume() {
        return 0;
    }
    
}

public class SomeShape
{
    public static void main(String[] args)
    {
        
    }
}