package d_2019_02_23;

import java.util.Arrays;
import java.util.Scanner;

public class bmi_calculator
{
    static Scanner in = new Scanner(System.in);

    static String err_msg_wronginp = "     [Error] Wrong input, please try again!";
    static String err_msg_unkowerr = "     [Error] Unknow error has been occured!";

    public static void main(String[] args)
    {
        String main_select;
        boolean isContinue;

        do
        {
            System.out.println("========= Calculator Program =========");
            System.out.println("1. Normal Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("3. Exit");
            do
            {
                System.out.print("Please chose your option: ");
                main_select = in.nextLine();
                isContinue = false;
                try
                {
                    switch(Integer.parseInt(main_select))
                    {
                        case 1:
                            NormalCalculator();
                            break;
                        case 2:
                            BMICalculator();
                            break;
                        case 3:
                            System.out.println("Exit program...");
                            System.exit(0);
                            break;
                        default:
                            System.out.println(err_msg_wronginp);
                            isContinue = true;
                    }
                } catch(Exception e)
                {
                    System.out.println(err_msg_wronginp);
                    isContinue = true;
                }
            }while(isContinue);

            System.out.print("Press Enter key to continue...");
            in.nextLine();
            System.out.println();
        } while(true);
    }

    // private static int Enter_int(String str_show)
    // {
    //     return Enter_int("Enter a integer: ", err_msg_wronginp, true);
    // }
    private static int Enter_int(String str_show, String err_msg, boolean isUnsigned)
    {
        String entered;
        do
        {
            System.out.print(str_show);
            entered = in.nextLine();
            try
            {
                if(isUnsigned)
                {
                    return Integer.parseUnsignedInt(entered);
                }
                else
                {
                    return Integer.parseInt(entered);
                }
            }
            catch(NumberFormatException e)
            {
                System.out.println(err_msg);
            }
        }while(true);
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
    private static String Enter_str(String str_show, String err_msg, String accept_str)
    {
        String entered;
        String[] accept = accept_str.split("");

        do
        {
            System.out.print(str_show);
            entered = in.nextLine();
            if(!Arrays.asList(accept).contains(entered))
            {
                System.out.println(err_msg);
            }
        }while(!Arrays.asList(accept).contains(entered));
        checkOperator("*");     // call for fun
        return entered;
    }
    private static boolean checkOperator(String operator)
    {
        String[] accept = "+-*/^=".split("");
        return Arrays.asList(accept).contains(operator);
    }

    public static void NormalCalculator()
    {
        double mem = 0;
        double num;
        String entered;

        System.out.println("----- Normal Calculator -----");
        mem = Enter_num("Enter number: ", "Please input a number");

        do
        {
            entered = Enter_str("Enter Operator: ", "Please input(+,-,*,/,^)", "+|-|*|/|^|=");
            if(!entered.equals("="))
            {
                if(entered.equals("="))
                {
                    num = Enter_num("Enter number: ", "Please input a number");
                    mem += num;
                }else if(entered.equals("-"))
                {
                    num = Enter_num("Enter number: ", "Please input a number");
                    mem -= num;
                }else if(entered.equals("*"))
                {
                    num = Enter_num("Enter number: ", "Please input a number");
                    mem *= num;
                }else if(entered.equals("/"))
                {
                    do
                    {
                        num = Enter_num("Enter number: ", "Please input a number");
                        if(Double.compare(num,0)==0)
                        {
                            System.out.println("Cannot devide to 0.");
                        }
                    }while(Double.compare(num,0)==0);
                    mem /= num;
                }else
                {
                    num = Enter_num("Enter number: ", "Please input a number");
                    mem = Math.pow(mem, num);
                }
                System.out.println("Memory: " + mem);
            }
        }while(!entered.equals("="));
        System.out.println("Result: " + mem);
    }

    
    public static void BMICalculator()
    {
        System.out.println("----- BMI Calculator -----");
        int weight = Enter_int("Enter Weight(kg): ", "BMI is digit", true);
        int height = Enter_int("Enter Height(cm): ", "BMI is digit", true);

        BMI bmi = calculateBMI(weight, height);
        double BMI_NUM = bmi.getBmi();

        System.out.printf("BMI Number: %.2f\n", BMI_NUM);

        System.out.println("BMI Status: " + bmi.toString());
    }

    public static BMI calculateBMI(double weight, double height)
    {
        BMI bmi = BMI.FAT;
        bmi.setBMI(weight, height, bmi);

        double bmi_num = bmi.bmi;
        if(bmi_num<=19) bmi = BMI.USTANDAR;
            else if(bmi_num<=25) bmi = BMI.STANDAR;
                else if(bmi_num<=30) bmi = BMI.FAT;
                    else bmi = BMI.VERRYFAT;
        
        bmi.setBMI(bmi_num);
        return bmi;
    }
    public enum BMI
    {
        USTANDAR, STANDAR, OVERWEIGHT, FAT, VERRYFAT;

        private double bmi;
        private double weight, height;
        private BMI state;

        public void setBMI(double weight, double height, BMI state) {
            this.setWeight(weight);
            this.setHeight(height);
            this.setBmi(weight / ((height/100) * (height/100)));
            this.setState(state);
        }
        public void setBMI(double bmi)
        {
            this.bmi = bmi;
        }

        public double getWeight() {
            return weight;
        }
        public void setWeight(double weight) {
            this.weight = weight;
        }
        public BMI getState() {
            return state;
        }
        public void setState(BMI state) {
            this.state = state;
        }
        public double getBmi() {
            return bmi;
        }
        public void setBmi(double bmi) {
            this.bmi = bmi;
        }
        public double getHeight() {
            return height;
        }
        public void setHeight(double height) {
            this.height = height;
        }

        @Override
        public String toString()
        {
            switch(this)
            {
                case USTANDAR:
                    return "UNDER STANDAR";
                case STANDAR:
                    return "STANDAR";
                case OVERWEIGHT:
                    return "OVERWEIGHT";
                case FAT:
                    return "FAT";
                case VERRYFAT:
                    return "VERY FAT";
                default:
                    return "Co gi do sai sai!";
            }
        }
        public BMI calculateBMI(double weight, double height)
        {
            return BMI.USTANDAR;
        }
    }
}