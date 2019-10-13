package d_2019_02_16;

import java.util.Scanner;

public class Equation
{
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {
        String main_select;
        boolean main_check;
        
        do
        {
            System.out.println("========= Equation Program =========");
            System.out.println("1. Calculate Superlative Equation");
            System.out.println("2. Calculate Quadratic Equation");
            System.out.println("3. Exit");
            do
            {
                System.out.print("Please choose one option: ");
                main_select = in.nextLine();
                main_check = main_select.equals("1") || main_select.equals("2") || main_select.equals("3");
                if(!main_check) System.out.println("    [ERROR] Wrong input, try again!");
            } while(!main_check);

            switch(Integer.parseInt(main_select))
            {
                case 1:
                    EQ_Superlative();
                    break;
                case 2:
                    EQ_Quadratic();
                    break;
                case 3:
                    System.out.println("Exit program...");
                    System.exit(0);
                    break;
                default:
                    System.out.print("    [ERROR] Unhandle error has occur!");
            }
            System.out.print("Press Enter to continue...");
            in.nextLine();
        }while(!main_select.equals("3"));
    }
    
    private static boolean isSquare(double num)
    {
        return Math.floor(Math.sqrt(num)) == Math.sqrt(num);
    }
    private static boolean isEven(double num)
    {
        return num % 2 == 0;
    }
    private static void EQ_Superlative()
    {
        System.out.println("========= Superlative Equation Solving =========");
        System.out.println("      ---------    Ax + B = 0    ---------      ");
        
        String eq_select;
        boolean eq_check;
        double numA = 0, numB = 0;
        do
        {
            eq_check = true;
            System.out.print("Enter A: ");
            eq_select = in.nextLine();
            try
            {
                numA = Double.parseDouble(eq_select);
            }catch(NumberFormatException e)
            {
                eq_check = false;
                System.out.println("    [ERROR] Wrong input, try again!");
            }
        } while(!eq_check);
        do
        {
            eq_check = true;
            System.out.print("Enter B: ");
            eq_select = in.nextLine();
            try
            {
                numB = Double.parseDouble(eq_select);
            }catch(NumberFormatException e)
            {
                eq_check = false;
                System.out.println("    [ERROR] Wrong input, try again!");
            }
        } while(!eq_check);
        
        if(numA == 0)
        {
            if(numB==0) System.out.println("Infinite solution");
            else System.out.println("No solution");
        }else
        {
            System.out.println("Solution: x = " + (-numB)/numA);
        }
        System.out.println("Number is Odd: " + (isEven(numA) ? "" : numA) + " " + (isEven(numB) ? "" : numB));
        System.out.println("Number is Even: " + (isEven(numA) ? numA : "") + " " + (isEven(numB) ? numB : ""));
        System.out.println("Number is Perfect Square: " + (isSquare(numA) ? numA : "") + " " + (isSquare(numB) ? numB : ""));
    }
    private static void EQ_Quadratic()
    {
        System.out.println("========== Quadratic Equation Solving ==========");
        System.out.println("  ---------    Ax^2 + By + C = 0    ---------   ");
        
        String eq_select;
        boolean eq_check;
        double numA = 0, numB = 0, numC = 0;
        do
        {
            eq_check = true;
            System.out.print("Enter A: ");
            eq_select = in.nextLine();
            try
            {
                numA = Double.parseDouble(eq_select);
            }catch(NumberFormatException e)
            {
                eq_check = false;
                System.out.println("    [ERROR] Wrong input, try again!");
            }
        } while(!eq_check);
        do
        {
            eq_check = true;
            System.out.print("Enter B: ");
            eq_select = in.nextLine();
            try
            {
                numB = Double.parseDouble(eq_select);
            }catch(NumberFormatException e)
            {
                eq_check = false;
                System.out.println("    [ERROR] Wrong input, try again!");
            }
        } while(!eq_check);
        do
        {
            eq_check = true;
            System.out.print("Enter C: ");
            eq_select = in.nextLine();
            try
            {
                numC = Double.parseDouble(eq_select);
            }catch(NumberFormatException e)
            {
                eq_check = false;
                System.out.println("    [ERROR] Wrong input, try again!");
            }
        } while(!eq_check);
        
        if(numA == 0)
        {
            if(numB == 0)
            {
                if(numC==0) System.out.println("Infinite solution");
                else System.out.println("No solution");
            }else
            {
                System.out.println("Solution: x = " + (-numC)/numB);
            }
        }else
        {
            double delta = numB*numB - 4*numA*numC;
            if(delta<0) System.out.println("No solution");
            else if(delta==0) System.out.println("Solution: x = " + (-numB)/(2*numA));
            else System.out.println("Solution: x1 = " + (-numB-Math.sqrt(delta))/(2*numA) + " and x2 = " + (-numB+Math.sqrt(delta))/(2*numA));
        }
        System.out.println("Number is Odd: " + (isEven(numA) ? "" : numA) + " " + (isEven(numB) ? "" : numB) + " " + (isEven(numC) ? "" : numC));
        System.out.println("Number is Even: " + (isEven(numA) ? numA : "") + " " + (isEven(numB) ? numB : "") + " " + (isEven(numC) ? numC : ""));
        System.out.println("Number is Perfect Square: " + (isSquare(numA) ? numA : "") + " " + (isSquare(numB) ? numB : "") + " " + (isSquare(numC) ? numC : ""));
    }
}
