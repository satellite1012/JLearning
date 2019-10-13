package old;

import java.util.Scanner;
import java.lang.Math;

public class BINDECHEX 
{
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {
//        Debug
//        System.out.println("DEC2HEX: " + DEC2HEX(165));
//        System.out.println("HEX2DEC: " + HEX2DEC("A5"));
//        System.out.println("DEC2BIN: " + DEC2BIN(165));
//        System.out.println("BIN2DEC: " + BIN2DEC("10100101"));
//        System.out.println("HEX2BIN: " + HEX2BIN("A5"));
//        System.out.println("BIN2HEX: " + BIN2HEX("10100101"));
//        return;
        
        int base_in, base_out;
        String confirm_exit;
        do
        {
            System.out.println("=== Convert Base System Program ===");
            System.out.println("1. Binary");
            System.out.println("2. Decimal");
            System.out.println("3. Hexadecimal");
            do
            {
                do
                {
                    System.out.print(">> Enter your input base: ");
                    base_in = in.nextInt();
                    if(base_in<1 || base_in>3) System.out.println("You enter wrong, try again!");
                } while(base_in<1 || base_in>3);
                do
                {
                    System.out.print(">> Enter your output base: ");
                    base_out = in.nextInt();
                    if(base_out<1 || base_out>3) System.out.println("Error: Wrong input, try again!");
                    if(base_in==base_out) System.out.println("Error: Base input cannot equal base output, try again!");
                } while(base_out<1 || base_out>3 || base_in==base_out);
            } while(!(base_in>0 && base_in<4 && base_out>0 && base_out<4 && base_in!=base_out));
            
            EnterAndProcess(base_in, base_out);
            
            do
            {
                System.out.print("Do yout want to continue? (Y/N) ");
                confirm_exit = in.nextLine();
                
                if(!confirm_exit.toUpperCase().equals("Y") && !confirm_exit.toUpperCase().equals("N"))
                {
                    System.out.println("Error: Enter Y/N only, try again!");
                }
            }while(!confirm_exit.toUpperCase().equals("Y") && !confirm_exit.toUpperCase().equals("N"));
        } while (!confirm_exit.toUpperCase().equals("N"));
        in.close();
        System.out.print("Program exited!");
    }
    
    private static void EnterAndProcess(int base_in, int base_out)
    {
        String num_in;
        in.nextLine();
        switch(base_in)
        {
            case 1:
                System.out.print("Enter a binary number: ");
                num_in = in.nextLine();
                switch(base_out)
                {
                    case 2:
                        System.out.print("Your decimal number: " + BIN2DEC(num_in));
                        break;
                    case 3:
                        System.out.print("Your hexadecimal number: " + BIN2HEX(num_in));
                        break;
                }
                break;
            case 2:
                System.out.print("Enter a decimal number: ");
                num_in = in.nextLine();
                switch(base_out)
                {
                    case 1:
                        System.out.print("Your binary number: " + DEC2BIN(num_in));
                        break;
                    case 3:
                        System.out.print("Your hexadecimal number: " + DEC2HEX(num_in));
                        break;
                }
                break;
            case 3:
                System.out.print("Enter a hexadecimal number: ");
                num_in = in.nextLine();
                switch(base_out)
                {
                    case 1:
                        System.out.print("Your binary number: " + HEX2BIN(num_in));
                        break;
                    case 2:
                        System.out.print("Your decimal number: " + HEX2DEC(num_in));
                        break;
                }
                break;
        }
        System.out.println("");
    }
    
    private static String DEC2HEX(String sDec)
    {
        int iDec = Integer.parseInt(sDec);
        return ((iDec>15) ? DEC2HEX((String.valueOf(iDec/16))) : "") + HEX_Format(String.valueOf(iDec % 16));
    }
    private static String HEX_Format(String sHex)
    {
        if(sHex.equals("10")) return "A";
        if(sHex.equals("11")) return "B";
        if(sHex.equals("12")) return "C";
        if(sHex.equals("13")) return "D";
        if(sHex.equals("14")) return "E";
        if(sHex.equals("15")) return "F";
        if(sHex.equals("A")) return "10";
        if(sHex.equals("B")) return "11";
        if(sHex.equals("C")) return "12";
        if(sHex.equals("D")) return "13";
        if(sHex.equals("E")) return "14";
        if(sHex.equals("F")) return "15";
        return sHex;
    }
    private static String HEX2DEC(String sHex)
    {
        int k = 0, ret = 0;
        int l = sHex.length();
        while(k!=l)
        {
//            System.out.println("-- " + Integer.parseInt(HEX_Format(String.valueOf(iHex.charAt(k)))) + " * 16^" + (l-k));
            ret += Integer.parseInt(HEX_Format(String.valueOf(sHex.charAt(k)))) * (int)Math.pow(16, l-k-1);
            k++;
        }
        return String.valueOf(ret);
    }
    private static String DEC2BIN(String sDec)
    {
        int iDec = Integer.parseInt(sDec);
        return ((iDec>1) ? DEC2BIN((String.valueOf(iDec/2))) : "") + String.valueOf(iDec % 2);
    }
    private static String BIN2DEC(String sBin)
    {
        int k = 0, ret = 0;
        int l = sBin.length();
        while(k!=l)
        {
//            System.out.println("-- " + Integer.parseInt(HEX_Format(String.valueOf(iHex.charAt(k)))) + " * 16^" + (l-k));
            ret += Integer.parseInt(String.valueOf(sBin.charAt(k))) * (int)Math.pow(2, l-k-1);
            k++;
        }
        return String.valueOf(ret);
    }
    private static String HEX2BIN(String sHex)
    {
        return DEC2BIN(HEX2DEC(sHex));
    }
    private static String BIN2HEX(String sHex)
    {
        return DEC2HEX(BIN2DEC(sHex));
    }
}

