import java.time.LocalDateTime;
import java.util.Random;
import java.io.*;

class Homework1() {
    static int[] insert(int array[], int index, int value) {
        // create new array one larger than original array
        newArray = new int[array.length + 1];
        // copy elements up to insert point from original array to new array
        for (int curr_index = 0; curr_index < index; curr_index++) {
            newArray[curr_index] = array[curr_index];
        }
        // place insert value into new array
        newArray[index] = value;
        // copy elements after insert point from original array to new array
        for (int sec_indx = index; sec_indx < array.length; sec_index++) {
            newArray[sec_index + 1] = array[sec_index];
        }
        return newArray;
    }

    int main() {
        NUM_READINGS = 60;
        INSERTS_PER_READING = 1000;

        array = new int[1];
        Random random = new Random(); // set random seed

        // print table headers
        System.out.println("Array length\tSeconds per insert");

        // take NUM_READINGS readings
        for (int cnt = 0; cnt < NUM_READINGS; cnt++) {
            
            // each reading will be taken adter INSERTS_PER_READING inserts
            start_time = LocalDateTime.now(); // current time
            
            for (int insrts = 0; insrts < INSERTS_PER_READING; insrts++) {
                int index = random.nextInt(array.length);
                int value = random.nextInt();
                int array = Homework1(array, index, value);
            }

            stopTime = LocalDateTime.now();
            timePerInsert = (stopTime - startTime) / INSERTS_PER_READING;
            
            // output reading in tabular format
            //System.out.println(array.length + " " + timePerInsert);
            System.out.format("%12d %12.6f\n", array.length, timePerInsert);
        }
    }
}