package d_2019_03_02;

import java.util.Scanner;

public class Calculator
{
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {
        String main_select;
        boolean main_check;
        
        do
        {
            System.out.println("========= Calculator Program =========");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            do
            {
                System.out.print("Your choice: ");
                main_select = in.nextLine();
                main_check = main_select.equals("1") || main_select.equals("2") || main_select.equals("3")|| main_select.equals("4");
                if(!main_check) System.out.println("    [ERROR] Wrong input, try again!");
            } while(!main_check);

            switch(Integer.parseInt(main_select))
            {
                case 1:
                    Mtx_Addition();
                    break;
                case 2:
                    Mtx_Subtraction();
                    break;
                case 3:
                    Mtx_Multiplication();
                    break;
                case 4:
                    System.out.println("Exit program...");
                    System.exit(0);
                    break;
                default:
                    System.out.print("    [ERROR] Unhandled error has occur!");
            }
            System.out.print("Press Enter to continue...");
            in.nextLine();
        }while(!main_select.equals("4"));
    }
    
    
    // Input/Output methods
    private static String err_msg = "    [ERROR] Wrong input, try again!";
    private static int[][] mtx_1, mtx_2;
    private static int mtx_1_row, mtx_1_col, mtx_2_row, mtx_2_col;
    
    private static int Enter_an_int(String str_show, String err_msg, boolean isUnsigned)
    {
        String etr_select;
        boolean etr_check;
        int ret = 0;
        do
        {
            etr_check = true;
            System.out.print(str_show);
            etr_select = in.nextLine();
            try
            {
                if(isUnsigned)
                {
                    ret = Integer.parseUnsignedInt(etr_select);
                } else
                {
                    ret = Integer.parseInt(etr_select);
                }
            }catch(NumberFormatException e)
            {
                etr_check = false;
                System.out.println(err_msg);
            }
        } while(!etr_check);
        return ret;
    }
    private static void Mtx_Enter()
    {
        Mtx_Enter(true);
    }
    private static void Mtx_Enter(boolean isSameSize)
    // Variable isSameSize = false use for multiplicate 2 matrix
    {
        // Enter matrix 1
        mtx_1_row = Enter_an_int("Enter Row Matrix1: ", err_msg, true);
        mtx_1_col = Enter_an_int("Enter Column Matrix1: ", err_msg, true);
        
        mtx_1 = new int[mtx_1_row][mtx_1_col];
        for(int i = 0; i<mtx_1_row; i++)
        {
            for(int j = 0; j<mtx_1_col; j++)
            {
                mtx_1[i][j] = Enter_an_int(String.format("Enter Matrix1[%d][%d]:", i, j), err_msg, false);
            }
        }
        
        // Enter matrix 2
        // Check for same size if + and - matrix
        boolean mtx_check;
        do
        {
            mtx_check = true;
            mtx_2_row = Enter_an_int("Enter Row Matrix2: ", err_msg, true);
            mtx_2_col = Enter_an_int("Enter Column Matrix2: ", err_msg, true);
            if(isSameSize && (mtx_1_row!=mtx_2_row || mtx_1_col!=mtx_2_col))
            {
                mtx_check = false;
                System.out.println("    [ERROR] Two matrix must have same size!\n    Please try again.");
            } else if(!isSameSize && (mtx_1_col!=mtx_2_row))
            {
                mtx_check = false;
                System.out.println("    [ERROR] Collum of matrix 1 must equals row of matrix 2!\n    Please try again.");
            }
        }while(!mtx_check);
        mtx_2 = new int[mtx_2_row][mtx_2_col];
        for(int i = 0; i<mtx_2_row; i++)
        {
            for(int j = 0; j<mtx_2_col; j++)
            {
                mtx_2[i][j] = Enter_an_int(String.format("Enter Matrix2[%d][%d]:", i, j), err_msg, false);
            }
        }
        
        System.gc();
    }
    private static void Mtx_print(int[][] matrix)
    {
        Mtx_print(matrix, "");
    }
    private static void Mtx_print(int[][] matrix, String msg)
    {
        if(!msg.equals("")) System.out.println(msg);
        for(int i = 0; i<matrix.length; i++)
        {
            for(int j = 0; j<matrix[i].length; j++)
            {
                System.out.printf("[%d]", matrix[i][j]);
            }
            System.out.println("");
        }
    }
    private static void Mtx_printResult(int[][]resultMatrix, String operator)
    {
        System.out.println("-------- Result --------");
        Mtx_print(mtx_1);
        System.out.println(operator);
        Mtx_print(mtx_2);
        System.out.println("=");
        Mtx_print(resultMatrix);
    }
    private static void Mtx_Addition()
    {
        System.out.println("----- Addition -----");
                
        // Enter matrix
        Mtx_Enter();
        // PrintResult
        Mtx_printResult(additionMatrix(mtx_1, mtx_2), "+");
    }
    private static void Mtx_Subtraction()
    {
        System.out.println("----- Subtraction -----");
                
        // Enter matrix
        Mtx_Enter();
        // PrintResult
        Mtx_printResult(subtractionMatrix(mtx_1, mtx_2), "-");
        
    }
    private static void Mtx_Multiplication()
    {
        System.out.println("----- Multiplication -----");
                
        // Enter matrix
        Mtx_Enter(false);
        // PrintResult
        Mtx_printResult(multiplicationMatrix(mtx_1, mtx_2), "*");
    }
    
    // Processing methods
    public static int[][] additionMatrix (int[][]matrix1, int[][]matrix2)
    {
        int[][] ret = new int[matrix1.length][matrix1[0].length];
        for(int i = 0; i<matrix1.length; i++)
            for(int j = 0; j<matrix1[0].length; j++)
                ret[i][j] = matrix1[i][j] + matrix2[i][j];
        return ret;
    }
    public static int[][] subtractionMatrix (int[][] matrix1, int[][]matrix2)
    {
        int[][] ret = new int[matrix1.length][matrix1[0].length];
        for(int i = 0; i<matrix1.length; i++)
            for(int j = 0; j<matrix1[0].length; j++)
                ret[i][j] = matrix1[i][j] - matrix2[i][j];
        return ret;
    }
    public static int[][] multiplicationMatrix(int[][] matrix1, int[][]matrix2)
    {
        int[][] ret = new int[matrix1.length][matrix2[0].length];
        
        for(int i = 0; i<ret.length; i++)
            for(int j = 0; j<ret[0].length; j++)
                ret[i][j] = 0;
        
        for(int i = 0; i<ret.length; i++)
            for(int j = 0; j<ret[0].length; j++)
                for(int k = 0; k<matrix1[0].length; k++)
                {
                    ret[i][j] += matrix1[i][k] * matrix2[k][j];
                }
        return ret;
    }
}
