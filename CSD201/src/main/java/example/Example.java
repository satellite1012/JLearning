package example;

public class Example
{
    static int count = 0;
    public static void main(String[] args)
    {
        thaphn(4, "A", "B", "C");
    }
    static void thaphn(int n, String nguon, String dich, String tg)
    {
        if (n==1)
        {
            System.out.println("Di chuyen dia tu " + nguon + " sang " + dich);
        }
        else
        {   // di chuyen n-1 dia tu cot nguon sang cot trung gian
            // di chuyen dia tu cot nguon sang cot trung gian, dich se thanh cot trung gian trong lan toi
            thaphn(n-1, nguon, tg, dich);
            thaphn(1, nguon, dich, tg);
            thaphn(n-1, dich, nguon, tg);
        }
    }
}