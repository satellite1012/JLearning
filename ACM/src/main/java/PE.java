import java.util.Scanner;

public class PE
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = 4;

        System.out.print(C(n, k));

        in.close();
    }
    static long C(int n, int k)
    {
        if (k == 0) return 1;
        return (n * C(n - 1, k - 1)) / k;
    }
}