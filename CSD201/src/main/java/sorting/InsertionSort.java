package sorting;

import java.time.Duration;
import java.time.Instant;

public class InsertionSort
{  
    public static void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int j = 1; j < n; j++)
        {
            int key = arr[j];
            int i = j-1;
            while ( (i > -1) && ( arr[i] > key ) )
            {
                arr[i+1] = arr[i];
                i--;
            }
            arr[i+1] = key;
            printArray(arr, ">> Sorting index " + j);
        }
    }
    public static void main(String a[])
    {
        Instant start = Instant.now();

        int[] arr1 = {8, 9, 7, 9, 3, 2, 3, 8, 4, 6};
        printArray(arr1, "Before Insertion Sort");
        insertionSort(arr1);
        printArray(arr1, "After  Insertion Sort");
        
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
    }
    static void printArray(int[] arr, String msg)
    {
        System.out.print(msg + ": [ ");
        for (int a : arr)
        {
            System.out.print(a + " ");
        }
        System.out.println("]");
    }
}  