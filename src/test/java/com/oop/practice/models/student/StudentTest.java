package com.oop.practice.models.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class StudentTest {
    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student("John Doe", "S12345", 20);
    }

    @Test
    void testEnrollCourse() {
        student.enrollCourse("CS101");
        assertTrue(student.getCourses().contains("CS101"), "Course should be enrolled");
    }

    @Test
    void testEnrollDuplicateCourse() {
        student.enrollCourse("CS101");
        student.enrollCourse("CS101"); // Should not add duplicate
        assertEquals(1, student.getCourses().size(), "Should not add duplicate course");
    }

    @Test
    void testDropCourse() {
        student.enrollCourse("CS101");
        student.dropCourse("CS101");
        assertFalse(student.getCourses().contains("CS101"), "Course should be dropped");
    }

    @Test
    void testDropNonExistentCourse() {
        student.enrollCourse("CS101");
        student.dropCourse("MATH101"); // Not enrolled
        assertEquals(1, student.getCourses().size(), "Should not affect other courses");
    }

    @Test
    void testAddGrade() {
        student.enrollCourse("CS101");
        student.addGrade("CS101", 8.5);
        assertEquals(8.5, student.getGpa(), 0.01, "GPA should be updated");
    }

    @Test
    void testAddGradeToNonEnrolledCourse() {
        student.addGrade("CS101", 8.5); // Not enrolled
        assertEquals(0.0, student.getGpa(), 0.01, "GPA should remain 0 for non-enrolled courses");
    }

    @Test
    void testAcademicStanding() {
        student.enrollCourse("CS101");
        student.enrollCourse("MATH101");
        student.addGrade("CS101", 8.5);
        student.addGrade("MATH101", 9.0);
        
        // GPA = (8.5 + 9.0) / 2 = 8.75 -> First Class
        assertEquals("First Class", student.getAcademicStanding(), "Should be First Class with GPA 8.75");
    }

    @Test
    void testGenerateReport() {
        student.enrollCourse("CS101");
        student.addGrade("CS101", 8.5);
        String report = student.generateReport();
        
        assertAll(
            () -> assertTrue(report.contains("John Doe"), "Report should contain student name"),
            () -> assertTrue(report.contains("S12345"), "Report should contain student ID"),
            () -> assertTrue(report.contains("CS101"), "Report should contain enrolled course"),
            () -> assertTrue(report.contains("8.5"), "Report should contain grade"),
            () -> assertTrue(report.contains("First Class"), "Report should contain academic standing")
        );
    }

    @Test
    void testGpaCalculation() {
        student.enrollCourse("CS101");
        student.enrollCourse("MATH101");
        student.addGrade("CS101", 8.0);
        student.addGrade("MATH101", 9.0);
        
        // (8.0 + 9.0) / 2 = 8.5
        assertEquals(8.5, student.getGpa(), 0.01, "GPA should be average of all grades");
    }

    @Test
    void testUpdateGpaAfterDroppingCourse() {
        student.enrollCourse("CS101");
        student.enrollCourse("MATH101");
        student.addGrade("CS101", 8.0);
        student.addGrade("MATH101", 9.0);
        
        student.dropCourse("MATH101");
        
        // Only CS101 grade should be considered now
        assertEquals(8.0, student.getGpa(), 0.01, "GPA should be recalculated after dropping course");
    }
}
