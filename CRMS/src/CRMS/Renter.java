package CRMS;

import java.util.ArrayList;
import java.util.List;

public class Renter {
	private int renterID;
	private String name;
	private String email;
	private List<Car> rentedCars;
	private double totalRentalFee;
	private String phoneNumber;
	private String address;
	
	// constructor
	public Renter(int renterID, String name, String email, String phoneNumber, 
			String address) {
        this.renterID = renterID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.rentedCars = new ArrayList<>();
        this.totalRentalFee = 0.0;
	}
	
    // Getter methods
    public int getRenterID() {
        return renterID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Car> getRentedCars() {
        return rentedCars;
    }

    public double getTotalRentalFee() {
        return totalRentalFee;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }
    
    public void updateTotalRentalFee(double rentalFee) {
        this.totalRentalFee += rentalFee; 
    }
    
    public void displayRenterDetails() {
        System.out.println("Renter ID: " + getRenterID());
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Address: " + getAddress());
        System.out.println("Total Rental Fee: " + getTotalRentalFee());
        System.out.print("Rented Cars: ");
        if (getRentedCars().isEmpty()) {
            System.out.println("None");
        } else {
            for (Car car : getRentedCars()) {
                System.out.println(car.getCarID() + " (" + car.getCarBrand() + " " + car.getCarModel() + ")");
            }
        }
    }
}
