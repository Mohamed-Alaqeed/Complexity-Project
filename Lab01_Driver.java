package Lab01;

import java.util.Random;

public class Lab01_Driver {

    // Method to fill array with random numbers between min and max (inclusive)
    public static void fillArrayRandom(int[] arr, int min, int max) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(max - min + 1) + min;  
        }
    }
    static int baseSize = 10000; // starting array size
    static int iterations = 10;  // number of times we double
}
