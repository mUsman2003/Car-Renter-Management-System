package CRMS;

public class LuxuryCar extends Car implements Insurable{
    private final double luxuryTax;
    private final double insuranceCostPercentage;
    private final double damageCostPercentage;
    private final double minumumDamageCost;
    
    // constructor
    public LuxuryCar(int carId, String brand, String model, int year, boolean rentalStatus, double rentalFee, double minumumDamageCost, 
            String plateNumber, double costPerKilometer, double luxuryTax, double insuranceCostPercentage,  double damageCostPercentage) {
		super(carId, brand, model, year, rentalStatus, rentalFee, plateNumber, costPerKilometer);
		this.luxuryTax = luxuryTax;
		this.insuranceCostPercentage = insuranceCostPercentage;
		this.damageCostPercentage = damageCostPercentage;
		this.minumumDamageCost = minumumDamageCost;
    }
    
    @Override
    public double calculateRent(double distanceTraveled) {
        // Implement the rent calculation formula for Luxury Car
        return ((getRentalFee() + distanceTraveled * getCostPerKilometer() + getRentalFee() * luxuryTax) + calculateDamageCost()) - calculateInsuranceCost();
    }

    @Override
    public boolean isInsurable() {
        // Luxury Car is insurable
        return true;
    }
    
    public double calculateInsuranceCost() {
        // Calculate insurance cost for Luxury Car
        return getRentalFee() * insuranceCostPercentage;
    }

    public double calculateDamageCost() {
        // Calculate damage cost for Luxury Car
    	 return Math.max(minumumDamageCost, ((getRentalFee() + getRentalFee() * luxuryTax) * damageCostPercentage) - calculateInsuranceCost());
    }
    
    @Override
    public void displayFeatures() {
        System.out.println("Features: High-end");
        System.out.println("Travel Type: suitable for special occasions.");
    }  
}

