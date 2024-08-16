import java.io.Serializable;
import java.time.LocalDate;

public class Rental implements Serializable {
    private Customer customer;
    private Vehicle vehicle;
    private LocalDate rentalDate;
    private int rentalDays;
    private double rentalCost;

    public Rental(Customer customer, Vehicle vehicle, LocalDate rentalDate, int rentalDays, double rentalCost) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDate = rentalDate;
        this.rentalDays = rentalDays;
        this.rentalCost = rentalCost;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "customer=" + customer +
                ", vehicle=" + vehicle +
                ", rentalDate=" + rentalDate +
                ", rentalDays=" + rentalDays +
                ", rentalCost=" + rentalCost +
                '}';
    }
}