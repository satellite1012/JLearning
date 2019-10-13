package recursion;

class EX03
{
    public static void main(String[] args)
    {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = 10;

        System.out.print("Min value in array is: " + findsum(arr, n));
    }
    static int findsum(int a[], int n)
    {
        if(n==1) return a[0];
        return a[n-1] + findsum(a, n-1);
    }
}