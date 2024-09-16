package CRMS;

public class RegularRenter extends Renter implements Discountable{
    
    // Constructor 
    public RegularRenter(int renterID, String name, String email, String phoneNumber, String address) {
        super(renterID, name, email, phoneNumber, address);
    }

    @Override
    public void displayFeatures() {
        System.out.println("Features: Standard rent-rates");
    }

    @Override
    public double calculateDiscount(double rentalFee) {
        // Regular renters may not have discounts
        System.out.println("Regular Renters don't have any discount.");
        return rentalFee;
    }
    
    @Override
    public void displayRenterDetails() {
        super.displayRenterDetails();
        // Add any specific details for RegularRenter here
        System.out.println("Renter Type: Regular");
    }  
}