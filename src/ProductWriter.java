import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        File dataFolder = new File("data");
        if (!dataFolder.exists()) {
            dataFolder.mkdir();
        }

        boolean moreData = true;
        while (moreData) {
            System.out.print("Enter Product ID: ");
            String id = in.nextLine();
            System.out.print("Enter Product Name: ");
            String name = in.nextLine();
            System.out.print("Enter Product Description: ");
            String description = in.nextLine();
            System.out.print("Enter Product Cost: ");
            double cost = in.nextDouble();
            in.nextLine();

            products.add(new Product(id, name, description, cost));
            System.out.print("Add another product? (yes/no): ");
            moreData = in.nextLine().equalsIgnoreCase("yes");
        }

        try (FileWriter writer = new FileWriter("data/ProductData.csv")) {
            for (Product p : products) {
                writer.write(p.toCSV() + "\n");
            }
            System.out.println("Records saved successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}