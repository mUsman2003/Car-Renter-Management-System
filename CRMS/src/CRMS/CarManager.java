package CRMS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CarManager{
	private List<Car> cars;
	
	// constructor
    public CarManager() {
        this.cars = new ArrayList<>();
    }

    // Add new car
    public void addCar(Car car) {
        cars.add(car);
        System.out.println("Car added: " + car.getCarBrand());
    }
	
    public void displayAvailableCars() {
        List<Car> availableCars = cars.stream()
                                       .filter(car -> car.getRentalStatus()) 
                                       .collect(Collectors.toList());

        if (availableCars.isEmpty()) {
            System.out.println("No available cars at the moment.");
        } else {
            System.out.println("Available cars:");
            availableCars.forEach(Car::displayCarDetails); // Corrected method reference
        }
    }


    // Remove a car by ID if it is not rented
    public void removeCar(int carID) {
        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            if (car.getCarID() == carID && !car.getRentalStatus()) 
            {
                iterator.remove();
                System.out.println("Car removed: " + car);
                return;
            }
        }
        System.out.println("Car not found or is currently rented.");
    }
    
    public Car findCarById(int carID) {
        for (Car car : this.cars) {
            if (car.getCarID() == carID) {
                return car; // Return the car if the ID matches
            }
        }
        return null; // Return null if no car matches the given ID
    }
}