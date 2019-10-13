package sorting;

import java.time.Duration;
import java.time.Instant;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j; // Chỉ số của phần tử nhỏ nhất phía sau arr[i]
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
            printArray(arr, ">> Sorting index " + i);
        }
    }
    public static void main(String a[])
    {
        Instant start = Instant.now();

        int[] arr1 = {8, 9, 7, 9, 3, 2, 3, 8, 4, 6};
        printArray(arr1, "Before Selection Sort");
        selectionSort(arr1);
        printArray(arr1, "After  Selection Sort");
        
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