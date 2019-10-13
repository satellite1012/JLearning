package recursion;

class EX01
{
    public static void main(String[] args)
    {
        int n = 10;
        System.out.println("Sum from 1 to " + n + " is: " + Sum(n));
    }
    static int Sum(int n)
    {
        if (n==1) return 1;
        return n + Sum(n-1);
    }
}