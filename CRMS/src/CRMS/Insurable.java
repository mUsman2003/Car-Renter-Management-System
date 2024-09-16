package CRMS;

public interface Insurable {
	double calculateInsuranceCost();
    double calculateDamageCost();
    boolean isInsurable();
    void displayFeatures();
    double calculateRent(double abc);
}
