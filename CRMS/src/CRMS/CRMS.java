package CRMS;
import java.util.*;


public class CRMS {

	public static void main(String[] args) 
	{
	    menu();
	}
	
	private static void menu() 
	{
		   Scanner scanner = new Scanner(System.in);
	       CarManager carManager = new CarManager(); // Access CarManager through the instance of CRMS
	       RenterManager renterManager = new RenterManager(); // Access RenterManager directly
	       RentalTransactionManagment rentTransactions = new RentalTransactionManagment(carManager, renterManager);

	        while (true) 
	        {
	            System.out.println("\nCar Rental Management System Menu:");
	            System.out.println("1. Add New Car");
	            System.out.println("2. Add New Renter");
	            System.out.println("3. Display Available Cars");
	            System.out.println("4. Rent Car To Renter");
	            System.out.println("5. Return Car");
	            System.out.println("6. Display All Rental Transactions");
	            System.out.println("7. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = scanner.nextInt();
	            switch (choice) {
	            case 1:
	            {
	                System.out.println("Adding a new car...");
	                scanner.nextLine(); // Consume the leftover newline

	                System.out.print("Enter car ID: ");
	                int carID = scanner.nextInt();
	                scanner.nextLine(); // Consume newline to clear the buffer

	                System.out.print("Enter car brand: ");
	                String carBrand = scanner.nextLine();

	                System.out.print("Enter car model: ");
	                String carModel = scanner.nextLine();

	                System.out.print("Enter manufacture year: ");
	                int manufactureYear = scanner.nextInt();

	                System.out.print("Is the car available for rental? (true/false): ");
	                boolean rentalStatus = scanner.nextBoolean();

	                System.out.println(rentalStatus);
	                System.out.print("Enter rental fee: ");
	                double rentalFee = scanner.nextDouble();

	                scanner.nextLine(); // Consume newline

	                System.out.print("Enter plate number: ");
	                String plateNumber = scanner.nextLine();

	                System.out.print("Enter cost per kilometer: ");
	                double costPerKilometer = scanner.nextDouble();

	                System.out.println("Select the type of car:");
	                System.out.println("1. Compact Car");
	                System.out.println("2. SUV");
	                System.out.println("3. Luxury Car");
	                System.out.print("Enter your choice: ");
	                int carType = scanner.nextInt();

	                Car newCar = null; // Declare a Car reference to hold the new car object

	                switch (carType) {
	                    case 1: // CompactCar
	                        System.out.print("Enter damage cost percentage (as a decimal): ");
	                        double damageCostPercentage = scanner.nextDouble();
	                        newCar = new CompactCar(carID, carModel, carBrand, manufactureYear, rentalStatus, rentalFee, plateNumber, costPerKilometer, damageCostPercentage);
	                        break;
	                    case 2: // SUV
	                        System.out.print("Enter insurance cost percentage (as a decimal): ");
	                        double insuranceCostPercentage = scanner.nextDouble();
	                        System.out.print("Enter damage cost percentage (as a decimal): ");
	                        double suvDamageCostPercentage = scanner.nextDouble();
	                        System.out.print("Enter minimum damage cost: ");
	                        double minumumDamageCost = scanner.nextDouble();
	                        newCar = new SUV(carID, carModel, carBrand, manufactureYear, rentalStatus, rentalFee, plateNumber, costPerKilometer, insuranceCostPercentage, suvDamageCostPercentage, minumumDamageCost);
	                        break;
	                    case 3: // LuxuryCar
	                        System.out.print("Enter luxury tax (as a decimal): ");
	                        double luxuryTax = scanner.nextDouble();
	                        System.out.print("Enter insurance cost percentage (as a decimal): ");
	                        double luxuryInsuranceCostPercentage = scanner.nextDouble();
	                        System.out.print("Enter damage cost percentage (as a decimal): ");
	                        double luxuryDamageCostPercentage = scanner.nextDouble();
	                        System.out.print("Enter minimum damage cost: ");
	                        double luxuryMinumumDamageCost = scanner.nextDouble();
	                        newCar = new LuxuryCar(carID, carModel, carBrand, manufactureYear, rentalStatus, rentalFee, luxuryMinumumDamageCost, plateNumber, costPerKilometer, luxuryTax, luxuryInsuranceCostPercentage, luxuryDamageCostPercentage);
	                        break;
	                    default:
	                        System.out.println("Invalid car type selected.");
	                        break;
	                }

	                if (newCar != null) {
	                    carManager.addCar(newCar);
	                    System.out.println("New car added successfully!");
	                }
	                break;
	            }

	            case 2:{
	                System.out.println("Adding a new renter...");
	                scanner.nextLine(); // Consume the leftover newline after the last nextInt()

	                System.out.print("Enter renter ID: ");
	                int renterID = scanner.nextInt();
	                scanner.nextLine(); // Consume newline

	                System.out.print("Enter renter name: ");
	                String name = scanner.nextLine();

	                System.out.print("Enter renter email: ");
	                String email = scanner.nextLine();

	                System.out.print("Enter renter phone number: ");
	                String phoneNumber = scanner.nextLine();

	                System.out.print("Enter renter address: ");
	                String address = scanner.nextLine();

	                System.out.println("Select the type of renter:");
	                System.out.println("1. Regular Renter");
	                System.out.println("2. Frequent Renter");
	                System.out.println("3. Corporate Renter");
	                System.out.print("Enter your choice: ");
	                int renterType = scanner.nextInt();

	                Renter newRenter = null; // Declare a Renter reference to hold the new renter object

	                switch (renterType) {
	                    case 1: // RegularRenter
	                        newRenter = new RegularRenter(renterID, name, email, phoneNumber, address);
	                        break;
	                    case 2: // FrequentRenter
	                        System.out.print("Enter discount rate (as a decimal, e.g., 0.1 for 10%): ");
	                        double discountRate = scanner.nextDouble();
	                        newRenter = new FrequentRenter(renterID, name, email, phoneNumber, address, discountRate);
	                        break;
	                    case 3: // CorporateRenter
	                        System.out.print("Enter special rate (as a decimal, e.g., 0.15 for 15%): ");
	                        double specialRate = scanner.nextDouble();
	                        newRenter = new CorporateRenter(renterID, name, email, phoneNumber, address, specialRate);
	                        break;
	                    default:
	                        System.out.println("Invalid renter type selected.");
	                        break;
	                }

	                if (newRenter != null) {
	                    renterManager.addRenter(newRenter);
	                    System.out.println("New renter added successfully!");
	                }
	                break;
	            }

	            case 3:
	            	carManager.displayAvailableCars();
	                break;
	                
	            case 4:
	                System.out.println("Renting a car to a renter...");
	                scanner.nextLine(); // Clear the scanner buffer
	                System.out.println("---------------------------------------------");
	                carManager.displayAvailableCars();
	                System.out.println("---------------------------------------------");
	                System.out.print("Enter car ID: ");
	                int carID = scanner.nextInt();

	                System.out.println("---------------------------------------------");
	                renterManager.displayRenters();
	             //   System.out.println("---------------------------------------------");
	                System.out.print("Enter renter ID: ");
	                int renterID = scanner.nextInt();

	                System.out.print("Enter distance to be traveled (km): ");
	                double distanceTraveled = scanner.nextDouble();

	                System.out.print("Is insurance opted for? (true/false): ");
	                boolean insuranceOpted = scanner.nextBoolean();

	                // Call the method to rent a car to the renter
	                rentTransactions.rentCarToRenter(carID, renterID, distanceTraveled, insuranceOpted);

	                break;

	            case 5:
	            	
	                System.out.println("Returning a car...");
	                scanner.nextLine(); // Clear the scanner buffer to ensure proper input capture

	                System.out.print("Enter car ID: ");
	                int carIDToReturn = scanner.nextInt();

	                System.out.print("Enter distance traveled during rental (km): ");
	                double distanceTraveledReturn = scanner.nextDouble();

	                // Call the method to return the car
	                rentTransactions.returnCar(carIDToReturn, distanceTraveledReturn);
	                break;

	            case 6:
	                rentTransactions.displayAllRentalTransactions();
	                break;
	            case 7:
	                System.out.println("Exiting...");
	                scanner.close();
	                return;
	            default:
	                System.out.println("Invalid choice. Please enter a number between 1 and 7.");
	            }
	        }
		}
}

