package CRMS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RenterManager{
	private List<Renter> renters;
	
	// constructor
	public RenterManager() {
		this.renters = new ArrayList<>();
	}
	
    void addRenter(Renter renter) {
        renters.add(renter);
        System.out.println("Renter added: " + renter.getName());
    }
	
    public void displayRenters() {
        if (renters.isEmpty()) {
            System.out.println("No renters at the moment.");
            return;
        }

        System.out.println("Detailed Renters Information:");
        for (Renter renter : renters) {
            renter.displayRenterDetails(); // This will call the overridden method in the actual subclass
            System.out.println("-------------------------------"); // Separator for readability
        }
    }

	public void removeRenter(int renterID) {
		Iterator<Renter> iterator = renters.iterator();
        while (iterator.hasNext()) {
            Renter renter = iterator.next();
            if (renter.getRenterID() == renterID && renter.getRentedCars().isEmpty()) { // Check if the renter has returned all cars
                iterator.remove();
            //    renter.rentedCars.
                System.out.println("Renter removed: " + renter.getName());
                return;
            }
        }
        System.out.println("Renter not found or still has rented cars.");
	}
	
	public Renter findRenterById(int renterID) {
	    for (Renter renter : this.renters) {
	        if (renter.getRenterID() == renterID) {
	            return renter; // Return the renter if the ID matches
	        }
	    }
	    return null; // Return null if no renter matches the given ID
	}

    public List<Renter> getRenters() {
        return renters;
    }

} 

