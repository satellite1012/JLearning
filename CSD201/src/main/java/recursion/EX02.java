package recursion;

class EX02
{
    public static void main(String[] args)
    {
        int arr[] = {6, 5, 8, 9, 7, 3, 1, 2, 3, 4};
        int n = 10;

        System.out.print("Min value in array is: " + findmin(arr, n));
    }
    static int findmin(int a[], int n)
    {
        if(n==1) return a[0];
        return min(a[n-1], findmin(a, n-1));
    }
    static int min(int a, int b)
    {
        return a<b ? a : b;
    }
}