import java.util.Scanner;

public class PU
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        String std = in.nextLine();
        char[] arr_std = std.toCharArray();

        for(int j = 0; j<k; j++)
        {
            int i = 0;
            while(i<n-1)
            {
                if(arr_std[i]=='B' && arr_std[i+1]=='G')
                {
                    arr_std[i] = 'G';
                    arr_std[i+1] = 'B';
                    i += 2;
                } else i++;
            }
        }
        
        System.out.print(String.copyValueOf(arr_std));

        in.close();
    }
}