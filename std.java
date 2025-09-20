package project;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }
}

public class std {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Student Grade Tracker =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Show Summary Report");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            int option = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            switch (option) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter student grade: ");
                    double grade = scanner.nextDouble();

                    students.add(new Student(name, grade));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students added yet.");
                    } else {
                        System.out.println("\n--- Student Records ---");
                        for (Student s : students) {
                            System.out.println("Name: " + s.getName() + ", Grade: " + s.getGrade());
                        }
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No data available for summary.");
                    } else {
                        double total = 0;
                        double highest = students.get(0).getGrade();
                        double lowest = students.get(0).getGrade();

                        for (Student s : students) {
                            double g = s.getGrade();
                            total += g;
                            if (g > highest) highest = g;
                            if (g < lowest) lowest = g;
                        }

                        double average = total / students.size();

                        System.out.println("\n--- Summary Report ---");
                        System.out.printf("Total Students: %d\n", students.size());
                        System.out.printf("Average Grade: %.2f\n", average);
                        System.out.printf("Highest Grade: %.2f\n", highest);
                        System.out.printf("Lowest Grade: %.2f\n", lowest);

                        System.out.println("\nStudents with Highest Grade:");
                        for (Student s : students) {
                            if (s.getGrade() == highest) {
                                System.out.println("- " + s.getName());
                            }
                        }

                        System.out.println("\nStudents with Lowest Grade:");
                        for (Student s : students) {
                            if (s.getGrade() == lowest) {
                                System.out.println("- " + s.getName());
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}