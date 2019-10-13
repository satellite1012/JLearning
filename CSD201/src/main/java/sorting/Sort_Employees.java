package sorting;

import java.time.Duration;
import java.time.Instant;

class Employees implements Comparable<Employees>
{
    private String id;
    private String name;
    private int level;

    public Employees() {
        this("NULL", "Demo Name", 10);
    }
    public Employees(String id, String name, int level)
    {
        this.id = id;
        this.name = name;
        this.level = level;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }
    
    @Override
    public int compareTo(Employees o)
    {
        // System.out.println("Compare: " + this.id.compareTo(o.getId()));
        return this.id.compareTo(o.getId());
    }
}

public class Sort_Employees
{
    private static Employees[] arrEmployees;
    private static int countSwap;

    public static void main(String[] args)
    {
        Instant start = Instant.now();
        newEmployees(); countSwap = 0; printArr("");
        
        // Sorting methods
        // Please uncomment each method to test it;

        // Part 1
        // insertionSort(arrEmployees);
        // selectionSort(arrEmployees);
        // bubbleSort(arrEmployees);

        // Part 2
        // heapSort(arrEmployees);
        quickSort(arrEmployees, 0, arrEmployees.length-1);
        // mergeSort(arrEmployees, 0, arrEmployees.length-1);


        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        
        String output = " >> Time taken: " + timeElapsed.toNanos() +" nanoseconds";
        output += "\n >> Total " + countSwap + " assigns to array of Employees.";
        printArr(output);
    }
    private static void merge(Employees arr[], int l, int m, int r) 
    {
        int n1 = m - l + 1; 
        int n2 = r - m; 

        Employees L[] = new Employees [n1]; 
        Employees R[] = new Employees [n2]; 
  
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i].compareTo(R[j]) <= 0)
            {
                arr[k] = L[i];
                countSwap++;
                i++;
            }
            else
            {
                arr[k] = R[j];
                countSwap++;
                j++;
            }
            k++; 
        } 
  
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            countSwap++;
            i++; 
            k++; 
        } 
  
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            countSwap++;
            j++; 
            k++; 
        } 
    } 
    static void mergeSort(Employees arr[], int l, int r) 
    { 
        if (l < r) 
        {
            int m = (l+r)/2;

            mergeSort(arr, l, m); 
            mergeSort(arr , m+1, r); 

            merge(arr, l, m, r); 
        }
    }

    private static int partition(Employees arr[], int low, int high)
    {
        Employees pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (arr[j].compareTo(pivot) <= 0)
            {
                i++;
                Employees temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                countSwap += 2;
            }
        }
        
        Employees temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        countSwap += 2;
        
        return i+1;
    }
    private static void quickSort(Employees arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    static void heap(Employees arr[], int n, int i) 
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
  
        if (l < n && arr[l].compareTo(arr[largest]) > 0)
            largest = l;
  
        if (r < n && arr[r].compareTo(arr[largest]) > 0) 
            largest = r;
  
        if (largest != i) 
        {
            Employees swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
            countSwap += 2;
  
            heap(arr, n, largest); 
        }
    }
    // private static void heapSort(Employees arr[])
    // { 
    //     int n = arr.length; 

    //     for (int i = n / 2 - 1; i >= 0; i--) 
    //         heap(arr, n, i); 
        
    //     for (int i=n-1; i>=0; i--) 
    //     {
    //         Employees temp = arr[0]; 
    //         arr[0] = arr[i]; 
    //         arr[i] = temp; 
  
    //         heap(arr, i, 0); 
    //     } 
    // }

    // private static void bubbleSort(Employees[] arr)
    // {
    //     int n = arr.length;
    //     Employees temp;

    //     for(int i=0; i < n; i++)
    //     {
    //         for(int j=1; j < (n-i); j++)
    //         {
    //             if(arr[j-1].compareTo(arr[j]) > 0)
    //             {
    //                 temp = arr[j-1];
    //                 arr[j-1] = arr[j];
    //                 arr[j] = temp;
    //                 countSwap += 2;
    //             }
    //         }
    //     }
    // }
    // private static void selectionSort(Employees[] arr)
    // {
    //     for (int i = 0; i < arr.length - 1; i++) {
    //         int index = i;
    //         for (int j = i + 1; j < arr.length; j++) {
    //             if (arr[j].compareTo(arr[index]) < 0) {
    //                 index = j;
    //             }
    //         }
    //         Employees smallerNumber = arr[index];
    //         arr[index] = arr[i];
    //         arr[i] = smallerNumber;
    //         countSwap += 2;
    //     }
    // }
    // private static void insertionSort(Employees[] arr)
    // {
    //     int n = arr.length;
    //     for (int j = 1; j < n; j++)
    //     {
    //         Employees key = arr[j];
    //         int i = j-1;
    //         while ((i > -1) && (arr[i].compareTo(key)>0))
    //         {
    //             arr[i+1] = arr[i];
    //             countSwap++;
    //             i--;
    //         }
    //         arr[i+1] = key;
    //         countSwap++;
    //     }
    // }
    private static void newEmployees()
    {
        arrEmployees = new Employees[]
        {
            new Employees("A05", "Tran Quang", 7),
            new Employees("A03", "Nguyen An", 7),
            new Employees("A01", "Truong Phung", 5),
            new Employees("A04", "Pham Thi Lam", 2),
            new Employees("A02", "Do Trung Ton", 5)
        };
    }
    private static void printArr(String msg)
    {
        printArr(arrEmployees, msg);
    }
    private static void printArr(Employees[] arr, String msg)
    {
        if(!msg.isEmpty()) System.out.println(msg);
        System.out.println("====== Array at the momment ======");
        for (Employees em : arrEmployees)
        {
            System.out.println(em.getId() + "\t" + em.getName() + "\t" + em.getLevel());
        }
    }
}