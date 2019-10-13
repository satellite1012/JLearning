import java.util.Scanner;

public class PJ
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String inp = in.nextLine();
        int len = inp.length();
        in.close();
        
        for(int i=0; i<len/2; i++)
        {
            if(inp.charAt(i)!=inp.charAt(len-i-1))
            {
                System.out.print("0");
                return;
            }
        }
        System.out.print("1");

    }
}