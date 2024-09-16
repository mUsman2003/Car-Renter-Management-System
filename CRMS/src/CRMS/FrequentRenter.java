package CRMS;

public class FrequentRenter extends Renter implements Discountable{
    private final double discountRate;
    
    // Constructor 
    public FrequentRenter(int renterID, String name, String email, String phoneNumber, String address, double discountRate) {
        super(renterID, name, email, phoneNumber, address);
        this.discountRate = discountRate;
    }
    
    @Override
    public void displayFeatures() {
        System.out.println("Features: Loyalty program with discounted rates.");
    }

    @Override
    public double calculateDiscount(double rentalFee) {
        // Apply discount based on loyalty program
        return rentalFee * discountRate;
    }
    
    @Override
    public void displayRenterDetails() {
        super.displayRenterDetails();
        System.out.println("Renter Type: Frequent");
        System.out.println("Discount Rate: " + (discountRate * 100) + "%");
    }

}