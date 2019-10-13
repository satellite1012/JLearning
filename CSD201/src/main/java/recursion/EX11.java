package recursion;

class EX11
{
    public static void main(String[] args) {
        int n = 6, k = 4;
        System.out.print("s(" + n + "," +k+ ") = " + s(n, k));
    }
    static long s(int n, int k)
    {
        if(n<0 || k<0) return 0;
        if(k==0)
        {
            if(n==0) return 1;
            return 0;
        }
        return (s(n-1, k-1)-(n-1)*s(n-1, k));
    }
}