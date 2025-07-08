package Day_7.Practice_11;

import java.time.LocalDate;

import Day_7.Practice_11.Exceptions.CarIsNotEligibleException;
import Day_7.Practice_11.Exceptions.InvalidManufactureYearException;

public class BRTC {
    public static final Integer MAXIMUM_VALIDITY_IN_YEARS = 10;
    public static final Integer VALID_CAR_AGE_IN_YEARS = 20;

    public static void main(String[] args) {
        try {
            Car car = new Car("Toyota", "Red", 2010, "John Doe", "123 Street", "1234567890", "0123456789");
            NumberPlate numberPlate = new NumberPlate(LocalDate.now(), car);
            System.out.println("Car registered successfully with plate number: " + numberPlate.getPlateNumber());
        } catch (InvalidManufactureYearException | CarIsNotEligibleException e) {
            System.err.println(e.getMessage());
        }
    }
}
