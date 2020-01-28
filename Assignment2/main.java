import java.io.*;

public class main {
    public static void main(String[] args) {
        // test case 1
        SinglyLinkedList<Double> list1;
        list1 = new SinglyLinkedList<Double>();
        Double[] coefficients1 = {1.0, 1.0};
        double x1 = 1.0;
        // append
        for (int coef = 0; coef < coefficients1.length; coef++) {
            SinglyLinkedList.appendTerm(list1, coefficients1[coef]);
        }
        // display
        SinglyLinkedList.display(list1);
        // evaluate
        System.out.println(SinglyLinkedList.evaluate(list1, x1));

        // test case 2
        SinglyLinkedList<Double> list2;
        list2 = new SinglyLinkedList<Double>();
        Double[] coefficients2 = {1.0, 0.0, -1.0};
        double x2 = 2.03;
        // append
        for (int coef = 0; coef < coefficients2.length; coef++) {
            SinglyLinkedList.appendTerm(list2, coefficients2[coef]);
        }
        // display
        SinglyLinkedList.display(list2);
        // evaluate
        System.out.println(SinglyLinkedList.evaluate(list2, x2));

        // test case 3
        SinglyLinkedList<Double> list3;
        list3 = new SinglyLinkedList<Double>();
        Double[] coefficients3 = {-3.0, 0.5, -2.0, 0.0};
        double x3 = 05.0;
        // append
        for (int coef = 0; coef < coefficients3.length; coef++) {
            SinglyLinkedList.appendTerm(list3, coefficients3[coef]);
        }
        // display
        SinglyLinkedList.display(list3);
        // evaluate
        System.out.println(SinglyLinkedList.evaluate(list3, x3));
        
        // test case 4
        SinglyLinkedList<Double> list4;
        list4 = new SinglyLinkedList<Double>();
        Double[] coefficients4 = {-.3125, 0.0, -9.915, -7.75, -40.0};
        double x4 = 123.45;
        // append
        for (int coef = 0; coef < coefficients4.length; coef++) {
            SinglyLinkedList.appendTerm(list4, coefficients4[coef]);
        }
        // display
        SinglyLinkedList.display(list4);
        // evaluate
        System.out.println(SinglyLinkedList.evaluate(list4, x4));
    }
}