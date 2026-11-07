package model;

public class LaundryService {

    private int id;
    private String name;
    private String description;
    private double pricePerKg;

    public LaundryService(int id, String name,
            String description,
            double pricePerKg) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.pricePerKg = pricePerKg;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPricePerKg(double pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Service: " + name +
                " | Description: " + description +
                " | Price/kg: PHP " + pricePerKg;
    }
}
