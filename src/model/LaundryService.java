
package model;

public class LaundryService {
    private String serviceId;
    private String serviceName;
    private String description;
    private double pricePerKg;

    public LaundryService(String serviceId, String serviceName,
            String description, double pricePerKg) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.description = description;
        this.pricePerKg = pricePerKg;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getDescription() {
        return description;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    @Override
    public String toString() {
        return serviceId + " | " + serviceName
                + " | " + description
                + " | PHP " + String.format("%.2f", pricePerKg)
                + "/kg";
    }
}
