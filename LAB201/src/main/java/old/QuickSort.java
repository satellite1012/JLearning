// package old;

// import java.util.*;

// public class QuickSort
// {
//     static int arr[];
//     static int n;
    
//     static void QuickSort(int L, int R)
//     {
//         if (L>=R) return;
        
//         int tmp, i=L, j=R;
//         int mid = (L+R)/2;
//         int pivot = arr[mid];
        
//         while(i<=j)
//         {
//             while(arr[i]<pivot)
//             {
//                 i++;
//             }
//             while(arr[j]>pivot)
//             {
//                 j--;
//             }
//             if(i<=j)
//             {
//                 tmp = arr[i];
//                 arr[i] = arr[j];
//                 arr[j] = tmp;
//                 i++;
//                 j--;
//             }
//         }
//         QuickSort(L, j);
//         QuickSort(i, R);
//     }
    
//     public static void main(String[] args)
//     {
//         Random rand = new Random();
//         Scanner in = new Scanner(System.in);
        
//         System.out.println("Enter number of array: ");
//         n = in.nextInt();
//         arr = new int[n];
        
//         System.out.print("Array:\n[ ");
//         for(int i = 0; i<n; i++)
//         {
//             arr[i] = rand.nextInt(n);
//             System.out.print(arr[i] + " ");
//         }
//         System.out.print("]");
        
//         QuickSort(0, n-1);
        
//         System.out.print("\nArray after sorted:\n[ ");
//         for(int i = 0; i<n; i++)
//         {
//             System.out.print(arr[i] + " ");
//         }
//         System.out.print("]");
//         in.close();
//     }
// }
