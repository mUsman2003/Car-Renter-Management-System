package CRMS;

public class CompactCar extends Car implements Insurable{
	private final double damageCostPercentage;
	
	// constructor
    public CompactCar(int carId, String brand, String model, int year, boolean rentalStatus, double rentalFee,
                      String plateNumber, double costPerKilometer, double damageCostPercentage) 
                      {
        super(carId, brand, model, year, rentalStatus, rentalFee, plateNumber, costPerKilometer);
        this.damageCostPercentage = damageCostPercentage;
    }

    @Override
    public double calculateRent(double distanceTraveled) {
        return getRentalFee() + distanceTraveled * getCostPerKilometer();
    }

    @Override
    public boolean isInsurable() 
    {
        // Compact Car is not insurable
        return false;
    }

    @Override
    public void displayFeatures() {
        System.out.println("Features: Basic Features");
        System.out.println("Travel Type: suitable for short-distance travel.");
    }
    
	@Override
	public double calculateInsuranceCost() {
		return getRentalFee();
	}
	
	@Override
	public double calculateDamageCost() {
		return getRentalFee() * damageCostPercentage;
	}
}


