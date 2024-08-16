import java.io.Serializable;

public class Vehicle implements Serializable {
    private String registrationNumber;
    private String brand;
    private String model;
    private boolean isAvailable;

    public Vehicle(String registrationNumber, String brand, String model) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.model = model;
        this.isAvailable = true;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}