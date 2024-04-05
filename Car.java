
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
 * Represents a car with a registration number, make, model, and year.
 */
public class Car {
    private String registrationNumber;
    private String make;
    private String model;
    private int year;
    private Date parkingTime;

    /**
     * Initializes a new car with the given registration number, make, model, and
     * year.
     *
     * @param registrationNumber The registration number of the car.
     * @param make               The make of the car.
     * @param model              The model of the car.
     * @param year               The manufacturing year of the car.
     */
    public Car(String registrationNumber, String make, String model, int year) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.parkingTime = null;
    }

    /**
     * Gets the registration number of the car.
     *
     * @return The registration number of the car.
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * Gets the make of the car.
     *
     * @return The make of the car.
     */
    public String getMake() {
        return make;
    }

    /**
     * Gets the model of the car.
     *
     * @return The model of the car.
     */
    public String getModel() {
        return model;
    }

    /**
     * Gets the manufacturing year of the car.
     *
     * @return The manufacturing year of the car.
     */
    public int getYear() {
        return year;
    }

    /**
     * Gets the parking time of the car.
     * 
     * @return The parking time of the car.
     */
    public Date getParkingTime() {
        return parkingTime;
    }

    /**
     * Sets the parking time of the car.
     * 
     * @param parkingTime The parking time of the car.
     */
    public void setParkingTime(Date parkingTime) {
        this.parkingTime = parkingTime;
    }

}