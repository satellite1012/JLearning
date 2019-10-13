import java.util.Scanner;

public class PT
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];

        for(int i=0; i<n; i++)
        {
            arr[i] = in.nextInt();
        }

        int max_inc = 1;
        int tmp_inc = 1;
        int i = 1;

        while(i<n)
        {
            if(arr[i]>arr[i-1])
            {
                tmp_inc++;
                max_inc = max_inc<tmp_inc ? tmp_inc : max_inc;
            } else tmp_inc = 1;
            i++;
        }

        System.out.print(max_inc);
        in.close();
    }
}