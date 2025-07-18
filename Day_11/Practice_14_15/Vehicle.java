package Day_11.Practice_14_15;

public class Vehicle implements VehicleFunctions {
    protected String brand;
    protected String model;
    protected int yearOfManufacture;

    protected Vehicle(String brand, String model, int yearOfManufacture) {
        this.brand = brand;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
    }

    @Override
    public Double calculateRentalCost(Integer days) {
        throw new UnsupportedOperationException("Unimplemented method 'calculateRentalCost'");
    }

    protected void checkDaysValidation(Integer days) {
        if (days == null || days < 0) {
            throw new IllegalArgumentException("Days must be a non-negative integer.");
        }
    }
}
