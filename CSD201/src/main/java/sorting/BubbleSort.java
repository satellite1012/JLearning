package sorting;

import java.time.Duration;
import java.time.Instant;

public class BubbleSort
{
    static void bubbleSort(int[] arr)
    {
        int n = arr.length;
        int temp = 0;
        for(int i=0; i < n; i++)
        {
            for(int j=1; j < (n-i); j++)
            {
                if(arr[j-1] > arr[j])
                {
                    //swap elements
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
            printArray(arr, ">> Sorting index " + i);
        }
    }
    public static void main(String a[])
    { 
        Instant start = Instant.now();

        int[] arr1 = {8, 9, 7, 9, 3, 2, 3, 8, 4, 6};
        printArray(arr1, "Before Bubble Sort");
        bubbleSort(arr1);
        printArray(arr1, "After  Bubble Sort");

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
