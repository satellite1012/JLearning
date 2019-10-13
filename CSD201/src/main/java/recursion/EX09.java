package recursion;

class EX09
{
    public static void main(String[] args) {
        int n = 10;
        System.out.print("fib(" + n + ") = " + fib(n));
    }
    static long fib(int n)
    {
        return n>2 ? fib(n-1) + fib(n-2) : 1;
    }
}