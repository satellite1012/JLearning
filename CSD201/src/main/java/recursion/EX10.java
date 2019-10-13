package recursion;

class EX10
{
    public static void main(String[] args)
    {
        int n = 10;
        System.out.print("addReciprocals(" + n + ") = " + addReciprocals(n));
    }
    static double addReciprocals(int n)
    {
        return (n<1 ? 0 : 1.0/n + addReciprocals(n-1));
    }
}