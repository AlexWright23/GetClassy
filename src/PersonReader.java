import java.io.*;
import java.util.ArrayList;

public class PersonReader {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("data/PersonData.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    people.add(new Person(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4])));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        System.out.printf("%-10s %-15s %-15s %-10s %-4s%n", "ID", "First Name", "Last Name", "Title", "YOB");
        System.out.println("===============================================================");
        for (Person p : people) {
            System.out.printf("%-10s %-15s %-15s %-10s %-4d%n", p.getID(), p.getFirstName(), p.getLastName(), p.getTitle(), p.getYearOfBirth());
        }
    }
}