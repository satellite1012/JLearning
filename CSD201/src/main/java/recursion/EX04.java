package recursion;

class EX04
{
    public static void main(String[] args)
    {
        char arr[] = {'L', 'E', 'V', 'E', 'L'};
        int n = 5;

        System.out.print("The string " + (ispalindrome(arr, n)==1 ? "is" : "is not") + " palindrome.");
    }

    public static int ispalindrome(char a[], int n)
    {
        return (n!=0 && ispalindrome(a, n, 0)) ? 1 : 0;
    }
    public static boolean ispalindrome(char a[], int n, int i)
    {
        if(i>=n/2) return true;
        return (a[i]==a[n-i-1]) && ispalindrome(a, n, i+1);
    }
}