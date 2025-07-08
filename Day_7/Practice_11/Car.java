package Day_7.Practice_11;

import java.time.LocalDate;

import Day_7.Practice_11.Exceptions.InvalidManufactureYearException;

@SuppressWarnings("unused")
public class Car {
    private String model;
    private String color;
    private Integer manufactureYear;
    private String ownerName;
    private String ownerAddress;
    private String ownerNID;
    private String ownerPhoneNumber;

    private NumberPlate numberPlate;


    public Car(String model, String color, Integer manufactureYear, String ownerName, String ownerAddress, String ownerNID, String ownerPhoneNumber) throws InvalidManufactureYearException {
        checkManufactureYear(manufactureYear);
        this.model = model;
        this.color = color;
        this.manufactureYear = manufactureYear;
        this.ownerName = ownerName;
        this.ownerAddress = ownerAddress;
        this.ownerNID = ownerNID;
        this.ownerPhoneNumber = ownerPhoneNumber;
    }

    private void checkManufactureYear(Integer manufactureYear) throws InvalidManufactureYearException {
        if (manufactureYear < 1886 || manufactureYear > LocalDate.now().getYear()) {
            throw new InvalidManufactureYearException("Invalid manufacture year: " + manufactureYear);
        }
    }

    public Integer getManufactureYear() {
        return manufactureYear;
    }

    public Integer getAge() {
        return LocalDate.now().getYear() - manufactureYear;
    }

}
