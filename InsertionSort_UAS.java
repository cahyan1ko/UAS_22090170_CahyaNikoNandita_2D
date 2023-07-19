package UAS_2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;
public class InsertionSort_UAS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();

        System.out.print("Masukkan Kode Customer: ");
        String customerCode = scanner.nextLine();
        System.out.print("Masukkan Nama Customer: ");
        String customerName = scanner.nextLine();
        System.out.print("Masukkan Alamat: ");
        String address = scanner.nextLine();
        System.out.print("Masukkan Nomor Handphone: ");
        String phoneNumber = scanner.nextLine();

        Customer customer = new Customer(customerCode, customerName, address, phoneNumber);

        int itemCount;
        do {
            System.out.print("Masukkan Kode Item: ");
            String itemCode = scanner.nextLine();
            System.out.print("Masukkan Nama Item: ");
            String itemName = scanner.nextLine();
            System.out.print("Masukkan Kuantiti: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.print("Masukkan Harga: ");
            double price = Double.parseDouble(scanner.nextLine());

            customer.addItem(new Item(itemCode, itemName, quantity, price));

            System.out.print("Ketik 1 untuk menambahkan item lainnya, atau 0 untuk selesai: ");
            itemCount = Integer.parseInt(scanner.nextLine());
        } while (itemCount != 0);

        customers.add(customer);
        scanner.close();

        for (Customer cust : customers) {
            List<Item> items = cust.getItems();
            for (int i = 1; i < items.size(); i++) {
                Item key = items.get(i);
                int j = i - 1;
                while (j >= 0 && items.get(j).getItemCode().compareTo(key.getItemCode()) > 0) {
                    items.set(j + 1, items.get(j));
                    j--;
                }
                items.set(j + 1, key);
            }
        }
        JSONArray jsonArray = new JSONArray();
        for (Customer cust : customers) {
            JSONObject jsonCustomer = new JSONObject();
            jsonCustomer.put("customerCode", cust.getCustomerCode());
            jsonCustomer.put("customerName", cust.getCustomerName());
            jsonCustomer.put("address", cust.getAddress());
            jsonCustomer.put("phoneNumber", cust.getPhoneNumber());

            JSONArray jsonItems = new JSONArray();
            for (Item item : cust.getItems()) {
                JSONObject jsonItem = new JSONObject();
                jsonItem.put("itemCode", item.getItemCode());
                jsonItem.put("itemName", item.getItemName());
                jsonItem.put("quantity", item.getQuantity());
                jsonItem.put("price", item.getPrice());
                jsonItems.put(jsonItem);
            }
            jsonCustomer.put("items", jsonItems);
            jsonArray.put(jsonCustomer);
        }
        System.out.println(jsonArray.toString());
    }
}
