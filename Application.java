import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Purpose of this work is to create a car park management system that manages parking slots and cars.
 * Reference for Regrex: https://www.w3schools.com/java/java_regex.asp
 * Reference for Advanced Features: https://www.javatpoint.com/java-get-current-date#:~:text=Get%20Current%20Date%20%26%20Time%3A%20java,the%20current%20date%20and%20time.
 * 
 * @author Rithikun Sen 103800533
 * @version JDK version 20.0.2; Program version 1.0
 * @date Created on 01 Sep 2023
 */

/**
 * Represents the application class with a main method for user interaction.
 */
public class Application {
    public static void main(String[] args) {
        CarPark carPark = new CarPark();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add a car slot");
            System.out.println("2. Delete a car slot");
            System.out.println("3. List all car slots");
            System.out.println("4. Park a car");
            System.out.println("5. Find a car by reg");
            System.out.println("6. Remove a car by reg");
            System.out.println("7. Find cars by make");
            System.out.println("8. Exit");
            System.out.print("Please select an option (1-7): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid option.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Please enter the Slot ID (e.g. A001): ");
                    String slotID = scanner.nextLine();
                    if (!isValidSlotID(slotID)) {
                        System.out.println(
                                "Invalid Slot ID format. It should be an uppercase letter followed by 3 digits.");
                    } else if (carPark.foundSlot(slotID)) {
                        System.out.println("The slot already exists.");
                    } else {
                        carPark.addParkingSlot(new ParkingSlot(slotID));
                        System.out.println("The slot added successfully.");
                    }
                    break;
                case 2:
                    System.out.print("Enter Slot ID to delete: ");
                    String deleteSlotID = scanner.nextLine();
                    if (!isValidSlotID(deleteSlotID)) {
                        System.out.println(
                                "Invalid Slot ID format. It should be an uppercase letter followed by 3 digits.");
                    } else if (!carPark.foundSlot(deleteSlotID)) {
                        System.out.println("Slot ID not found.");
                    } else if (carPark.isSlotOccupied(deleteSlotID)) {
                        System.out.println("Cannot delete slot " + deleteSlotID + " because it is occupied.");
                    } else {
                        carPark.deleteParkingSlot(deleteSlotID);
                        System.out.println("Slot ID: " + deleteSlotID + " deleted.");
                    }
                    break;
                case 3:
                    carPark.listParkingSlots();
                    break;
                case 4:
                    System.out.print("Please enter the Slot ID (e.g. A001) that you want to park at: ");
                    String parkSlotID = scanner.nextLine();
                    if (!isValidSlotID(parkSlotID)) {
                        System.out.println(
                                "Invalid Slot ID format. It should be an uppercase letter followed by 3 digits.");
                    } else if (!carPark.foundSlot(parkSlotID)) {
                        System.out.println("Slot ID not found.");
                    } else if (carPark.isSlotOccupied(parkSlotID)) {
                        System.out.println("Slot " + parkSlotID + " is already occupied.");
                    } else {
                        System.out.print("Please enter the car registration number (such as D1234): ");
                        String regNumber = scanner.nextLine();
                        if (!isValidRegNumber(regNumber)) {
                            System.out.println(
                                    "Invalid car registration number format. It should be an uppercase letter followed by 4 digits.");
                        } else if (carPark.containsCar(regNumber)) {
                            System.out.println("Car with registration number " + regNumber + " is already parked.");
                        } else {
                            System.out.print("Please enter the car's make (e.g. Toyota): ");
                            String make = scanner.nextLine();
                            System.out.print("Please enter the car's model (e.g. Corolla): ");
                            String model = scanner.nextLine();
                            System.out.print("Please enter the car's year (e.g. 2009): ");
                            int year;
                            try {
                                year = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input for car year. Please enter a valid year.");
                                continue;
                            }
                            Car car = new Car(regNumber, make, model, year);
                            carPark.parkCar(parkSlotID, car);
                            System.out.println("The car has been parked successfully.");
                        }
                    }
                    break;
                case 5:
                    System.out.print("Please enter the car registration number (such as D1234): ");
                    String findRegNumber = scanner.nextLine();
                    carPark.findCarByRegistrationNumber(findRegNumber);
                    break;
                case 6:
                    System.out.print("Please enter the car registration number to remove: ");
                    String removeRegNumber = scanner.nextLine();
                    carPark.removeCarByRegistrationNumber(removeRegNumber);
                    break;
                case 7:
                    System.out.print("Please enter the car's make (e.g. Toyota): ");
                    String findMake = scanner.nextLine();
                    carPark.findCarsByMake(findMake);
                    break;
                case 8:
                    System.out.println("Program end!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static boolean isValidSlotID(String slotID) {
        return Pattern.matches("^[A-Z]\\d{3}$", slotID);
    }

    private static boolean isValidRegNumber(String regNumber) {
        return Pattern.matches("^[A-Z]\\d{4}$", regNumber);
    }
}