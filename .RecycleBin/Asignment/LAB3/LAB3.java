import java.util.Scanner;

public class LAB3
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String sellect;
        System.out.print("Nhap chuc danh cua ban (person/student/staff): ");
        sellect = in.nextLine().toLowerCase();

        String name;
        System.out.print("Nhap ten ban: ");
        name = in.nextLine();

        String address;
        System.out.print("Nhap dia chi cua ban: ");
        address = in.nextLine();

        String tmp;
        switch (sellect)
        {
            case "person":
                Person psn1 = new Person(name, address);
                System.out.print(">>Person:\n" + psn1.toString() + "\n");
                break;
            case "student":
                Student std1 = new Student(name, address, "", 0, 0);

                System.out.print("Program: ");
                tmp = in.nextLine();
                std1.setProgram(tmp);
                
                System.out.print("Year: ");
                tmp = in.nextLine();
                std1.setYear(Integer.parseInt(tmp));
                
                System.out.print("Fee: ");
                tmp = in.nextLine();
                std1.setFee(Double.parseDouble(tmp));

                System.out.print(">>Student:\n" + std1.toString() + "\n");
                break;
            case "staff":
                Staff stf1 = new Staff(name, address, "", 0);

                System.out.print("School: ");
                tmp = in.nextLine();
                stf1.setSchool(tmp);

                System.out.print("Pay: ");
                tmp = in.nextLine();
                stf1.setPay(Double.parseDouble(tmp));

                System.out.print(">>Staff:\n" + stf1.toString() + "\n");
                break;
            default:
                System.out.println("Ban nhap khong dung yeu cau.");
                System.exit(0);
        }
    }
}

class Person
{
    protected String Name;
    protected String Address;

    public Person()
    {
        Name = "class Person.Name";
        Address = "class Person.Address";
    }
    public Person(String name, String address)
    {
        Name = name;
        Address = address;
    }

    public String getName()
    {
        return Name;
    }

    public String getAddress()
    {
        return Address;
    }

    public void setAddress(String address)
    {
        Address = address;
    }

    public String toString()
    {
        return "Person[name=" + Name + ",address=" + Address + "]";
    }
}

class Student extends Person
{
    private String Program;
    private int Year;
    private double Fee;

    public Student()
    {
        Name = "class Student.Name";
        Address = "class Student.Address";
        Program = "class Student.Program";
        Year = 2018;
        Fee = 17.10;
    }
    public Student(String name, String address, String program, int year, double fee)
    {
        Name = name;
        Address = address;
        Program = program;
        Year = year;
        Fee = fee;
    }
    public String getProgram()
    {
        return Program;
    }
    public void setProgram(String program)
    {
        Program = program;
    }
    public int getYear()
    {
        return Year;
    }
    public void setYear(int year)
    {
        Year = year;
    }
    public double getFee()
    {
        return Fee;
    }
    public void setFee(double fee)
    {
        Fee = fee;
    }
    public String toString()
    {
        return "Student[Person[name="+Name+",address="+Address+"],program="+Program+",year="+Year+",fee="+Fee+"]";
    }
}

class Staff extends Person
{
    private String School;
    private double Pay;

    public Staff()
    {
        Name = "class Staff.Name";
        Address = "class Staff.Address";
        School = "class Staff.Shool";
        Pay = 20.10;
    }
    public Staff(String name, String address, String school, double pay)
    {
        Name = name;
        Address = address;
        School = school;
        Pay = pay;
    }
    public String getSchool()
    {
        return School;
    }
    public void setSchool(String school)
    {
        School = school;
    }
    public double getPay()
    {
        return Pay;
    }
    public void setPay(double pay)
    {
        Pay = pay;
    }
    public String toString()
    {
        return "Staff[Person[name=" + Name + ",address=" + Address + ",]school=" + School + ",pay=" + Pay + "]";
    }
}