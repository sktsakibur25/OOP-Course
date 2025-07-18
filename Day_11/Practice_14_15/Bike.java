package Day_11.Practice_14_15;

public class Bike extends Vehicle {
    private static final double DAILY_RENTAL_RATE = 15.0; // Example rate per day
    private static final Double DISCOUNT_RATE = 0.15; // 15% discount if bike is older than 3 years
    
    public Bike(String brand, String model, int yearOfManufacture) {
        super(brand, model, yearOfManufacture);
    }
    
    @Override
    public Double calculateRentalCost(Integer days) {
        checkDaysValidation(days);
        if ( days > 7) {
            return days * DAILY_RENTAL_RATE * (1 - DISCOUNT_RATE);
        } else {
            return days * DAILY_RENTAL_RATE;
        }
    }
    
}
