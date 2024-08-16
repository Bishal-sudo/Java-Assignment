import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleRentalSystem {
    private static List<Vehicle> vehicles = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    private static List<Rental> rentals = new ArrayList<>();
    private static final String DATA_FILE = "vehicle_rental_system.dat";

    public static void main(String[] args) {
        loadData();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nVehicle Rental System");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Add Customer");
            System.out.println("3. Rent Vehicle");
            System.out.println("4. View Vehicles");
            System.out.println("5. View Customers");
            System.out.println("6. View Rentals");
            System.out.println("7. Save & Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    addVehicle(scanner);
                    break;
                case 2:
                    addCustomer(scanner);
                    break;
                case 3:
                    rentVehicle(scanner);
                    break;
                case 4:
                    viewVehicles();
                    break;
                case 5:
                    viewCustomers();
                    break;
                case 6:
                    viewRentals();
                    break;
                case 7:
                    saveData();
                    System.out.println("Data saved. Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addVehicle(Scanner scanner) {
        System.out.print("Enter registration number: ");
        String regNumber = scanner.nextLine();
        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        vehicles.add(new Vehicle(regNumber, brand, model));
        System.out.println("Vehicle added successfully.");
    }

    private static void addCustomer(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter driving license number: ");
        String licenseNumber = scanner.nextLine();
        System.out.print("Enter contact number: ");
        String contactNumber = scanner.nextLine();
        customers.add(new Customer(name, licenseNumber, contactNumber));
        System.out.println("Customer added successfully.");
    }

    private static void rentVehicle(Scanner scanner) {
        System.out.print("Enter customer driving license number: ");
        String licenseNumber = scanner.nextLine();
        Customer customer = customers.stream()
                .filter(c -> c.getDrivingLicenseNumber().equals(licenseNumber))
                .findFirst()
                .orElse(null);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("Enter vehicle registration number: ");
        String regNumber = scanner.nextLine();
        Vehicle vehicle = vehicles.stream()
                .filter(v -> v.getRegistrationNumber().equals(regNumber) && v.isAvailable())
                .findFirst()
                .orElse(null);
        if (vehicle == null) {
            System.out.println("Vehicle not available.");
            return;
        }

        System.out.print("Enter rental days: ");
        int rentalDays = scanner.nextInt();
        double rentalCost = rentalDays * 50.0; // Example cost calculation

        vehicle.setAvailable(false);
        rentals.add(new Rental(customer, vehicle, LocalDate.now(), rentalDays, rentalCost));
        System.out.println("Vehicle rented successfully.");
    }

    private static void viewVehicles() {
        vehicles.forEach(System.out::println);
    }

    private static void viewCustomers() {
        customers.forEach(System.out::println);
    }

    private static void viewRentals() {
        rentals.forEach(System.out::println);
    }

    private static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(vehicles);
            oos.writeObject(customers);
            oos.writeObject(rentals);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private static void loadData() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            vehicles = (List<Vehicle>) ois.readObject();
            customers = (List<Customer>) ois.readObject();
            rentals = (List<Rental>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}