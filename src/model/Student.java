package model;

public class Student {
    private int studentId;
    private String fullName;
    private double gpa;

    public Student(int studentId, String fullName, double gpa) {
        if (fullName.length() > 50) {
            throw new IllegalArgumentException("Full name must be at most 50 characters.");
        }
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0.");
        }
        this.studentId = studentId;
        this.fullName = fullName;
        this.gpa = gpa;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setFullName(String fullName) {
        if (fullName.length() > 50) {
            throw new IllegalArgumentException("Full name must be at most 50 characters.");
        }
        this.fullName = fullName;
    }

    public void setGpa(double gpa) {
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0.");
        }
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("| %-10d | %-50s | %-4.2f |", studentId, fullName, gpa);
    }
}
