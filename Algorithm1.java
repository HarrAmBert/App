public class Algorithm1
{
    public int arr[];

    public Algorithm1(int a[]) 
    {
        this.arr = a;
    }

    public int kBiggest(int k)
    {
        this.mergeSort(0, arr.length - 1);
        return arr[k - 1];
    }

	private void mergeSort(int l, int r) 
	{
        if (l < r) 
		{
            int m = (l + r) / 2;

            mergeSort(l, m);
            mergeSort(m + 1, r);

            merge(l, m, r);
        }
    }

    private void merge(int l, int m, int r) 
	{

        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
        {
			L[i] = arr[l + i];
		}
        for (int j = 0; j < n2; ++j)
        {
			R[j] = arr[m + 1 + j];
		}

        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) 
		{
            if (L[i] <= R[j]) 
			{
                arr[k] = L[i];
                i++;
            } else 
			{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) 
		{
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) 
		{
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
