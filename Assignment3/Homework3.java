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
            int result = 0;
            // sort array of cars in ascending order by make
            result = a.make.compareTo(b.make);
            // evaluate if make is equal
            if (result != 0) {
                return result;
            }
            // when two cars have equal make, sort by ascending order by model
            return a.model.compareTo(b.model);
        }
    }
    
    // question b
    class compareCarsByDescedingMPG implements Comparator<Car>
    {
        public int compare(Car a, Car b)
        {
            // sort array of cars in descending order by mpg
            return b.mpg - a.mpg;
        }
    }
    
    // question c
    class compareCarsByMakeThenDescendingMPG implements Comparator<Car>
    {
        public int compare(Car a, Car b)
        {
            int result = 0;
            // sort an array of cars in ascending order by make
            a.make.compareTo(b.make);
            // if equal return the order
            if (result != 0) {
                return result;
            }
            // when two cars have the same make sort in descending order by mpg
            compareCarsByDescedingMPG mpgComparator = new compareCarsByDescedingMPG();
            return mpgComparator.compare(a, b);
        }
    }
    
   /* 
    void printCars(Car cars[]) {
        // helper function to print array of cars
        for (int car = 0; car < cars.length; car++) {
            Car this_car = cars[car];
            System.out.println(this_car.make + " " + this_car.model + " " + this_car.mpg);
        }
    }
    */

    
    public static void main(String[] args) {
        /*
        Car [] cars = new Car[4];
        cars[0] = new Car("Toyota","Camry",33);
        cars[1] = new Car("Ford", "Focus", 40);
        cars[2] = new Car("Honda", "Accord", 34);
        cars[3] = new Car("Ford", "Mustang", 31); 
        
        
        Car[] cars =  new Car[2];
        cars[0] = new Car();
        cars[0].make = "Toyota";
        cars[0].model = "Camry";
        cars[0].mpg = 33;
        cars[1].make = "Ford";
        cars[1].model = "Focus";
        cars[1].mpg = 40;
*/
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
        for (int car = 0; car < cars.length; car++) {
            Car this_car = cars[car];
            System.out.println(this_car.make + " " + this_car.model + " " + this_car.mpg);
        }
        System.out.println('\n');

        // sort using comparator a
        compareCarsByMakeThenModel makeThenModel = new compareCarsByMakeThenModel();
        QuickSort.quickSort(cars, makeThenModel);
        for (int car = 0; car < cars.length; car++) {
            Car this_car = cars[car];
            System.out.println(this_car.make + " " + this_car.model + " " + this_car.mpg);
        }
        System.out.println('\n');

        // sort using comparator b
        compareCarsByDescedingMPG descMPG = new compareCarsByDescedingMPG();
        QuickSort.quickSort(cars, descMPG);
        for (int car = 0; car < cars.length; car++) {
            Car this_car = cars[car];
            System.out.println(this_car.make + " " + this_car.model + " " + this_car.mpg);
        }
        System.out.println('\n');
    
        // sort using comparator c
        compareCarsByMakeThenDescendingMPG makeThenDescMPG = new compareCarsByMakeThenDescendingMPG(); 
        QuickSort.quickSort(cars, makeThenDescMPG);
        for (int car = 0; car < cars.length; car++) {
            Car this_car = cars[car];
            System.out.println(this_car.make + " " + this_car.model + " " + this_car.mpg);
        }
        System.out.println('\n');

    }
}