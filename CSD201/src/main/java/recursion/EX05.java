package recursion;

class EX05
{
    public static void main(String[] args)
    {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = 10;
        int target = 5;

        System.out.print("The target " + target + " is at " + BinarySearch(arr, n, target));
        
    }

    static int BinarySearch(int a[], int n, int target)
    {
        return BinarySearch(a, 0, n-1, target);
    }
    static int BinarySearch(int a[], int l, int r, int k) //Su dung de quy
    {
        if (l > r) return -1;
        int mid = (l+r)/2;
        if (a[mid]<k) return BinarySearch(a, mid+1, r, k);
            else if (a[mid]>k) return BinarySearch(a, l, mid-1, k);
                else return mid;
    }
}