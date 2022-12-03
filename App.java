import java.io.BufferedWriter;
import java.io.FileWriter;

public class App 
{
    public static void main(String[] args) throws Exception
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Result.txt"));
        final int TIMES = 20;
        final int LIMIT = 1000000;

        Test t;
        Select_kth_1 s1;
        Select_kth_2 s2;
        Select_kth_3 s3;
        Select_kth_4 s4;

        int n = 10;
        //store run time of 3 Algo
        long result[] = new long[4];
        int[] target = {1, n * 1/4, n * 2/4, n * 3/4, n};
        boolean flag = true;

        while (n <= LIMIT)
        {
            t = new Test(n);

            for (int k : target)
            {
                s1 = new Select_kth_1(t.arr.clone());
                s2 = new Select_kth_2(t.arr.clone());
                s3 = new Select_kth_3(t.arr.clone());
                s4 = new Select_kth_4(t.arr.clone(), k);

                for (int i = 1; i <= TIMES; i++) 
                {
                    result[0] += s1.solve(k);
                    result[1] += s2.solve(k);
                    result[2] += s3.solve(k);
                    result[3] += s4.solve(k);
                }
            }

            writer.write("n = " + n + ":\n");
            writer.write("Aglo 1: " + result[0] + "\n");
            writer.write("Aglo 2: " + result[1] + "\n");
            writer.write("Aglo 3: " + result[2] + "\n");
            writer.write("Aglo 4: " + result[2] + "\n");

            if(flag) n *= 5;
            else n *= 2;
            flag = !flag;
        }
        writer.close();
    }    
}
