import java.util.ArrayList;
import java.util.Scanner;

public class Product {
    private String ID;
    private String name;
    private String description;
    private double cost;

    public Product(String ID, String name, String description, double cost) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public String getID() { return ID; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getCost() { return cost; }

    public String toCSV() {
        return String.format("%s,%s,%s,%.2f", ID, name, description, cost);
    }

    public static ArrayList<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean moreData = true;

        while (moreData) {
            System.out.print("Enter Product ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter Product Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Product Description: ");
            String description = scanner.nextLine();
            System.out.print("Enter Product Cost: ");
            double cost = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            products.add(new Product(id, name, description, cost));

            System.out.print("Add another product? (yes/no): ");
            moreData = scanner.nextLine().equalsIgnoreCase("yes");
        }

        System.out.println("\nStored Products:");
        for (Product p : products) {
            System.out.println(p.toCSV());
        }

        scanner.close();
    }
}