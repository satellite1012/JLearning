
public class EX02
{
    public static void main(String[] args)
    {
        // Test all method of class Shape
        Shape sp = new Shape();
        System.out.print(">> Shape with no-arg constructor:\n" + sp.toString());
        Shape sp2 = new Shape("black", false);
        System.out.print("\n>> Shape with arg constructor: \nColor=" + sp2.getColor() + " and Filled=" + sp2.isFilled() + "\ntoString()=" + sp2.toString());
        sp2.setColor("blue");
        sp2.setFilled(true);
        System.out.print("\n>> After modify:\nColor=" + sp2.getColor() + " and Filled=" + sp2.isFilled() + "\ntoString()=" + sp2.toString());

        // Test method of class Circle
        Circle cc = new Circle(9);
        System.out.print("\n" + cc.toString());

        // Test method of class Rectangle
        Rectangle rt = new Rectangle(5.0, 10.0, "blue", true);
        System.out.print("\n" + rt.toString());

        // Test method of class Square
        Square sq = new Square(5, "black", false);
        System.out.print("\n" + sq.toString());

    }
}

class Shape
{
    private String Color = "red";
    private boolean Filled = true;

    public Shape()
    {
        Color = "green";
        Filled = true;
    }
    public Shape(String color, boolean filled)
    {
        Color = color;
        Filled = filled;
    }
    public String getColor()
    {
        return Color;
    }
    public void setColor(String color)
    {
        Color = color;
    }
    public boolean isFilled()
    {
        return Filled;
    }
    public void setFilled(boolean filled)
    {
        Filled = filled;
    }
    public String toString()
    {
        return "A shape with color of " + Color + " and " + (Filled ? "filled." : "not filled.");
    }
}

class Circle extends Shape
{
    private double Radius;
    
    public Circle()
    {
        super();
        Radius = 1.0;
    }
    public Circle(double radius)
    {
        super();
        Radius = radius;
    }
    public Circle(double radius, String color, boolean filled)
    {
        super.setColor(color);
        super.setFilled(filled);
        Radius = radius;
    }
    public double getRadius()
    {
        return Radius;
    }
    public void setRadius(double radius)
    {
        Radius = radius;
    }
    public double getArea()
    {
        return 3.14*Radius*Radius;
    }
    public double getPerimeter()
    {
        return 3.14*2*Radius;
    }
    public String toString()
    {
        return "A circle with radius=" + Radius + ", which is a subclass of " + super.toString();
    }
}

class Rectangle extends Shape
{
    private double Width = 1.0;
    private double Length = 1.0;

    public Rectangle()
    {
        super();
        Width = 1.0;
        Length = 1.0;
    }
    public Rectangle(double width, double length)
    {
        super();
        Width = width;
        Length = length;
    }
    public Rectangle(double width, double length, String color, boolean filled)
    {
        super(color, filled);
        Width = width;
        Length = length;
    }
    public double getWidth()
    {
        return Width;
    }
    public void setWidth(double width)
    {
        Width = width;
    }
    public double getLength()
    {
        return Length;
    }
    public void setLength(double length)
    {
        Length = length;
    }
    public double getArea()
    {
        return Width * Length;
    }
    public double getPerimeter()
    {
        return (Width + Length) * 2;
    }
    public String toString()
    {
        return "A rectangle with width=" + Width + " and length=" + Length + ", which is a subclass of " + super.toString();
    }
}

class Square extends Rectangle
{
    public Square()
    {
        super(1.0, 1.0);
    }
    public Square(double side)
    {
        super(side, side);
    }
    public Square(double side, String color, boolean filled)
    {
        super(side, side, color, filled);
    }
    public double getSide()
    {
        return super.getWidth();
    }
    public void setSide(double side)
    {
        setWidth(side);
        setLength(side);
    }
    public void setWidth(double side)
    {
        super.setWidth(side);
    }
    public void setLength(double side)
    {
        super.setLength(side);
    }
    public String toString()
    {
        return "A square with side=" + getSide() + ", which is a subclass of " + super.toString();
    }
}