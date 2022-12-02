import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DecimalFormat;

public class App 
{
    public static void main(String[] args) throws Exception
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Result.txt"));
        final DecimalFormat df = new DecimalFormat("0.00");
        final int TIMES = 10;
        final int LIMIT = 100000;

        Test t;
        Algorithm1 a1;
        Algorithm2 a2;
        Algorithm3 a3;

        int n = 10;
        //store run time of 3 Algo
        long result[] = new long[3];
        int[] target = {1, n * 1/4, n * 2/4, n * 3/4, n};
        boolean flag = true;
        while (n <= LIMIT)
        {
            t = new Test(n);

            for (int k : target)
            {
                a1 = new Algorithm1(t.arr);
                a2 = new Algorithm2(t.arr);
                a3 = new Algorithm3(t.arr);
                
                for (int i = 1; i <= TIMES; i++) 
                {
                    result[0] += a1.solve(k);
                    result[1] += a2.solve(k);
                    result[2] += a3.solve(k);
                }
            }

            writer.write("n = " + n + ":\n");
            writer.write("Aglo 1: " + df.format(result[0] / (TIMES * target.length)) + "\n");
            writer.write("Aglo 2: " + df.format(result[1] / (TIMES * target.length)) + "\n");
            writer.write("Aglo 3: " + df.format(result[2] / (TIMES * target.length)) + "\n");

            if(flag) n *= 5;
            else n *= 10;
            flag = !flag;
        }
        writer.close();
    }    
}
