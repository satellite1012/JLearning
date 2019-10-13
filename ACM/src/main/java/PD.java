import java.util.Scanner;

public class PD
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String inp = in.nextLine();

        System.out.println(toDec(inp.substring(2, 4)) + " " + toDec(inp.substring(4, 6)) + " " + toDec(inp.substring(6, 8)));

        in.close();
    }
    static int toDec(String hex)
    {
        return Integer.parseInt(hex,16);
    }
}