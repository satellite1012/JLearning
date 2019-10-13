package recursion;

class EX06
{
    public static void main(String[] args)
    {
        int a = 9, b = 6;

        System.out.print("The Greatest Common Divisor of " + a + " and " + b + " is: " + GCD(a,b));
    }
    static int GCD(int a, int b)
    {
        if(b<=0) return a;
        return GCD(b, a%b);
    }
}