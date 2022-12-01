import java.util.Random;
import java.util.function.IntPredicate;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Test
{
    final int MAX = 999999;
    private int arr[];
    private int size;
    private Random rand;

    public int[] getArr() 
    {
        return arr;
    }
    
    public int getSize() 
    {
        return size;
    }
    public Test(int size) 
    {
        rand = new Random();
        this.size = size;
        arr = new int[this.size];
        for (int i = 0; i < this.size; i++) 
        {
            arr[i] = rand.nextInt(1, MAX);
        }
    } 
}
