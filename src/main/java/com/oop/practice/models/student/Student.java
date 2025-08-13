package com.oop.practice.models.student;

import java.util.*;

/**
 * Represents a student with subjects and grades.
 */
public class Student {
    private final String name;
    private final String Id;
    private final int age;
    private final List<String> courses;
    private final Map<String, Double> courseGrades;
    private String academicStanding;
    private double gpa;

    public Student(String name, String Id, int age, String academicStanding) {
        this.name = name;
        this.Id = Id;
        this.age = age;
        this.courses = new ArrayList<>();
        this.courseGrades = new HashMap<>();
        this.academicStanding = academicStanding;
        this.gpa = 0.0;
    }
    
    public List<String> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    public double getGpa() {
        return gpa;
    }

    public String getAcademicStanding() {
        return academicStanding;
    }

    public void enrollCourse(String course){
        //validate
        if (courses.contains(course)){
            System.out.println("This student is already enrolled in the course");
        }
        //add
        else {
            courses.add(course);
            System.out.println("Added new course : " + course);
        }
    }

    public void dropCourse(String course) {
        //validate
        if (!courses.contains(course)){
            System.out.println("The student is not enrolled in the course");
        }
        //drop
        else {
            courses.remove(course);
            courseGrades.remove(course);
            System.out.println("Dropped the course : " + course);
            updateGPA();
        }
    }

    public void addGrade(String course, double grade) {
        //validate
        //valid course
        if (!courses.contains(course)) {
            System.out.println("The student is not enrolled in the course");
        }
        //valid grade
        else if (grade < 0 && grade > 10) {
            System.out.println("Invalid grade");
        }
        //add grade
        else {
            //add grade
            courseGrades.put(course, grade);
            //update GPA
            updateGPA();
        }
    }

        private void updateGPA() {
            this.gpa = courseGrades.values()
                            .stream()
                            .mapToDouble(Double::doubleValue)
                            .average().orElse(0);
            updateAcademicStanding();
        }

    private void updateAcademicStanding() {
        if (gpa >= 8.5) {
            academicStanding = "First Class";
        } else if (gpa >= 7) {
            academicStanding = "Second Class Upper";
        } else if (gpa >= 6) {
            academicStanding = "Second Class Lower";
        } else if (gpa >= 4) {
            academicStanding = "Pass";
        } else {
            academicStanding = "Fail";
        }
    }

    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Student Name: ").append(name);
        stringBuilder.append("\nStudent Id : ").append(Id);
        stringBuilder.append("\nStudent Age : ").append(age);
        stringBuilder.append("\nCourses enrolled and grades : ");
        courses.stream()
                .forEach(course ->stringBuilder.append("\n\tCourse: ").append(course).append(" | Grade : ").append(courseGrades.containsKey(course)? courseGrades.get(course): "NA"));
        stringBuilder.append("\nStudent's Academic Standing : ").append(academicStanding);
        stringBuilder.append("\nStudents's GPA : ").append(gpa);
        return stringBuilder.toString();
    }

}
