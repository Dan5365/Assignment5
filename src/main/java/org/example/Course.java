package org.example;

public interface Course {
    String getName();

    void deliverContent(Student student); // simulate delivering a lesson

    void startCourse(Student student);

    void completeCourse(Student student);
}