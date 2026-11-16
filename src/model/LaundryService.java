package model;

// LaundryService class belongs to the model package.
public class LaundryService {

    // Private attributes to store laundry service information.
    private String serviceId;
    private String serviceName;
    private String description;
    private double pricePerKg;

    // Constructor: initializes the laundry service information
    // whenever a new LaundryService object is created.
    public LaundryService(String serviceId, String serviceName,
            String description, double pricePerKg) {

        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.description = description;
        this.pricePerKg = pricePerKg;
    }

    // Getter: returns the service ID.
    public String getServiceId() {
        return serviceId;
    }

    // Getter: returns the service name.
    public String getServiceName() {
        return serviceName;
    }

    // Getter: returns the service description.
    public String getDescription() {
        return description;
    }

    // Getter: returns the price per kilogram.
    public double getPricePerKg() {
        return pricePerKg;
    }

    // toString(): displays the laundry service information
    // in a readable format.
    @Override
    public String toString() {
        return serviceId + " | " + serviceName
                + " | " + description
                + " | PHP " + String.format("%.2f", pricePerKg)
                + "/kg";
    }
}
