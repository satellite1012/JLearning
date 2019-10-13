package sorting;

import java.time.Duration;
import java.time.Instant;

public class QuickSort
{
    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        
        return i+1;
    }
    static void quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            printArray(arr, ">> Sorting ", low, high);
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }
    public static void main(String a[])
    {
        Instant start = Instant.now();
        
        int[] arr1 = {8, 9, 7, 9, 3, 2, 3, 8, 4, 6};
        printArray(arr1, "Before Selection Sort", 0, 0);
        quickSort(arr1, 0, arr1.length-1);
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