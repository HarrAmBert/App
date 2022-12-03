
public class Select_kth_2
{
    public int arr[];

    public Select_kth_2(int a[]) 
    {
        this.arr = a;
    }

	public long solve(int k)
    {
        long start = System.currentTimeMillis();
        quickSortIterative(0, arr.length - 1);
        long end = System.currentTimeMillis();
		//result from the search
		//int result = solver.arr[k]

        return end - start;
    }
	
    private int partition(int begin, int end)
    {
        int pivot = arr[end];
 
        int i = (begin - 1);
        for (int j = begin; j <= end - 1; j++) 
        {
            if (arr[j] <= pivot) 
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
 
    private void quickSortIterative(int begin, int end)
    {
        int[] stack = new int[end - begin + 1];
 
        int top = -1;
 
        stack[++top] = begin;
        stack[++top] = end;
 
        while (top >= 0) 
        {
            end = stack[top--];
            begin = stack[top--];
            int partitionIndex = partition(begin, end);
 
    
            if (partitionIndex - 1 > begin) {
                stack[++top] = begin;
                stack[++top] = partitionIndex - 1;
            }

            if (partitionIndex + 1 < end) 
            {
                stack[++top] = partitionIndex + 1;
                stack[++top] = end;
            }
        }
    }
}