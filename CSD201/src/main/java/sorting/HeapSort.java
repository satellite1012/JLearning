package sorting;

import java.time.Duration;
import java.time.Instant;

public class HeapSort
{
    static public void heapSort(int arr[]) 
    { 
        int n = arr.length; 

        for (int i = n / 2 - 1; i >= 0; i--) 
            heap(arr, n, i); 
        
        for (int i=n-1; i>=0; i--) 
        {
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            heap(arr, i, 0); 
        } 
    } 

    static void heap(int arr[], int n, int i) 
    {
        printArray(arr, ">> Sorting ", 0, 0);

        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
  
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            heap(arr, n, largest); 
        } 
    } 
    public static void main(String a[])
    {
        Instant start = Instant.now();

        int[] arr = {89, 79, 32, 38, 46, 26, 43, 38, 32, 79};
        printArray(arr, "Before Heap Sort", 0, 0);
        heapSort(arr);
        printArray(arr, "After  Heap Sort", 0, 0);
        
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