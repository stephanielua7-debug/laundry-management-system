package service;

// Imports the LaundryService class
import model.LaundryService;

// Imports the LaundryServiceRepository class
import repository.LaundryServiceRepository;

// Imports the utility class for generating unique IDs
import util.IdGenerator;

// Imports the utility class for validating user input
import util.InputValidator;

// Imports Collection for handling groups of services
import java.util.Collection;

public class LaundryServiceManager {

    // Creates a reference to LaundryServiceRepository
    // to access and store laundry services.
    private LaundryServiceRepository repository;

    // Constructor that receives the LaundryServiceRepository.
    public LaundryServiceManager(LaundryServiceRepository repository) {
        this.repository = repository;
    }

    // Adds a new laundry service with its name, description, and price.
    public LaundryService addService(
            String name, String description, double price) {

        // Validates the service name to make sure it is not empty.
        name = InputValidator.validateRequired(name, "Service name");

        // Validates the price to make sure it is positive.
        price = InputValidator.validatePositive(price);

        // Generates a unique Service ID.
        String id = IdGenerator.generateServiceId();

        // Creates a new LaundryService object.
        LaundryService service = new LaundryService(
                id, name, description, price);

        // Saves the new service in the repository.
        repository.save(service);

        // Returns the newly created service.
        return service;
    }

    // Searches for a laundry service using its Service ID.
    public LaundryService findService(String id) {
        return repository.findById(id);
    }

    // Retrieves all saved laundry services.
    public Collection<LaundryService> getAllServices() {
        return repository.findAll();
    }
}
