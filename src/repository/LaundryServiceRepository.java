package repository;

// Imports the LaundryService class
import model.LaundryService;

// Imports Java utility classes such as Map, LinkedHashMap, and Collection
import java.util.*;

public class LaundryServiceRepository {

    // Creates a LinkedHashMap to store laundry services.
    // String represents the Service ID.
    // LaundryService represents the service information.
    private Map<String, LaundryService> services = new LinkedHashMap<>();

    // Saves a new laundry service or updates an existing service.
    public void save(LaundryService service) {
        services.put(service.getServiceId(), service);
    }

    // Searches for a laundry service using its Service ID.
    // Returns the service if found; otherwise, returns null.
    public LaundryService findById(String serviceId) {
        return services.get(serviceId);
    }

    // Retrieves and returns all available laundry services.
    public Collection<LaundryService> findAll() {
        return services.values();
    }
}