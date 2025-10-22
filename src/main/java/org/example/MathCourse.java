package org.example;

public class MathCourse implements Course {
    private final String name = "Math 101";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void deliverContent(Student student) {
        System.out.println("[" + name + "] Delivering math lesson to " + student.getName());
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