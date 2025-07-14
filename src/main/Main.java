package main;
import service.StudentService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== STUDENT MANAGEMENT MENU =====");
            System.out.println("1. Add student");
            System.out.println("2. Delete student");
            System.out.println("3. Search student");
            System.out.println("4. Display all students");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    studentService.addStudentByInput(scanner);
                    break;
                case "2":
                    studentService.deleteStudentByInput(scanner);
                    break;
                case "3":
                    studentService.searchStudentByInput(scanner);
                    break;
                case "4":
                    studentService.displayAllStudents();
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Program exited.");
        scanner.close();
    }
}
