import java.util.Scanner;

public class PC
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        System.out.print((a+b>c && a+c>b && b+c>a) ? "Valid" : "Invalid");

        in.close();
    }
}