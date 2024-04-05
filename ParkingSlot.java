
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
 * Represents a parking slot in the car park.
 */
public class ParkingSlot {
    private String identifier;
    private Car parkedCar;

    /**
     * Initializes a new parking slot with the given identifier.
     *
     * @param identifier The identifier for the parking slot.
     */
    public ParkingSlot(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Gets the identifier of the parking slot.
     *
     * @return The identifier of the parking slot.
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Checks if a car is parked in the parking slot.
     *
     * @return True if a car is parked, false otherwise.
     */
    public boolean isCarParked() {
        return parkedCar != null;
    }

    /**
     * Gets the car parked in the slot.
     *
     * @return The parked car, or null if the slot is empty.
     */
    public Car getParkedCar() {
        return parkedCar;
    }

    /**
     * Parks a car in the parking slot.
     *
     * @param car The car to park.
     */
    public void parkCarInfo(Car car) {
        parkedCar = car;
    }

    /**
     * Removes the parked car from the slot.
     */
    public void removeCar() {
        parkedCar = null;
    }
}