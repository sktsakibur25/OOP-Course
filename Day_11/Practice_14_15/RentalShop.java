package Day_11.Practice_14_15;

public class RentalShop {
    public static void main(String[] args) {
        // Example usage of the Truck class
        Truck truck = new Truck("Ford", "F-150", 2020);
        Car car = new Car("Toyota", "Camry", 2021);
        Bike bike = new Bike("Yamaha", "YZF-R3", 2019);
        Integer rentalDays = 5;

        Double truckCost = truck.calculateRentalCost(rentalDays);
        Double carCost = car.calculateRentalCost(rentalDays);
        Double bikeCost = bike.calculateRentalCost(rentalDays);
    
        System.out.println("Truck rental cost for " + rentalDays + " days: $" + truckCost);
        System.out.println("Car rental cost for " + rentalDays + " days: $" + carCost);
        System.out.println("Bike rental cost for " + rentalDays + " days: $" + bikeCost);
    }
}
