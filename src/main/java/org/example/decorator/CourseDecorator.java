package org.example.decorator;

import org.example.model.Course;
import org.example.model.Student;

public abstract class CourseDecorator implements Course {
    protected final Course wrapped;

    public CourseDecorator(Course wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public String getName() {
        return wrapped.getName();
    }

    @Override
    public void deliverContent(Student student) {
        wrapped.deliverContent(student);
    }

    @Override
    public void startCourse(Student student) {
        wrapped.startCourse(student);
    }

    @Override
    public void completeCourse(Student student) {
        wrapped.completeCourse(student);
    }
}