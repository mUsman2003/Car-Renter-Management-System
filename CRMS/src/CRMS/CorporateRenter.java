package CRMS;

public class CorporateRenter extends Renter implements Discountable{
    private final double specialRate;
    
    // Constructor 
    public CorporateRenter(int renterID, String name, String email, String phoneNumber, String address, double specialRate) {
        super(renterID, name, email, phoneNumber, address);
        this.specialRate = specialRate;
    }
    
    @Override
    public void displayFeatures() {
        System.out.println("Features: Special rates for corporate clients.");
    }

    @Override
    public double calculateDiscount(double rentalFee) {
        // Apply special rates for corporate clients
        return rentalFee * specialRate;
    }
    
    @Override
    public void displayRenterDetails() {
        super.displayRenterDetails();
        System.out.println("Renter Type: Corporate");
        System.out.println("Special Rate: " + (specialRate * 100) + "%");
    }

}
