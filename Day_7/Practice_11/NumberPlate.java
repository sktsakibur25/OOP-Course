package Day_7.Practice_11;

import java.time.LocalDate;

import Day_7.Practice_11.Exceptions.CarIsNotEligibleException;

@SuppressWarnings("unused")
public class NumberPlate {
    private String plateNumber;
    private LocalDate issueDate;
    private LocalDate expiryDate;

    private Car car;

    public NumberPlate(LocalDate issueDate, Car car) throws CarIsNotEligibleException {
        checkCarEligibility(car);
        this.plateNumber = generatePlateNumber();
        this.issueDate = issueDate;
        this.expiryDate = calculateExpiryDate(issueDate, car);

    }

    private String generatePlateNumber() {
        StringBuilder plateNumber = new StringBuilder();
        plateNumber.append("DHK-");
        for (int i = 0; i < 3; i++) {
            plateNumber.append((char) ('A' + (int) (Math.random() * 26)));
        }
        plateNumber.append("-");
        for (int i = 0; i < 6; i++) {
            plateNumber.append((int) (Math.random() * 10));
        }
        return plateNumber.toString();
    }

    private LocalDate calculateExpiryDate(LocalDate issueDate, Car car){
        LocalDate expiryDate = issueDate.plusYears(BRTC.MAXIMUM_VALIDITY_IN_YEARS - car.getAge());
        return expiryDate;
    }

    private void checkCarEligibility(Car car) throws CarIsNotEligibleException {
        if (car.getAge() > BRTC.VALID_CAR_AGE_IN_YEARS) {
            throw new CarIsNotEligibleException(
                "Car is not eligible for registration. Age of the car is " + car.getAge() + " years, which exceeds the maximum allowed age of " + BRTC.VALID_CAR_AGE_IN_YEARS + " years."
            );
        }
    }

    public String getPlateNumber() {
        return plateNumber;
    }
    
}
