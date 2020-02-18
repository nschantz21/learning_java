// Homework5.java
// Nicholas Schantz
// 2020-02-18

import java.util.NoSuchElementException;

public class Homework5 {
    public static void main(String args[]) {
        Integer data[] = {0, 1, 2, 3, 4, 5, 6, 7};
        ChainedHashTable<Integer, Integer> myTable = 
            new ChainedHashTable<Integer, Integer>(3, 1.5, 2);
        
        for (int i = 0; i < data.length; i++) {
            myTable.insert(i, i);
            // after each insert report
            System.out.format(
                "buckets %d, elements %d, lf %.2f, max lf %.2f, resize multiplier %d%n",
                myTable.getBuckets(),
                myTable.getSize(),
                (float)myTable.getSize() / (float)myTable.getBuckets(),
                myTable.getMaxLoadFactor(),
                myTable.getResizeMultiplier()
            );
        }

        // look up element inserted before the resize
        System.out.println("key = 1, value = " + myTable.lookup(1));
        // look up element that does not exist in table
        try {
            System.out.println("key = 10, value = " + myTable.lookup(10));
        } catch (NoSuchElementException ex) {
            System.out.println(ex);
        }
    }
}
