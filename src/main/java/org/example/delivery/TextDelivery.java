package org.example.delivery;

import org.example.model.Student;

public class TextDelivery implements DeliveryMethod {
    @Override
    public void deliver(String courseName, Student student) {
        System.out.println("[TextDelivery] Showing text materials for " + courseName + " to " + student.getName());
    }
}
