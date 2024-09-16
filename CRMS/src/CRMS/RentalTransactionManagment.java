package CRMS;

import java.util.ArrayList;
import java.util.List;

public class RentalTransactionManagment{
	private CarManager carManager;
    private RenterManager renterManager;
    
    private List<RentalTransaction> rentalTransactions = new ArrayList<>();

    // Constructor
    public RentalTransactionManagment(CarManager carManager, RenterManager renterManager) {
        this.carManager = carManager;
        this.renterManager = renterManager;
    }

    public void rentCarToRenter(int carID, int renterID, double distanceTraveled, boolean addInsurance) {
        Car car = carManager.findCarById(carID);
        if (car == null || !car.getRentalStatus()) {
            System.out.println("Car is not available for rent.");
            return;
        }

        Renter renter = renterManager.findRenterById(renterID);
        if (renter == null) {
            System.out.println("Renter not found.");
            return;
        }

        double baseRent = car.calculateRent(distanceTraveled);
        baseRent += calculateAndDisplayInsuranceCost(car, addInsurance);

        baseRent = calculateDiscount(renter, baseRent);

        // Set car rental status to rented
        car.setRentalStatus(false);
        // Add the rented car to the renter's list of rented cars
        renter.getRentedCars().add(car);
        // Update the renter's total rental fee
        renter.updateTotalRentalFee(baseRent);

        // Create and store the rental transaction
        RentalTransaction transaction = new RentalTransaction(renter, car, distanceTraveled, baseRent, 0.0, addInsurance);
        rentalTransactions.add(transaction);

        System.out.println("Car rented successfully to: " + renter.getName());
        System.out.println("Total rental fee: " + baseRent);
    }

    public void displayAllRentalTransactions() {
        if (rentalTransactions.isEmpty()) {
            System.out.println("No rental transactions have been recorded.");
            return;
        }

        for (RentalTransaction transaction : rentalTransactions) {
            transaction.displayRentalDetails();
            System.out.println("---------------------------------------");
        }
    }

       public void returnCar(int carID, double distanceTraveled) {
        Car car = carManager.findCarById(carID);
        if (car == null || car.getRentalStatus()) {
            System.out.println("Car is not currently rented or not found.");
            return;
        }

        // Find the renter who rented this car
        Renter renter = null;
        for (Renter r : renterManager.getRenters()) {
            if (r.getRentedCars().contains(car)) {
                renter = r;
                break;
            }
        }

        if (renter == null) {
            System.out.println("Error: Renter not found for this car.");
            return;
        }

        double baseRent = car.calculateRent(distanceTraveled);
        baseRent = calculateDiscount(renter, baseRent);

        double totalRent = baseRent;

        // Check if the car is insurable and insurance was added
        boolean insuranceOpted = false; // Default value for insurance option
        if(((Insurable) car).isInsurable()) {
        	insuranceOpted = true;
        }
        baseRent += calculateAndDisplayInsuranceCost(car, insuranceOpted);

        // Calculate damage cost
        double damageCost = calculateAndDisplayDamageCost(car);

     //   totalRent += baseRent + damageCost;
        // Update renter's total rental fee
        renter.updateTotalRentalFee(totalRent);

        // Set car rental status to available
        car.setRentalStatus(true);

        // Remove car from renter's rented cars
        renter.getRentedCars().remove(car);

        if(renter.getRentedCars().isEmpty()) {
        	if(renterManager.getRenters().contains(renter)) {
        		renterManager.getRenters().remove(renter);
        		System.out.println("Renter removed succesfully...");
        	}
        }
        // Create and store the rental transaction
        RentalTransaction transaction = new RentalTransaction(renter, car, distanceTraveled, totalRent, damageCost, insuranceOpted);
        rentalTransactions.add(transaction);

        System.out.println("Car returned successfully by: " + renter.getName());
        System.out.println("Total rental fee: " + totalRent);
        if(insuranceOpted) {
        	System.out.println("Insurance Opted.");
        } else {
        	System.out.println("Insurance not opted.");
        }
    }


    private double calculateAndDisplayDamageCost(Car car) {
    	double damageCost = 0.0;
    	Insurable insurableCar = (Insurable) car;
    	damageCost = insurableCar.calculateDamageCost();
    	System.out.println("Damage cost: " + damageCost);
        return damageCost;
    }
    
    private double calculateAndDisplayInsuranceCost(Car car, boolean addInsurance) {
        // Check if the car is insurable and if insurance is requested
    	double insuranceCost = 0.0;
        if (addInsurance && car instanceof Insurable && ((Insurable) car).isInsurable()) {
            Insurable insurableCar = (Insurable) car;
            insuranceCost = insurableCar.calculateInsuranceCost();
            System.out.println("Insurance added. Insurance cost: " + insuranceCost);
        }
        return insuranceCost;
    }
    
    private double calculateDiscount(Renter renter, double baseRent) {
    	double discount = 0.0;
        if (renter instanceof Discountable) {
            Discountable discountableRenter = (Discountable) renter;
            discount = discountableRenter.calculateDiscount(baseRent);
        }
        return discount;
    }
}
