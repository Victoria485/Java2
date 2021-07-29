package Homework5;
import java.util.Arrays;
public class Homework5
{
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr1 = new float[size];
    static float[] arr2 = new float[size];
    public static void main(String[] args) throws InterruptedException
    {
        thread1();
        thread2();
        System.out.println(Arrays.equals(arr1, arr2));
    }
    static void thread1()
    {
        Arrays.fill(arr1, 1);
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr1.length; i++)
        {
            arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("1 поток:" + (System.currentTimeMillis() - a));
    }
    static void thread2() throws InterruptedException
    {
        Arrays.fill(arr2, 1);
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        long a = System.currentTimeMillis();
        System.arraycopy(arr2, 0, a1, 0, h);
        System.arraycopy(arr2, h, a2, 0, h);
        Thread t1 = new Thread(() ->
        {
            for (int i = 0; i < a1.length; i++)
            {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread t2 = new Thread(() ->
        {
            for (int i = 0; i < a2.length; i++)
            {
                a2[i] = (float)(a2[i] * Math.sin(0.2f + (i+h) / 5) * Math.cos(0.2f + (i+h) / 5) * Math.cos(0.4f + (i+h) / 2));
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.arraycopy(a1, 0, arr2, 0, h);
        System.arraycopy(a2, 0, arr2, h, h);
        System.out.println("2 потока:" + (System.currentTimeMillis() - a));
    }
}