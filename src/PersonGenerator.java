import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();

        File dataFolder = new File("data");
        if (!dataFolder.exists()) {
            dataFolder.mkdir();
        }

        boolean moreData = true;
        while (moreData) {
            System.out.print("Enter ID: ");
            String id = in.nextLine();
            System.out.print("Enter First Name: ");
            String firstName = in.nextLine();
            System.out.print("Enter Last Name: ");
            String lastName = in.nextLine();
            System.out.print("Enter Title: ");
            String title = in.nextLine();
            System.out.print("Enter Year of Birth: ");
            int yearOfBirth = in.nextInt();
            in.nextLine();

            people.add(new Person(id, firstName, lastName, title, yearOfBirth));
            System.out.print("Add another person? (yes/no): ");
            moreData = in.nextLine().equalsIgnoreCase("yes");
        }

        try (FileWriter writer = new FileWriter("data/PersonData.csv")) {
            for (Person p : people) {
                writer.write(p.toCSV() + "\n");
            }
            System.out.println("Records saved successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

