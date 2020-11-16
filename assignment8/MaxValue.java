package assignment8;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MaxValue {
    static void generateRandomArray(int[] arr) {
        Random rd = new Random();//creating Random object
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(1000);
        }
    }

    static long max(int[] arr) {
        long result = 0;
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 4; i++) {
            final int remainder = i;
            try {
                result = Math.max(result, threadPool.submit(() -> Arrays.stream(arr).filter(n -> n % 4 == remainder).max()).get().getAsInt());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        threadPool.shutdown();
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[400];
        generateRandomArray(arr);
        long max=max(arr);
        System.out.println(max);
    }
}
