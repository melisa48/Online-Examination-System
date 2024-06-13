import java.util.Scanner;

import controllers.UserController;
import controllers.ExamController;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserController userController = new UserController();
        ExamController examController = new ExamController();

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Create Exam (Admin)");
            System.out.println("4. Take Exam");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    userController.register(scanner);
                    break;
                case 2:
                    userController.login(scanner);
                    break;
                case 3:
                    examController.createExam(scanner);
                    break;
                case 4:
                    examController.takeExam(scanner);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
