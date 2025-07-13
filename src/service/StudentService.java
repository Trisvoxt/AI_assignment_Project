package service;

import model.Student;
import util.InputHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class StudentService {
    private final List<Student> studentList = new ArrayList<>();

    public void addStudentByInput(Scanner scanner) {
        try {
            int id = InputHelper.readInt(scanner, "Enter student ID: ");
            if (exists(id)) {
                throw new IllegalArgumentException("Student ID already exists.");
            }

            String name = InputHelper.readString(scanner, "Enter full name: ");
            double gpa = InputHelper.readDouble(scanner, "Enter GPA: ");

            Student student = new Student(id, name, gpa);
            studentList.add(student);
            System.out.println("Student added.");
        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    public void deleteStudentByInput(Scanner scanner) {
        int id = InputHelper.readInt(scanner, "Enter ID to delete: ");
        boolean removed = studentList.removeIf(s -> s.getStudentId() == id);
        if (removed) {
            System.out.println("Student deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void searchStudentByInput(Scanner scanner) {
        String keyword = InputHelper.readString(scanner, "Enter name to search: ");
        List<Student> result = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getFullName().toLowerCase(Locale.ROOT).contains(keyword.toLowerCase(Locale.ROOT))) {
                result.add(s);
            }
        }

        if (result.isEmpty()) {
            System.out.println("No matching students found.");
        } else {
            System.out.println("Search Results:");
            System.out.println("| ID         | Full Name                                        | GPA  |");
            System.out.println("-------------------------------------------------------------------------------");
            for (Student s : result) {
                System.out.println(s);
            }
        }
    }

    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("| ID         | Full Name                                        | GPA  |");
        System.out.println("-------------------------------------------------------------------------------");
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    private boolean exists(int id) {
        return studentList.stream().anyMatch(s -> s.getStudentId() == id);
    }
}
