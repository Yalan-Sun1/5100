package assignment7;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SumValue {
    /*generate array of random numbers*/
    static void generateRandomArray(int[] arr){
        Random rd=new Random();//creating Random object
        for (int i = 0; i < arr.length; i++) {
            arr[i]=rd.nextInt();
        }

    }
    /*get sum of an array using 4 threads*/
    static long sum(int[] arr){
        long result = 0;
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i <4 ; i++) {
            final int remainder = i;
            try {
                result+=(int) threadPool.submit(()->Arrays.stream(arr).filter(n->n%4==remainder).sum()).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        threadPool.shutdown();
        return result;
    }

    public static void main(String[] args){
        int[] arr = new int[4000000];
        generateRandomArray(arr);
        long sum = sum(arr);
        System.out.println("Sum: " + sum);
    }
}
