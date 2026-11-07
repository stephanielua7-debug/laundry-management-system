package repository;

import model.LaundryService;
import java.util.ArrayList;

public class ServiceRepository {

    private static ArrayList<LaundryService> services = new ArrayList<>();

    public void add(LaundryService service) {
        services.add(service);
    }

    public ArrayList<LaundryService> getAll() {
        return new ArrayList<>(services);
    }

    public LaundryService findById(int id) {

        for (LaundryService service : services) {

            if (service.getId() == id) {
                return service;
            }
        }

        return null;
    }

    public boolean update(LaundryService updated) {

        LaundryService service = findById(updated.getId());

        if (service != null) {

            service.setName(updated.getName());

            service.setDescription(
                    updated.getDescription());

            service.setPricePerKg(
                    updated.getPricePerKg());

            return true;
        }

        return false;
    }

    public boolean delete(int id) {

        LaundryService service = findById(id);

        if (service != null) {
            services.remove(service);
            return true;
        }

        return false;
    }
}
