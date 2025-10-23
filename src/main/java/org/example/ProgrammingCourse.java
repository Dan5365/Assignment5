package org.example;

import org.example.model.Course;
import org.example.model.Student;

public class ProgrammingCourse implements Course {
    private final String name = "Programming 101";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void deliverContent(Student student) {
        System.out.println("[" + name + "] Delivering programming exercise to " + student.getName());
    }

    @Override
    public void startCourse(Student student) {
        System.out.println("[" + name + "] " + student.getName() + " started the course.");
    }

    @Override
    public void completeCourse(Student student) {
        System.out.println("[" + name + "] " + student.getName() + " completed the course.");
    }
}