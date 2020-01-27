//---------------------------------------------------------------------------
// Homework1.java
//---------------------------------------------------------------------------
import java.time.LocalDateTime;
import java.util.Random;
import java.io.*;

public class Homework1 {
    static int[] insert(int array[], int index, int value) {
        // create new array one larger than original array
        int[] newArray = new int[array.length + 1];                    // O(1)
        // copy elements up to insert point from original array to new array
        for (int curr_index = 0; curr_index < index; curr_index++) {   // O(n)
            newArray[curr_index] = array[curr_index];                  // O(1)
        }
        // place insert value into new array
        newArray[index] = value;                                       // O(1)
        // copy elements after insert point from original array to new array
        for (int sec_idx = index; sec_idx < array.length; sec_idx++) { // O(n)
            newArray[sec_idx + 1] = array[sec_idx];                    // O(1)
        }
        return newArray;                                               // O(1)
    }

    public static void main(String[] args) {
        int NUM_READINGS = 60;
        int INSERTS_PER_READING = 1000;

        int[] array = new int[1];
        Random random = new Random(); // set random seed

        // print table headers
        System.out.println("Array length\tSeconds per insert");

        // take NUM_READINGS readings
        for (int cnt = 0; cnt < NUM_READINGS; cnt++) {
            
            // each reading will be taken adter INSERTS_PER_READING inserts
            long startTime = System.currentTimeMillis();
            
            for (int insrts = 0; insrts < INSERTS_PER_READING; insrts++) {
                int index = random.nextInt(array.length);
                int value = random.nextInt();
                array = Homework1.insert(array, index, value);
            }

            long stopTime = System.currentTimeMillis();
            float timePerInsert = (stopTime - startTime) / (float)INSERTS_PER_READING;
            
            // output reading in tabular format
            System.out.format("%12d %21.10f\n", array.length, timePerInsert);
        }
        return;
    }
}