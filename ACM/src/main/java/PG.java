import java.util.Scanner;

public class PG
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String cen = in.nextLine();
        String inp = in.nextLine();

        String arr_cen[] = cen.split("\\s",0);
        
        for (String cen_words : arr_cen)
        {
            inp = inp.replaceAll(cen_words, replace(cen_words));
        }

        System.out.print(inp);
        in.close();
    }
    static String replace(String s)
    {
        char chr[] = s.toCharArray();
        for(int i = 1; i<chr.length; i++)
        {
            chr[i] = '*';
        }
        return String.copyValueOf(chr);
    }
}