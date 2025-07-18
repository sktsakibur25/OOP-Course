package Day_11.Practice_14_15;

import java.util.Calendar;

public class Car extends Vehicle {
    private static final double DAILY_RENTAL_RATE = 50.0; // Example rate per day
    private static final Double DISCOUNT_RATE = 0.1; // 10% discount if car is older than 5 years
    
    public Car(String brand, String model, int yearOfManufacture) {
        super(brand, model, yearOfManufacture);
    }
    
    @Override
    public Double calculateRentalCost(Integer days) {
        checkDaysValidation(days);
        if (Calendar.getInstance().get(Calendar.YEAR) - this.yearOfManufacture > 5) {
            return days * DAILY_RENTAL_RATE * (1 - DISCOUNT_RATE);
        } else {
            return days * DAILY_RENTAL_RATE;
        }
    }
}
