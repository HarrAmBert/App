import java.util.Random;

public class Test
{
    final int MAX = 999999;
    public int arr[];
    public  int size;
    private Random rand;

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
