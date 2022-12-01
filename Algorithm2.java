public class Algorithm2
{
    public int arr[];

    public Algorithm2(int a[]) 
    {
        this.arr = a;
    }

	public int kBiggest(int k)
	{
		return arr[quickSort(0, arr.length - 1, k) - 1];
	}
	
    private int quickSort(int begin, int end, int k) 
	{
	    if (begin < end) 
	    {
	        int partitionIndex = partition(begin, end);
			if(k == partitionIndex) return partitionIndex;

	        int a = quickSort(begin, partitionIndex - 1, k);
	        int b = quickSort(partitionIndex + 1, end, k);

			if(a != -1) return a;
			if (b != -1) return b;
	    }
		return -1;
	}
    private int partition(int begin, int end) 
	{
	    int pivot = arr[end];
	    int i = (begin-1);

	    for (int j = begin; j < end; j++) 
        {
	        if (arr[j] <= pivot) 
            {
	            i++;

	            int swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }
			
	    int swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;

	    return i+1;
	}
}
