package d_2019_03_23;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

class Student implements Comparable<Student>
{
    private String Name;
    private String Classes;
    private float Mark;
    
    public Student()
    {
        this("null", "null", 0);
    }
    public Student(String name, String classes, float mark)
    {
        this.Name = name;
        this.Classes = classes;
        this.Mark = mark;
    }
    

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getClasses() {
        return Classes;
    }

    public void setClasses(String Class) {
        this.Classes = Class;
    }

    public float getMark() {
        return Mark;
    }

    public void setMark(float Mark) {
        this.Mark = Mark;
    }

    @Override
    public int compareTo(Student o)
    {
        return this.Name.compareTo(o.Name);
//        compare = (compare==0) ? this.Classes.compareTo(o.Classes) : compare;
    }
}
public class StudentInfo
{
    static Scanner in = new Scanner(System.in);
    static LinkedList<Student> listStudent = new LinkedList<>();
    
    public static void main(String[] args)
    {
        String name, classes;
        float mark;
        
        do
        {
            System.out.println("====== Collection Sort Program ======");
            System.out.println("Please input student information");
            
            System.out.print("Name: ");
            name = in.nextLine();
            
            System.out.print("Classes: ");
            classes = in.nextLine();
            
            mark = (float)Enter_num("Mark: ", "\t[ERROR] Please enter a number.");
                        
            listStudent.add(new Student(name, classes, mark));
            do
            {
                System.out.print("Do you want to enter more student infomamtion? (Y/N): ");
                name = in.nextLine();
                if(!(name.equalsIgnoreCase("y") || name.equalsIgnoreCase("n")))
                    System.out.println("\t[error] Please enter y or n");
            }while(!(name.equalsIgnoreCase("y") || name.equalsIgnoreCase("n")));
        }while(name.equalsIgnoreCase("y"));
        
        sortStudent();
        display();
    }
    
    private static void sortStudent()
    {
        Collections.sort(listStudent);
    }
    private static void display()
    {
        for(Student std : listStudent)
        {
            System.out.println("---------- Student " + (listStudent.indexOf(std) + 1) + "----------");
            System.out.println("Name: " + std.getName());
            System.out.println("Classes: " + std.getClasses());
            System.out.println("Mark: " + std.getClasses());
        }
    }
    private static double Enter_num(String str_show, String err_msg)        // this is checkin function
    {
        String entered;
        do
        {
            System.out.print(str_show);
            entered = in.nextLine();
            try
            {
                return Integer.parseInt(entered);
            }
            catch(NumberFormatException e)
            {
                System.out.println(err_msg);
            }
        }while(true);
    }
}
