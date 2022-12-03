import java.lang.annotation.Target;

public class Select_kth_4
{
    private int arr[];
    private int targetPos;
    
    public Select_kth_4(int[] arr, int targetPos) 
    {
        this.arr = arr;
        this.targetPos = targetPos;
    }
    public long solve(int k)
    {
        
        long start = System.currentTimeMillis();
        quickSort(0, arr.length - 1);
        long end = System.currentTimeMillis();
        //result from the search
        //int result = solver.arr[k - 1];
        
        return end - start;
    }
    private int quickSort( int begin, int end) 
    {
        if (begin < end) 
        {

            int partitionIndex = partition(begin, end);
            if(partitionIndex == targetPos - 1) return partitionIndex -1;
            
            int lower = quickSort(begin, partitionIndex - 1);
            if(lower == targetPos - 1) return lower;

            int higher = quickSort(partitionIndex + 1, end);
            if(higher == targetPos - 1) return higher;
        }
        return -1;
    }
    private int partition(int begin, int end) 
    {
        int pivot = arr[end];
        int i = (begin - 1); 
        for (int j = begin; j < end; j++) 
        {
            if (arr[j] < pivot) 
            {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        return i + 1;
    }

}
