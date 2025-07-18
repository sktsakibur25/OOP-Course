package Day_11.Practice_14_15;

public class Truck extends Vehicle {
    private static final double DAILY_RENTAL_RATE = 100.0; // Example rate per day
    private static final Double ADDITIONAL_FEE = 100.0; // Additional fee for trucks
    
    public Truck(String brand, String model, int yearOfManufacture) {
        super(brand, model, yearOfManufacture);
    }
    
    @Override
    public Double calculateRentalCost(Integer days) {
        checkDaysValidation(days);
        return days * (DAILY_RENTAL_RATE+ ADDITIONAL_FEE);
    }
    
}
