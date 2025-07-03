package Day_5.Practic_6;

import java.time.LocalDate;
import java.util.UUID;
public class Cars {
    private String id;
    private String model;
    private String color;
    private CarType carType;
    private Double pricePerDay;
    private Boolean isOnMaintanance;
    private Integer maintananceDurationInDays;
    private LocalDate rentalStartDate;
    private LocalDate rentalEndDate;

    public Cars(String model, String color, CarType carType, Double pricePerDay, Integer maintananceDurationInDays) {
        this.id = UUID.randomUUID().toString().substring(0, 4).toUpperCase();
        this.model = model;
        this.color = color;
        this.carType = carType;
        this.pricePerDay = pricePerDay;
        this.maintananceDurationInDays = maintananceDurationInDays;
    }

    public LocalDate getRentalStartDate() {
        return rentalStartDate;
    }
    public void setRentalStartDate(LocalDate rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }
    public LocalDate getRentalEndDate() {
        return rentalEndDate;
    }
    public void setRentalEndDate(LocalDate rentalEndDate) {
        this.rentalEndDate = rentalEndDate;
    }

    public String getId() {
        return id;
    }
    public String getModel() {
        return model;
    }
    public String getColor() {
        return color;
    }
    public CarType getCarType() {
        return carType;
    }
    public Double getPricePerDay() {
        return pricePerDay;
    }
    public Integer getMaintananceDurationInDays() {
        return maintananceDurationInDays;
    }
}

