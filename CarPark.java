import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Purpose of this work is to create a car park management system that manages parking slots and cars.
 * Reference for regrex: https://www.w3schools.com/java/java_regex.asp
 * Reference for advanced features: https://www.javatpoint.com/java-get-current-date#:~:text=Get%20Current%20Date%20%26%20Time%3A%20java,the%20current%20date%20and%20time.
 * 
 * @author Rithikun Sen 103800533
 * @version JDK version 20.0.2; Program version 1.0
 * @date Created on 01 Sep 2023
 */

/**
 * Represents a car park management system that manages parking slots and cars.
 */
public class CarPark {
    private List<ParkingSlot> parkingSlots;

    /**
     * Initializes a new CarPark with an empty list of parking slots.
     */
    public CarPark() {
        this.parkingSlots = new ArrayList<>();
    }

    /**
     * Adds a parking slot to the car park.
     *
     * @param slot The parking slot to add.
     */
    public void addParkingSlot(ParkingSlot slot) {
        parkingSlots.add(slot);
    }

    /**
     * Deletes a parking slot by its identifier if it is not occupied.
     *
     * @param identifier The identifier of the parking slot to delete.
     */
    public void deleteParkingSlot(String identifier) {
        parkingSlots.removeIf(slot -> slot.getIdentifier().equals(identifier));
    }

    /**
     * Checks if a parking slot with the given identifier exists.
     *
     * @param identifier The identifier to check.
     * @return True if the parking slot exists, false otherwise.
     */
    public boolean foundSlot(String identifier) {
        for (ParkingSlot slot : parkingSlots) {
            if (slot.getIdentifier().equals(identifier)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a parking slot with the given identifier is occupied.
     *
     * @param identifier The identifier to check.
     * @return True if the parking slot is occupied, false otherwise.
     */
    public boolean isSlotOccupied(String identifier) {
        for (ParkingSlot slot : parkingSlots) {
            if (slot.getIdentifier().equals(identifier) && slot.isCarParked()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Lists all parking slots in the car park.
     */
    public void listParkingSlots() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("List of Parking Slots:");
        for (ParkingSlot slot : parkingSlots) {
            System.out.print("SlotID " + slot.getIdentifier());
            if (slot.isCarParked()) {
                Car parkedCar = slot.getParkedCar();
                Date currentTime = new Date();
                long parkingDuration = currentTime.getTime() - parkedCar.getParkingTime().getTime();
                long seconds = parkingDuration / 1000 % 60;
                long minutes = parkingDuration / (60 * 1000) % 60;
                long hours = parkingDuration / (60 * 60 * 1000);
                System.out.println(" is occupied by a car with reg: " + parkedCar.getRegistrationNumber() +
                        ", Make: " + parkedCar.getMake() +
                        ", Parking Time: " + dateFormat.format(parkedCar.getParkingTime()) +
                        ", Parking Duration: " + hours + " hours " + minutes + " minutes " + seconds + " seconds");
            } else {
                System.out.println(" is not occupied.");
            }
        }
    }

    /**
     * Parks a car into a parking slot.
     *
     * @param slotIdentifier The identifier of the parking slot.
     * @param car            The car to park.
     */
    public void parkCar(String slotIdentifier, Car car) {
        for (ParkingSlot slot : parkingSlots) {
            if (slot.getIdentifier().equals(slotIdentifier) && !slot.isCarParked()) {
                car.setParkingTime(new Date()); // Set the parking time
                slot.parkCarInfo(car);
                return;
            }
        }
    }

    /**
     * Checks if a car with the given registration number is parked in the car park.
     *
     * @param regNumber The registration number of the car to check.
     * @return True if the car is parked, false otherwise.
     */
    public boolean containsCar(String regNumber) {
        for (ParkingSlot slot : parkingSlots) {
            if (slot.isCarParked() && slot.getParkedCar().getRegistrationNumber().equals(regNumber)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds a car by its registration number and shows the slot information if the
     * car is parked.
     *
     * @param registrationNumber The registration number of the car to find.
     */
    public void findCarByRegistrationNumber(String registrationNumber) {
        // System.out.println("Searching for car with registration number: " +
        // registrationNumber);
        for (ParkingSlot slot : parkingSlots) {
            if (slot.isCarParked() && slot.getParkedCar().getRegistrationNumber().equals(registrationNumber)) {
                System.out.println("The car with reg=" + registrationNumber +
                        " is parked on the slot=" + slot.getIdentifier());
                return;
            }
        }
        System.out.println("Car with registration number " + registrationNumber + " not found.");
    }

    /**
     * Removes a car by its registration number if it is parked.
     *
     * @param registrationNumber The registration number of the car to remove.
     */
    public void removeCarByRegistrationNumber(String registrationNumber) {
        for (ParkingSlot slot : parkingSlots) {
            if (slot.isCarParked() && slot.getParkedCar().getRegistrationNumber().equals(registrationNumber)) {
                slot.removeCar();
                System.out.println("Car with registration number " + registrationNumber + " removed from slot " +
                        slot.getIdentifier() + ".");
                return;
            }
        }
        System.out.println("Car with registration number " + registrationNumber + " not found.");
    }

    /**
     * Finds cars by their make and shows slot information if they are parked.
     *
     * @param make The make of the cars to find.
     */
    public void findCarsByMake(String make) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // System.out.println("Searching for cars with make: " + make;
        for (ParkingSlot slot : parkingSlots) {
            if (slot.isCarParked() && slot.getParkedCar().getMake().equals(make)) {
                Car parkedCar = slot.getParkedCar();
                Date currentTime = new Date();
                long parkingDuration = currentTime.getTime() - parkedCar.getParkingTime().getTime();
                long seconds = parkingDuration / 1000 % 60;
                long minutes = parkingDuration / (60 * 1000) % 60;
                long hours = parkingDuration / (60 * 60 * 1000);

                System.out.println("Slot ID: " + slot.getIdentifier() + ", Reg: " +
                        parkedCar.getRegistrationNumber() + ", Make: " +
                        parkedCar.getMake() + ", Model: " +
                        parkedCar.getModel() + ", Year: " +
                        parkedCar.getYear() + ", Parking Time: " +
                        dateFormat.format(parkedCar.getParkingTime()) +
                        ", Parking Duration: " + hours + " hours " + minutes + " minutes " + seconds + " seconds");
            } else {
                System.out.println("The model (" + make + ") is not found!");
            }
        }
    }
}