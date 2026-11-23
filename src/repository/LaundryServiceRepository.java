package repository;

import model.LaundryService;
import java.util.*;

public class LaundryServiceRepository {

    private Map<String, LaundryService> services = new LinkedHashMap<>();

    // Saves a new or updated laundry service.
    public void save(LaundryService service) {
        services.put(service.getServiceId(), service);
    }

    // Finds a service using its ID.
    public LaundryService findById(String serviceId) {
        return services.get(serviceId);
    }

    // Retrieves all laundry services.
    public Collection<LaundryService> findAll() {
        return services.values();
    }

    // Deletes a laundry service using its ID.
    public boolean delete(String serviceId) {
        return services.remove(serviceId) != null;
    }
}