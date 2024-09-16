package CRMS;

public class RentalTransaction 
{
	 	private Renter renter;
	    private Car car;
	    private double distanceTraveled;
	    private double rentalFee; 
	    private double damageCost;
	    private boolean insuranceOpted;

	    public RentalTransaction(Renter renter, Car car, double distanceTraveled, double rentalFee, double damageCost, boolean insuranceOpted) {
	        this.renter = renter;
	        this.car = car;
	        this.distanceTraveled = distanceTraveled;
	        this.rentalFee = rentalFee;
	        this.damageCost = damageCost;
	        this.insuranceOpted = insuranceOpted;
	    }

	    // Getters
	    public Renter getRenter() { return renter; }
	    public Car getCar() { return car; }
	    public double getDistanceTraveled() { return distanceTraveled; }
	    public double getRentalFee() { return rentalFee; }

	    // Method to display rental transaction details
	    public void displayRentalDetails() {
	        System.out.println("Rental Details:");
	        System.out.println("Renter Name: " + renter.getName());
	        car.displayCarDetails();
	        System.out.println("Distance Traveled: " + distanceTraveled + " km");
	        System.out.println("Damage cost: " + damageCost + "$");
	        System.out.println("Is Insurance Opted: " + insuranceOpted);
	        System.out.println("Total Rental Fee: " + rentalFee + " currency units");
	    }
}
