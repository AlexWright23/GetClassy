public class ObjInputTest {
    public static void main(String[] args) {
        SafeInputObj input = new SafeInputObj();

        String name = input.getNonEmptyString("Enter your name");
        int age = input.getInt("Enter your age");
        boolean confirm = input.getYNConfirm("Do you confirm the details?");

        System.out.println("\nUser Input Summary:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Confirmation: " + (confirm ? "Confirmed" : "Not Confirmed"));
    }
}
