import java.util.ArrayList;
import java.util.Scanner;

public class Person {
    private String firstName;
    private String lastName;
    private final String ID;
    private String title;
    private int yearOfBirth;

    public Person(String ID, String firstName, String lastName, String title, int yearOfBirth) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.yearOfBirth = yearOfBirth;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getTitle() { return title; }
    public int getYearOfBirth() { return yearOfBirth; }
    public String getID() { return ID; }

    public String fullName() { return firstName + " " + lastName; }
    public String formalName() { return title + " " + fullName(); }

    public String toCSV() {
        return String.format("%s,%s,%s,%s,%d", ID, firstName, lastName, title, yearOfBirth);
    }

    public static ArrayList<Person> people = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean moreData = true;

        while (moreData) {
            System.out.print("Enter ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter Title: ");
            String title = scanner.nextLine();
            System.out.print("Enter Year of Birth: ");
            int yearOfBirth = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            people.add(new Person(id, firstName, lastName, title, yearOfBirth));

            System.out.print("Add another person? (yes/no): ");
            moreData = scanner.nextLine().equalsIgnoreCase("yes");
        }

        System.out.println("\nStored People:");
        for (Person p : people) {
            System.out.println(p.toCSV());
        }

        scanner.close();
    }
}