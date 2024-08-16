import java.io.Serializable;

public class Customer implements Serializable {
    private String name;
    private String drivingLicenseNumber;
    private String contactNumber;

    public Customer(String name, String drivingLicenseNumber, String contactNumber) {
        this.name = name;
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", drivingLicenseNumber='" + drivingLicenseNumber + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}