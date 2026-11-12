
package repository;

import model.LaundryService;
import java.util.*;

public class LaundryServiceRepository {

    private Map<String, LaundryService> services = new LinkedHashMap<>();

    public void save(LaundryService service) {
        services.put(service.getServiceId(), service);
    }

    public LaundryService findById(String serviceId) {
        return services.get(serviceId);
    }

    public Collection<LaundryService> findAll() {
        return services.values();
    }
}
