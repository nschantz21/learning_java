//
// Homework3.java
// 
// Use quicksort to sort an array of car objects by various criteria

import java.util.Comparator // comparator

class Car
{
    public String make;
    public String model;
    public int mpg;
}

// question a
class compareCarsByMakeThenModel implements Comparator<Car>
{
    public int compare(Car a, Car b)
    {
        int result;
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
        int result;
        // sort an array of cars in ascending order by make
        a.make.compareTo(b.make);
        // if equal return the order
        if (result != 0) {
            return result;
        }
        // when two cars have the same make sort in descending order by mpg
        compareCarsByDescedingMPG mpgComparator = new compareCarsByDescedingMPG();
        return mpgComparator.compare(a.mpg, b.mpg);
    }
}

class Homework3
{
    
}

void printCars(Car cars) {
    // helper function to print array of cars
    for (int car = 0; car < cars.length; car++) {
        Car this_car = cars[car];
        System.out.println(this_car.make, this_car.model, this_car.mpg);
    }
}


int main() {

    Car cars[] = {
        { "Toyota", "Camry", 33 },
        { "Ford", "Focus", 40 },
        { "Honda", "Accord", 34 },
        { "Ford", "Mustang", 31 },
        { "Honda", "Civic", 39 },
        { "Toyota", "Prius", 48 },
        { "Honda", "Fit", 35 },
        { "Toyota", "Corolla", 35 },
        { "Ford", "Taurus", 28 }
    }



    // unsorted
    printCars(cars);

    // sort using comparator a
    quicksort(cars, compareCarsByMakeThenModel);
    printCars(cars);

    // sort using comparator b
    quicksort(cars, compareCarsByDescedingMPG);
    printCars(cars);

    // sort using comparator c
    quicksort(cars, compareCarsByMakeThenDescendingMPG);
    printCars(cars);

}