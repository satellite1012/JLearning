import java.util.Scanner;

public class PS
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String str_1 = in.nextLine();
        String str_2 = in.nextLine();

        int count = str_1.length() * str_2.length();

        String tmp;
        if(str_1.length()<str_2.length())
        {
            tmp = str_1;
            str_1 = str_2;
            str_2 = tmp;
        }
        for(int i = 1; i<str_1.length(); i++)
        {
            for(int j = 0; j<str_2.length()-1; j++)
            {
                if(str_1.charAt(i)==str_2.charAt(j)) count--;
            }
        }

        System.out.print(count);
        in.close();
    }
}