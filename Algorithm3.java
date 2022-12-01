import java.util.Arrays;

public class Algorithm3 
{
    int arr[];

    public Algorithm3(int arr[]) 
    {
        this.arr = arr;
    }
    public int kBiggest(int k)
    {
        quickSort(0, arr.length - 1);
        return arr[k - 1];
    }
    private void quickSort(int begin, int end) 
    {
        if (begin < end) 
        {
            int n = end - begin + 1;

            int med = kSmallest(begin, end, n / 2);

            int p = partition(begin, end, med);

            quickSort(begin, p - 1);
            quickSort(p + 1, end);
        }
    }

    private int findMedian(int begin, int end) 
    {
        Arrays.sort(arr, begin, end);
        return arr[arr.length / 2]; 
    }

    private int kSmallest(int begin, int end, int k)
    {
        if (k > 0 && k <= end - begin + 1)
        {
            int n = end-begin+1;
            int i;
            Algorithm3 median = new Algorithm3(new int [(n + 4) / 5]); 
            
            for (i=0; i<n/5; i++)
            {
                median.arr[i] = findMedian(begin + i * 5, begin + i * 5 + 5);
            }
            
            if (i*5 < n) 
            {
                median.arr[i] = findMedian(begin + i * 5, begin + i * 5 + n % 5);
                i++;
            }
            
            int medOfMed = (i == 1)? median.arr[i - 1]: kSmallest(0, i - 1, i / 2);
            int partitionIndex = partition(begin, end, medOfMed);
    
            if (partitionIndex - begin == k - 1)
            {
                return arr[partitionIndex];
            }
            if (partitionIndex - begin > k - 1) 
            {
                return kSmallest(begin, partitionIndex - 1, k);
            }
    
            return kSmallest(partitionIndex + 1, end, k - partitionIndex + begin - 1);
        }
        return Integer.MAX_VALUE;
    }

    private int partition(int begin, int end, int x)
    {
        int i, swapTemp;
        for (i = begin; i < end; i++)
        {
            if (arr[i] == x)
            break;
        }
        swapTemp = arr[i];
        arr[i] = arr[end];
        arr[end] = swapTemp;
    
        i = begin;
        for (int j = begin; j <= end - 1; j++)
        {
            if (arr[j] <= x)
            {
                swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
                i++;
            }
        }
        swapTemp = arr[i];
        arr[i] = arr[end];
        arr[end] = swapTemp;
        return i;
    }
}
