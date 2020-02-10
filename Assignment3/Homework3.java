//
// Homework3.java
// 
// Use quicksort to sort an array of car objects by various criteria

import java.util.Comparator; // comparator
class Homework3 {
    static class Car
    {
        public String make;
        public String model;
        public int mpg;
        public Car(String make, String model, int mpg)
        {
            this.make = make;
            this.model = model;
            this.mpg = mpg;
        }
    }
    
    // question a
    static class compareCarsByMakeThenModel implements Comparator<Car>
    {
        public int compare(Car a, Car b)
        {
            // sort array of cars in ascending order by make
            int result = a.make.compareTo(b.make);
            // evaluate if make is equal
            if (result != 0) {
                return result;
            }
            // when two cars have equal make, sort by ascending order by model
            return a.model.compareTo(b.model);
        }
    }
    
    // question b
    static class compareCarsByDescedingMPG implements Comparator<Car>
    {
        public int compare(Car a, Car b)
        {
            // sort array of cars in descending order by mpg
            return b.mpg - a.mpg;
        }
    }
    
    // question c
    static class compareCarsByMakeThenDescendingMPG implements Comparator<Car>
    {
        public int compare(Car a, Car b)
        {
            // sort an array of cars in ascending order by make
            int result = a.make.compareTo(b.make);
            // if equal return the order
            if (result != 0) {
                return result;
            }
            // when two cars have the same make sort in descending order by mpg
            compareCarsByDescedingMPG mpgComparator = new compareCarsByDescedingMPG();
            return mpgComparator.compare(a, b);
        }
    }
    
    public static void main(String[] args) {
        // initialize cars
        Car cars[] = {
            new Car("Toyota","Camry", 33),
            new Car("Ford", "Focus", 40),
            new Car( "Honda", "Accord", 34),
            new Car("Ford", "Mustang", 31 ),
            new Car("Honda", "Civic", 39),
            new Car("Toyota", "Prius", 48),
            new Car("Honda", "Fit", 35),
            new Car("Toyota", "Corolla", 35),
            new Car("Ford", "Taurus", 28)
        };

        // unsorted
        System.out.println("Unsorted");
        for (int car = 0; car < cars.length; car++) {
            Car this_car = cars[car];
            System.out.println(this_car.make + " " + this_car.model + " " + this_car.mpg);
        }
        System.out.println('\n');

        // sort using comparator a
        System.out.println("Sort by Make then Model");
        compareCarsByMakeThenModel makeThenModel = new compareCarsByMakeThenModel();
        QuickSort.quickSort(cars, makeThenModel);
        for (int car = 0; car < cars.length; car++) {
            Car this_car = cars[car];
            System.out.println(this_car.make + " " + this_car.model + " " + this_car.mpg);
        }
        System.out.println('\n');

        // sort using comparator b
        System.out.println("Sort by Descending MPG");
        compareCarsByDescedingMPG descMPG = new compareCarsByDescedingMPG();
        QuickSort.quickSort(cars, descMPG);
        for (int car = 0; car < cars.length; car++) {
            Car this_car = cars[car];
            System.out.println(this_car.make + " " + this_car.model + " " + this_car.mpg);
        }
        System.out.println('\n');
    
        // sort using comparator c
        System.out.println("Sort by Make then Descending MPG");
        compareCarsByMakeThenDescendingMPG makeThenDescMPG = new compareCarsByMakeThenDescendingMPG(); 
        QuickSort.quickSort(cars, makeThenDescMPG);
        for (int car = 0; car < cars.length; car++) {
            Car this_car = cars[car];
            System.out.println(this_car.make + " " + this_car.model + " " + this_car.mpg);
        }
        System.out.print('\n');

    }
}