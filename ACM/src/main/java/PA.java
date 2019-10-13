import java.util.Scanner;

public class PA
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int k = in.nextInt();

        if(p-k>1)
        {
            System.out.print("<< ");
        }
        for(int i = p-k; i<p; i++)
        {
            if(i>0) System.out.print(i + " ");
        }
        System.out.print("(" + p + ") ");
        for(int i = p+1; i<=p+k; i++)
        {
            if(i<=n) System.out.print(i + " ");
        }
        if(p+k < n)
        {
            System.out.println(">>");
        }
        in.close();
    }
}