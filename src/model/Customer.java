package model;

public class Customer {

    private int id;
    private String name;
    private String phone;
    private String address;

    public Customer(int id, String name,
            String phone, String address) {

        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Name: " + name +
                " | Phone: " + phone +
                " | Address: " + address;
    }
}
