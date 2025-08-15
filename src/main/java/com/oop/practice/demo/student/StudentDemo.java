package com.oop.practice.demo.student;

import com.oop.practice.models.student.Student;

import java.util.Arrays;

/**
 * Demo class for Student operations.
 * Demonstrates class composition, collections, and calculations.
 */
public class StudentDemo {
    
    /**
     * Runs the Student demo.
     */
    public static void run() {
        System.out.println("\n===== Starting Student Demo =====");
        
        // Create a new student
        Student student = new Student("Alice Johnson", "S12345", 20);
        System.out.println("\n=== Created new student ===");
        System.out.println(student);
        
        // Enroll in courses
        System.out.println("\n=== Enrolling in courses ===");
        student.enrollCourse("Mathematics");
        student.enrollCourse("Computer Science");
        student.enrollCourse("Physics");
        System.out.println("Enrolled courses: " + student.getCourses());
        
        // Add grades
        System.out.println("\n=== Adding grades ===");
        student.addGrade("Mathematics", 85.5);
        student.addGrade("Computer Science", 92.0);
        student.addGrade("Physics", 88.5);
        
        // Try to add grade for non-enrolled course
        System.out.println("\n=== Trying to add grade for non-enrolled course ===");
        student.addGrade("Chemistry", 75.0);
        
        // Calculate GPA
        System.out.println("\n=== Calculating GPA ===");
        double gpa = student.getGpa();
        System.out.println("Current GPA: " + gpa);
        
        // Update academic standing
        System.out.println("\n=== Updating academic standing ===");
        student.getAcademicStanding() ;
        System.out.println("Academic standing: " + student.getAcademicStanding());
        
        // Generate report
        System.out.println("\n=== Generating student report ===");
        String report = student.generateReport();
        System.out.println(report);
        
        // Test removing a course
        System.out.println("\n=== Removing a course ===");
        student.dropCourse("Physics");
        System.out.println("Updated courses: " + student.getCourses());
        
        System.out.println("\n===== Student Demo Completed =====\n");
    }
}
