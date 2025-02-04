import java.util.Scanner;

public class SafeInputObj {
    private Scanner pipe;

    public SafeInputObj() {
        this.pipe = new Scanner(System.in);
    }

    public String getNonEmptyString(String prompt) {
        String input;
        do {
            System.out.print(prompt + ": ");
            input = pipe.nextLine().trim();
        } while (input.isEmpty());
        return input;
    }

    public int getInt(String prompt) {
        int num;
        while (true) {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                num = pipe.nextInt();
                pipe.nextLine();
                return num;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                pipe.next();
            }
        }
    }

    public double getDouble(String prompt) {
        double num;
        while (true) {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                num = pipe.nextDouble();
                pipe.nextLine();
                return num;
            } else {
                System.out.println("Invalid input. Please enter a decimal number.");
                pipe.next();
            }
        }
    }

    public boolean getYNConfirm(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt + " (yes/no): ");
            input = pipe.nextLine().trim().toLowerCase();
            if (input.equals("yes") || input.equals("y")) return true;
            if (input.equals("no") || input.equals("n")) return false;
            System.out.println("Invalid input. Please enter yes or no.");
        }
    }
}
