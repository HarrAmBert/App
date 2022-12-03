
public class Select_kth_3 
{
    private int arr[];

    public Select_kth_3(int[] arr) 
    {
        this.arr = arr;
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
    void quickSort( int begin, int end) 
    {
        if (begin < end) 
        {

            int pi = partition(begin, end);

            quickSort(begin, pi - 1);
            quickSort(pi + 1, end);
        }
    }
    int partition(int begin, int end) 
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
