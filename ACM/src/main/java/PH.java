import java.util.Scanner;

public class PH
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String inp = in.nextLine();

        try
        {
            System.out.print(toDec(inp));
        }catch(Exception e)
        {
            System.out.print("ERROR!");
        }

        in.close();
    }
    static int toDec(String bin)
    {
        return Integer.parseInt(bin, 2);
    }
}