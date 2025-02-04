import java.io.*;
import java.util.ArrayList;

public class ProductReader {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("data/ProductData.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    products.add(new Product(parts[0], parts[1], parts[2], Double.parseDouble(parts[3])));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        System.out.printf("%-10s %-15s %-25s %-10s%n", "ID", "Name", "Description", "Cost");
        System.out.println("====================================================================");
        for (Product p : products) {
            System.out.printf("%-10s %-15s %-25s $%-10.2f%n", p.getID(), p.getName(), p.getDescription(), p.getCost());
        }
    }
}
