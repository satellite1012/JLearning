package d_2019_03_16;

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
    abstract public String getInfo();
    
    public static double round(double x)
    {
        return ((double)Math.round(x*100)/100);
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
    
    public double getRadius() { return x_axis; }
    @Override
    public double getArea()
    {
        return Shape.round(Math.PI*2*x_axis);
    }

    @Override
    public String getInfo()
    {
        return "A " + this.name + " with radius=" + getRadius() + " has area=" + getArea();
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
    
    public double getEdge() { return x_axis; }
    
    @Override
    public double getArea() { return Shape.round(x_axis*y_axis); }
    
    @Override
    public String getInfo()
    {
        return "A " + this.name + " with edge=" + getEdge()+ " has area=" + getArea();
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
    public double getWidth() { return x_axis; }
    public double getHeight() { return y_axis; }
    @Override
    public double getArea()
    {
        return Shape.round((x_axis*y_axis)/2);
    }
    
    @Override
    public String getInfo()
    {
        return "A " + this.name + " with width=" + x_axis + " and height=" + y_axis + " has area=" + getArea();
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
        this(0);
    }
    public Sphere(double radius)
    {
        super("Sphere", radius, radius, radius);
    }
    
    public double getRadius()
    {
        return x_axis;
    }

    @Override
    public double getArea()
    {
        return Shape.round(4*Math.PI * x_axis * x_axis);
    }

    @Override
    public double getVolume() {
        return Shape.round(((double)4/3) * Math.PI * x_axis * x_axis * x_axis);
    }
    
    @Override
    public String getInfo()
    {
        return "A " + this.name + " with radius=" + getRadius() + " has area=" + getArea() + " and volume=" + getVolume();
    }
    
}

class Cube extends ThreeDemensionalShape
{
    public Cube()
    {
        this(0);
    }
    public Cube(double edge)
    {
        super("Cube", edge, edge, edge);
    }
    
    public double getEdge()
    {
        return x_axis;
    }

    @Override
    public double getArea()
    {
        return Shape.round(6 * x_axis * x_axis);
    }

    @Override
    public double getVolume() {
        return Shape.round(x_axis * x_axis * x_axis);
    }
    
    @Override
    public String getInfo()
    {
        return "A " + this.name + " with edge=" + getEdge() + " has area=" + getArea() + " and volume=" + getVolume();
    }
}

class Tetrahedron extends ThreeDemensionalShape
{
    public Tetrahedron()
    {
        this(0);
    }
    public Tetrahedron(double edge)
    {
        super("Tetrahedron", edge, edge, edge);
    }

    public double getEdge()
    {
        return x_axis;
    }
    
    @Override
    public double getArea()
    {
        return Shape.round(Math.sqrt(3) * x_axis * x_axis);
    }

    @Override
    public double getVolume() {
        return Shape.round(((double)1/12) * Math.sqrt(2) * x_axis * x_axis * x_axis);
    }
    
    
    @Override
    public String getInfo()
    {
        return "A " + this.name + " with edge=" + getEdge() + " has area=" + getArea() + " and volume=" + getVolume();
    }
}

public class SomeShape
{
    private static Shape arrShape[];
    public static void main(String[] args)
    {
        arrShape = new Shape[6];
        arrShape[0] = new Circle(3);
        arrShape[1] = new Square(3);
        arrShape[2] = new Triangle(4, 3);
        arrShape[3] = new Sphere(3);
        arrShape[4] = new Cube(3);
        arrShape[5] = new Tetrahedron(3);
        
        for(Shape s : arrShape)
        {
            System.out.println(s.getInfo());
        }
    }
}
