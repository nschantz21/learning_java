// Homework7.java
// Nicholas Schantz

import java.util.Comparator; // comparator
class Homework7 {
    static class Person {
        String name;
        int age;
        double height;
        Person(String name, int age, double height) {
            this.name = name;
            this.age = age;
            this.height = height;
        }
    }

    // a 
    public static void outputSorted(Person people[], Comparator<Person> comparator) {
        // sort an array of Person objects using only a Heap
        Heap<Person> heap = new Heap<Person>(comparator);

        for(Person peep : people) {
            heap.insert(peep);
        }

        while(!heap.isEmpty()) {
            Person this_person = heap.extract();
            System.out.format("name: " + this_person.name + ", age: %d, height(cm): %f%n" , this_person.age, this_person.height);
        }
        System.out.println();

    }

    public static class ascNameComparator implements Comparator<Person> {
        public int compare(Person peep1, Person peep2) {
            return peep1.name.compareTo(peep2.name);
        }
    }

    public static class ascAge implements Comparator<Person> {
        public int compare(Person peep1, Person peep2) {
            return peep2.age - peep1.age;
        }
    }

    public static class ascHeight implements Comparator<Person> {
        public int compare(Person peep1, Person peep2) {
            return (int) (peep2.height - peep1.height);
        }
    }

    public static void main(String args[]) {
        Person players[] = {
            // name, age, height
            new Person("Dwayne Bacon", 81, 49),
            new Person("Marvin Bagley III", 3, 210),
            new Person("Lonzo Ball", 35, 83),
            new Person("Mo Bamba", 28, 56),
            new Person("J.J. Barea", 94, 47),
            new Person("Harrison Barnes", 86, 210),
            new Person("RJ Barrett", 69, 43),
            new Person("Will Barton", 75, 129),
            new Person("Keita Bates-Diop", 4, 28),
            new Person("Nicolas Batum", 11, 76),
            new Person("Aron Baynes", 29, 150),
            new Person("Kent Bazemore", 77, 27),
            new Person("Darius Bazley", 71, 71),
            new Person("Bradley Beal", 91, 187),
        };

        // b
        System.out.println("Sorted by Name (asc)");
        outputSorted(players, new ascNameComparator());

        // c
        System.out.println("Sorted by Age (asc)");
        outputSorted(players, new ascAge());

        // d
        System.out.println("Sorted by Height (asc)");
        outputSorted(players, new ascHeight());
    }

}