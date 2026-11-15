
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

    public LaundryService findService(String id) {
        return repository.findById(id);
    }

    public Collection<LaundryService> getAllServices() {
        return repository.findAll();
    }
}
