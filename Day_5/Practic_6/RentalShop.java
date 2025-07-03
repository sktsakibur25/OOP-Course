package Day_5.Practic_6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Day_5.Practic_6.Exceptions.CarNotFoundException;
import Day_5.Practic_6.Exceptions.InvalidDateException;

public class RentalShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cars car1 = new Cars("Toyota Camry", "Blue", CarType.SEDAN, 50.0, 1);
        Cars car2 = new Cars("Honda Accord", "Red", CarType.SEDAN, 55.0, 1);
        Cars car3 = new Cars("Ford Explorer", "Black", CarType.SUV, 70.0, 1);
        Cars car4 = new Cars("Chevrolet Tahoe", "White", CarType.SUV, 75.0, 2);
        Cars car5 = new Cars("Dodge Challenger", "Green", CarType.MUSCLE, 180.0, 2);
        Cars car6 = new Cars("Tesla Model S", "Silver", CarType.SEDAN, 100.0, 1);
        Cars car7 = new Cars("BMW X5", "Black", CarType.SUV, 120.0, 1);
        Cars car8 = new Cars("Audi A4", "Blue", CarType.SEDAN, 90.0, 1);
        Cars car9 = new Cars("Volkswagen Golf", "Red", CarType.HATCHBACK, 40.0, 1);
        Cars car10 = new Cars("Mazda CX-5", "Gray", CarType.SUV, 65.0, 1);

        List<Cars> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);
        cars.add(car7);
        cars.add(car8);
        cars.add(car9);
        cars.add(car10);

        System.out.println("Welcome to the Car Rental Shop!");

        while (true) {

            try {

                System.out.println("Enter your car rent starting date (YYYY-MM-DD):  ");
                String input = System.console().readLine();
                LocalDate startDate = LocalDate.parse(input);
                checkDateValidity(startDate);
                System.out.println("Enter your car rent ending date (YYYY-MM-DD):  ");
                input = System.console().readLine();
                LocalDate endDate = LocalDate.parse(input);
                checkDateValidity(endDate);

                if (endDate.isBefore(startDate)) {
                    System.out.println("Invalid date range. Please try again.");
                    throw new InvalidDateException("End date cannot be before start date.");
                }

                printAvailableCars(cars, startDate, endDate);
                System.out.println("Please select a car by entering its ID (or type 'exit' to quit): ");
                String carId = System.console().readLine().trim();
                if (carId.equalsIgnoreCase("exit")) {
                    System.out.println("Thank you for visiting the Car Rental Shop!");
                    break;
                }

                boolean isRentingComplete = rentCar(cars, carId, startDate, endDate);

                if (isRentingComplete) {
                    System.out
                            .println("Thank you for renting a car with us! Do you want to rent another car? (yes/no)");
                    String response = System.console().readLine().trim().toLowerCase();
                    if (response.equalsIgnoreCase("no")) {
                        System.out.println("Thank you for visiting the Car Rental Shop!");
                        scanner.close();
                        break;
                    } else if (!response.equalsIgnoreCase("yes")) {
                        throw new InvalidDateException(
                                "Invalid response. Please enter 'yes' or 'no'. Thank you for visiting the Car Rental Shop!");
                    }
                }

            } catch (InvalidDateException e) {
                System.out.println(e);
                continue;
            } catch (CarNotFoundException e) {
                System.out.println("Car not found: " + e.getMessage());
                continue;
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                continue;
            }
        }
    }

    private static Boolean rentCar(List<Cars> cars, String carId, LocalDate startDate, LocalDate endDate)
            throws CarNotFoundException {

        Integer daysRenting = ((int) (endDate.toEpochDay() - startDate.toEpochDay())) == 0 ? 1
                : (int) (endDate.toEpochDay() - startDate.toEpochDay());
        for (Cars car : cars) {
            if (car.getId().equalsIgnoreCase(carId)) {
                car.setRentalStartDate(startDate);
                car.setRentalEndDate(endDate);

                System.out.printf("You have successfully rented the %s %s from %s to %s. %d Days\n",
                        car.getColor(), car.getModel(), startDate, endDate, daysRenting);
                System.out.printf("Total rental cost: $%.2f\n", car.getPricePerDay() * daysRenting);
                return true;
            }
        }
        throw new CarNotFoundException("Car with ID " + carId + " not found.");
    }

    private static void printAvailableCars(List<Cars> cars, LocalDate startDate, LocalDate endDate) {
        System.out.println("Available Cars:");
        System.out.printf("| %-4s | %-20s | %-10s | %-10s | %-15s |\n", "ID", "Model", "Color", "Type",
                "Price per Day");
        boolean found = false;
        for (Cars car : cars) {
            if (car.getRentalStartDate() == null || car.getRentalEndDate() == null ||
                    (car.getRentalEndDate().isBefore(startDate) || car.getRentalStartDate().isAfter(endDate))) {
                System.out.printf("| %-4s | %-20s | %-10s | %-10s | $%-14.2f |\n", car.getId(), car.getModel(),
                        car.getColor(), car.getCarType(), car.getPricePerDay());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No cars available for the selected dates.");
        }
    }

    private static void checkDateValidity(LocalDate date) throws InvalidDateException {
        LocalDate today = LocalDate.now();
        if (date.isBefore(today)) {
            throw new InvalidDateException("The date cannot be in the past.");
        }
    }
}
