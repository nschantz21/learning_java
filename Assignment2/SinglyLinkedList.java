//
// Homework2
// Use linked lists to represent, display, and evaluate polynomials
//

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {
    // An element in a linked list
    public class Element {
        private E data;
        private Element next;

        // Only allow SinglyLinkedList to construct Elements
        private Element(E data) {
            this.data = data;
            this.next = null;
        }

        public E getData() {
            return data;
        }

        public Element getNext() {
            return next;
        }

        private SinglyLinkedList getOwner() {
            return SinglyLinkedList.this;
        }
    }

    private Element head;
    private Element tail;
    private int size;

    public Element getHead() {
        return head;
    }

    public Element getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Element insertHead(E data) {
        Element newElement = new Element(data);

        if (isEmpty()) {
            // Insert into empty list
            head = newElement;
            tail = newElement;
        }
        else {
            // Insert into non-empty list
            newElement.next = head;
            head = newElement;
        }

        ++size;

        return newElement;
    }

    public Element insertTail(E data) {
        Element newElement = new Element(data);

        if (isEmpty()) {
            // Insert into empty list
            head = newElement;
            tail = newElement;
        }
        else {
            // Insert into non-empty list
            tail.next = newElement;
            tail = newElement;
        }

        ++size;

        return newElement;
    }

    public Element insertAfter(Element element, E data)
            throws IllegalArgumentException {
        // Check pre-conditions
        if (element == null) {
            throw new IllegalArgumentException(
                    "Argument 'element' must not be null");
        }
        if (element.getOwner() != this) {
            throw new IllegalArgumentException(
                    "Argument 'element' does not belong to this list");
        }

        // Insert new element
        Element newElement = new Element(data);
        if (tail == element) {
            // Insert new tail
            element.next = newElement;
            tail = newElement;
        }
        else {
            // Insert into middle of list
            newElement.next = element.next;
            element.next = newElement;
        }

        ++size;

        return newElement;
    }

    public E removeHead() throws NoSuchElementException {
        // Check pre-conditions
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot remove from empty list");
        }

        // Remove the head
        Element oldHead = head;
        if (size == 1) {
            // Handle removal of the last element
            head = null;
            tail = null;
        }
        else {
            head = head.next;
        }

        --size;

        return oldHead.data;
    }

    // Note that there is no removeTail.  This cannot be implemented
    // efficiently because it would require O(n) to scan from head until
    // reaching the item _before_ tail.

    public E removeAfter(Element element)
            throws IllegalArgumentException, NoSuchElementException {
        // Check pre-conditions
        if (element == null) {
            throw new IllegalArgumentException(
                    "Argument 'element' must not be null");
        }
        if (element.getOwner() != this) {
            throw new IllegalArgumentException(
                    "Argument 'element' does not belong to this list");
        }
        if (element == tail) {
            throw new IllegalArgumentException(
                    "Argument 'element' must have a non-null next element");
        }

        // Remove element
        Element elementToRemove = element.next;
        if (elementToRemove == tail) {
            // Remove the tail
            element.next = null;
            tail = element;
        }
        else {
            // Remove from middle of list
            element.next = elementToRemove.next;
        }

        --size;

        return elementToRemove.data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SinglyLinkedList<?> that = (SinglyLinkedList<?>) o;

        if (this.size != that.size) return false;

        // Return whether all elements are the same
        SinglyLinkedList<?>.Element thisElem = this.getHead();
        SinglyLinkedList<?>.Element thatElem = that.getHead();
        while (thisElem != null && thatElem != null) {
            if (!thisElem.getData().equals(thatElem.getData())) {
                return false;
            }
            thisElem = thisElem.getNext();
            thatElem = thatElem.getNext();
        }

        return true;
    }
    // a
    static void appendTerm(SinglyLinkedList<Double> polynomial, Double coefficient) {
        // append the value coefficient to polynomial
        polynomial.insertTail(coefficient);
    }

    // b
    static void display(SinglyLinkedList<Double> polynomial) {
        
        SinglyLinkedList<Double>.Element coef = polynomial.getHead();
        int exp_cntr = polynomial.getSize();
        while (coef != null) {
            if (coef.getData() != 0.0) {
                // print the coefficient
                // don't print if coefficient is 1.0
                if (coef.getData() != 1.0) {
                    if (exp_cntr == polynomial.getSize()) {
                        System.out.print(coef.getData());
                    } else {
                        System.out.print(Math.abs(coef.getData()));
                    }
                } else if (exp_cntr == 1) {
                    System.out.print(Math.abs(coef.getData()));
                }
                // print the variable
                if (exp_cntr > 1) {
                    System.out.print("x");
                }
                // print the exponent
                if (exp_cntr > 2) {
                    System.out.print("^" + (exp_cntr - 1));
                }
            }
            // print the operator
            if ((coef.getNext() != null) && (coef.getNext().getData() != 0.0)) {
                if (exp_cntr > 1) {
                    if (coef.getNext().getData() < 0) {
                        System.out.print(" - ");
                    } else {
                        System.out.print(" + ");
                    }
                }
            }
            // decrement the exponent counter
            --exp_cntr;
            // get the next element
            coef = coef.getNext();
        }
        System.out.print("\n");
    }
    // c
    static double evaluate(SinglyLinkedList<Double> polynomial, Double x) {
        // evaluate polynomial for the given value of x and return the result
        double run_sum = 0.0;
        SinglyLinkedList<Double>.Element coef = polynomial.getHead();
        int exp_cntr = polynomial.getSize();
        while (coef != null) {
            // add to a running sum
            double temp = 0;
            if (exp_cntr != 0) {
                temp = coef.getData() * Math.pow(x, exp_cntr-1);
            } else {
                temp = coef.getData();
            }
            run_sum += temp;
            exp_cntr--;
            coef = coef.getNext();
        }
        return run_sum;
    }
}
