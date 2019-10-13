package sorting;

import java.time.Duration;
import java.time.Instant;

public class MergeSort
{
    static void merge(int arr[], int l, int m, int r) 
    {
        int n1 = m - l + 1; 
        int n2 = r - m; 

        // temp array
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 

    static void mergeSort(int arr[], int l, int r) 
    { 
        if (l < r) 
        {
            printArray(arr, ">> Sorting ", l, r);
            int m = (l+r)/2;

            mergeSort(arr, l, m); 
            mergeSort(arr , m+1, r); 

            merge(arr, l, m, r); 
        }
    }
    public static void main(String a[])
    {
        Instant start = Instant.now();

        int[] arr1 = {8, 9, 7, 9, 3, 2, 3, 8, 4, 6};
        printArray(arr1, "Before Selection Sort", 0, 0);
        mergeSort(arr1, 0, arr1.length-1);
        printArray(arr1, "After  Selection Sort", 0, 0);
        
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
    }
    static void printArray(int[] arr, String msg, int low, int high)
    {
        String str = (high==0 && low==0) ? "" : (" - low: " + low + " high: " + high);
        System.out.print(msg + ": [ ");
        for (int a : arr)
        {
            System.out.print(a + " ");
        }
        System.out.println("]" + str);
    }
}  