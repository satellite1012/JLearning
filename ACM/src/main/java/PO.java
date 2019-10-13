// The sum of the first N positive integers.
// S2 = The sum of the first N odd integers.
// S3 = The sum of the first N even integers

import java.util.Scanner;

public class PO
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int data[][] = new int[n][2];

        for(int i=0; i<n; i++)
        {
            data[i][0] = in.nextInt();
            data[i][1] = in.nextInt();
        }

        for(int index=0; index<n; index++)
        {
            long sum_1 = 0;
            long sum_2 = 0;
            long sum_3 = 0;
            for(int i = 1; i<=data[index][1]; i++)
            {
                sum_1 += i;
                sum_2 += i*2-1;
                sum_3 += i*2;
            }
            System.out.println(data[index][0] + " " + sum_1 + " " + sum_2 + " " + sum_3);
        }
        in.close();
    }
}