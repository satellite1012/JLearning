package d_2019_03_23;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Expense
{
    public static int countID = 0;
    public static double total = 0;
    
    private int ID;
    private LocalDate Date;
    private double Amount;
    private String Content;
    
    public Expense()
    {
        this(null, 0, "null");
    }
    public Expense(LocalDate date, double amount, String content)
    {
        this.Date = date;
        this.Amount = amount;
        this.Content = content;
        this.ID = ++countID;
        total += amount;
    }

    public String getInfo()
    {
        return this.ID + "\t" + this.Date
                + "\t" + this.Amount + "\t" + this.Content;
    }
    
    static double getTotal() { return total; }

    int getID()
    {
        return this.ID;
    }
}

public class HandyExpense
{
    private static final Scanner in = new Scanner(System.in);
    private static final String err_msg_wronginp = "\t[ERROR] Wrong input, try again!";
    
    private static List<Expense> lstExpense = new LinkedList<>();
    
    public static void main(String[] args)
    {
        String main_select;
        boolean isContinue;
        do
        {
            System.out.println("======= Handy Expense Program =======");
            System.out.println("1. Add an expense");
            System.out.println("2. Display all expenses");
            System.out.println("3. Delete an expenses");
            System.out.println("4. Quit");
            do
            {
                System.out.print("Your choice: ");
                main_select = in.nextLine();
                isContinue = false;
                try
                {
                    switch(Integer.parseInt(main_select))
                    {
                        case 1:
                            addExpense();
                            break;
                        case 2:
                            displayAll();
                            break;
                        case 3:
                            deleteExpense();
                            break;
                        case 4:
                            in.close();
                            System.out.println("Exit program...");
                            System.exit(0);
                            break;
                        default:
                            System.out.println(err_msg_wronginp);
                            isContinue = true;
                    }
                } catch(NumberFormatException e)
                {
//                    e.printStackTrace();
                    System.out.println(err_msg_wronginp);
                    isContinue = true;
                }
            }while(isContinue);

            System.out.print("Press Enter key to continue...");
            in.nextLine();
            System.out.println();
        } while(true);
    }
    
    public static boolean addExpense(){
        LocalDate date;
        String content;
        double amount;
        
        System.out.println("------- Add and expense -------");
        
        date = Enter_date("Enter Date: ", "\t[ERROR] Enter like this: yyyy-mm-dd\nPlease try again!");
        amount = Enter_num("Enter Amount: ", err_msg_wronginp);
        System.out.print("Enter Content: ");
        content = in.nextLine();
        
        return addExpense(lstExpense, date, amount, content);
    }
    
    public static boolean addExpense(List<Expense> list, LocalDate date, double amount, String content){
        return list.add(new Expense(date, amount, content));
    }
    
    public static void displayAll()
    {
        displayAll(lstExpense);
    }
    public static void displayAll(List<Expense> list)
    {
        System.out.println("------- Display all expenses -------");
        if(list.isEmpty())
        {
            System.out.println("List is empty now!");
            return;
        }
        System.out.println("ID\t   Date\t\tAmount\tContent");
        for(Expense ex : list)
        {
            System.out.println(ex.getInfo());
        }
        System.out.println("Total: " + Expense.getTotal());
    }
    
    public static void deleteExpense()
    {
        
        if(deleteExpense(lstExpense, (int)Enter_num("Enter ID: ", err_msg_wronginp)))
        {
            System.out.println("Delete successful");
        }
        else
        {
            System.out.println("Delete an expense fail");
        }
    }
    public static boolean deleteExpense(List<Expense> list, int id)
    {
        for(Expense e : list)
        {
            if(e.getID()==id)
            {
                return list.remove(e);
            }
        }
        return false;
    }
    
    private static LocalDate Enter_date(String str_show, String err_msg){
        do
        {
            try
            {
                System.out.print(str_show);
                return LocalDate.parse(in.nextLine());
            }
            catch(Exception e)
            {
                System.out.println(err_msg);
            }
        } while(true);
    }
    private static double Enter_num(String str_show, String err_msg){
        String entered;
        do
        {
            System.out.print(str_show);
            entered = in.nextLine();
            try
            {
                return Double.parseDouble(entered);
            }
            catch(NumberFormatException e)
            {
                System.out.println(err_msg);
            }
        }while(true);
    }
}
