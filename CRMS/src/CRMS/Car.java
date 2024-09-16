package CRMS;

abstract class Car {
    private int carID;
    private String carModel;
    private String carBrand;
    private int carManufactureYear;  
    private boolean rentalStatus;
    private double rentalFee;
    private String plateNumber;
    private double costPerKilometer;

    // Constructor
    public Car(int carID, String carModel, String carBrand, int carManufactureYear, boolean rentalStatus,
               double rentalFee, String plateNumber, double costPerKilometer) {
        this.carID = carID;
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.carManufactureYear = carManufactureYear;
        this.rentalStatus = rentalStatus;
        this.rentalFee = rentalFee;
        this.plateNumber = plateNumber;
        this.costPerKilometer = costPerKilometer;
    }
    // Getter methods
    public int getCarID() {
        return carID;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public int getCarManufactureYear() {
        return carManufactureYear;
    }

    public double calculateRent(double distanceTraveled) {
        return getRentalFee() + distanceTraveled * getCostPerKilometer();
    }
    public boolean getRentalStatus() {
        return rentalStatus;
    }

    public void setRentalStatus(boolean status) {
    	this.rentalStatus = status;
    }
    
    public double getRentalFee() {
        return rentalFee;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public double getCostPerKilometer() {
        return costPerKilometer;
    }
    
    public void displayCarDetails() {
        System.out.println("Car ID: " + getCarID());
        System.out.println("Model: " + getCarModel());
        System.out.println("Brand: " + getCarBrand());
        System.out.println("Manufacture Year: " + getCarManufactureYear());
        System.out.println("Rental Status: " + (getRentalStatus() ? "Available" : "Rented"));
        System.out.println("Rental Fee: " + getRentalFee());
        System.out.println("Plate Number: " + getPlateNumber());
        System.out.println("Cost Per Kilometer: " + getCostPerKilometer());
    }
}
