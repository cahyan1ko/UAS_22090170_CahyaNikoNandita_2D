package UAS_2D;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerCode;
    private String customerName;
    private String address;
    private String phoneNumber;
    private List<Item> items;

    public Customer(String customerCode, String customerName, String address, String phoneNumber) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.items = new ArrayList<>();
    }

    public String getCustomerCode() {return customerCode;}

    public String getCustomerName() {return customerName;}

    public String getAddress() {return address;}

    public String getPhoneNumber() {return phoneNumber;}

    public void addItem(Item item) {items.add(item);}

    public List<Item> getItems() {  return items;}
}