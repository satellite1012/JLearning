package recursion;

class EX07
{
    public static void main(String[] args) 
    {
        int x = 4, n = 5;

        System.out.print("x^n = " + power(x, n));
    }
    static long power(int x, int n)
    {
        return (n<=0 ? 1 : x*power(x, n-1));
    }
}