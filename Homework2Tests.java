// Homework2Tests.java
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class SinglyLinkedListTests {
    private SinglyLinkedList<Double> list;

    @BeforeMethod
    public void beforeMethod() {
        list = new SinglyLinkedList<Double>();
    }

    
    @Test
    public void getSize_EmptyList() {
        assertEquals(list.getSize(), 0);
    }

    public void RunTestCase(double [] coefs, double x) {
        // create
        for i in coefs:
            list.appendTerm(list, i);
            assertEquals(list.getTail(), i);
        // display
        SinglyLinkedList.display(list);
        // evaluate
        double result = SinglyLinkedList.evaluate(list, x);
    }

    @Test
    public void TestCase1() {
        double[] coefs = {1.0, 1.0};
        double x = 1.0;
        RunTestCase(coefs, x);
    }

    @Test
    public void TestCase2() {
        double[] coefs = {1.0, 0.0, -1.0};
        double x = 2.03;
        RunTestCase(coefs, x);
    }

    @Test
    public void TestCase3() {
        double[] coefs = {-3.0, 0.5, -2.0, 0.0};
        double x = 05.0;
        RunTestCase(coefs, x);
    }
    @Test
    public void TestCase4() {
        double[] coefs = {-0.3125, 0.0, -9.915, -7.75, -40.0}
        double x = 123.45;
        RunTestCase(coefs, x);
    }
}