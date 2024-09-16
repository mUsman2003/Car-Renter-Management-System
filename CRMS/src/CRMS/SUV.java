package CRMS;

public class SUV extends Car implements Insurable{
    private final double insuranceCostPercentage;
    private final double damageCostPercentage;
    private final double minumumDamageCost;
    
    // constructor
	public SUV(int carId, String brand, String model, int year, boolean rentalStatus, double rentalFee,
            String plateNumber, double costPerKilometer, double insuranceCostPercentage, double damageCostPercentage, double minumumDamageCost) {
		super(carId, brand, model, year, rentalStatus, rentalFee, plateNumber, costPerKilometer);
		this.insuranceCostPercentage = insuranceCostPercentage;
		this.damageCostPercentage = damageCostPercentage;
		this.minumumDamageCost = minumumDamageCost;
	}
	
    public double calculateInsuranceCost() {
        // Calculate insurance cost for SUV
        return getRentalFee() * insuranceCostPercentage;
    }

    public double calculateDamageCost() {
        // Calculate damage cost for SUV
        return Math.max(minumumDamageCost, (damageCostPercentage * getRentalFee()) - calculateInsuranceCost());
    }
	
	@Override
    public double calculateRent(double distanceTraveled) {
        return (getRentalFee() + (distanceTraveled * getCostPerKilometer()) + calculateDamageCost()) - calculateInsuranceCost() ;
    }

    @Override
    public boolean isInsurable() {
        // SUV Car is insurable
        return true;
    }

    @Override
    public void displayFeatures() {
        System.out.println("Features: Spacious");
        System.out.println("Travel Type: suitable for family trips.");
    }	
}
