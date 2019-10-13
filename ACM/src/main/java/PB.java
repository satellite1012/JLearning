import java.math.BigInteger;
import java.util.Scanner;

public class PB
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String inp = in.nextLine();
        in.close();
        Scanner is = new Scanner(inp);
        
        BigInteger sum = new BigInteger("0");
        int n = 0;

        while(is.hasNextInt())
        {
            n = is.nextInt();
            sum = sum.add(new BigInteger(String.valueOf(n)));
        }
        System.out.println(sum.toString());

        is.close();
    }
}