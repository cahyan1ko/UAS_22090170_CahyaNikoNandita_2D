package UAS_2D;

public class Item {
    private String itemCode;
    private String itemName;
    private int quantity;
    private double price;
    public Item(String itemCode, String itemName, int quantity, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }
    public String getItemCode() {return itemCode;}

    public String getItemName() {return itemName;}

    public int getQuantity() {return quantity;}

    public double getPrice() {return price;}
}