package service;

import model.LaundryService;
import repository.LaundryServiceRepository;
import util.IdGenerator;
import util.InputValidator;

import java.util.Collection;

public class LaundryServiceManager {

    private LaundryServiceRepository repository;

    public LaundryServiceManager(LaundryServiceRepository repository) {
        this.repository = repository;
    }

    // ADD SERVICE
    public LaundryService addService(
            String name, String description, double price) {

        name = InputValidator.validateRequired(name, "Service name");
        price = InputValidator.validatePositive(price);

        String id = IdGenerator.generateServiceId();

        LaundryService service = new LaundryService(
                id, name, description, price);

        repository.save(service);

        return service;
    }

    // VIEW ALL SERVICES
    public Collection<LaundryService> getAllServices() {
        return repository.findAll();
    }

    // SEARCH SERVICE
    public LaundryService findService(String id) {
        return repository.findById(id);
    }

    // UPDATE SERVICE
    public LaundryService updateService(
            String id, String name,
            String description, double price) {

        LaundryService existing = repository.findById(id);

        if (existing == null) {
            return null;
        }

        name = InputValidator.validateRequired(name, "Service name");
        price = InputValidator.validatePositive(price);

        LaundryService updatedService = new LaundryService(
                id, name, description, price);

        repository.save(updatedService);

        return updatedService;
    }

    // DELETE SERVICE
    public boolean deleteService(String id) {
        return repository.delete(id);
    }
}