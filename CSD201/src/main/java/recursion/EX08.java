package recursion;

class EX08
{
    public static void main(String[] args)
    {
        int n = 5;
        System.out.print(n + "! = " + fact(n));
    }
    static long fact(int n)
    {
        return (n>1 ? n*fact(n-1) : 1);
    }
}