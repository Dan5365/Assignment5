package org.example.delivery;

import org.example.model.Student;

public interface DeliveryMethod {
    void deliver(String courseName, Student student);
}
