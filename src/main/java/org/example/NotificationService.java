package org.example;

import org.example.model.Student;

public class NotificationService {
    public static void notify(Student student, String message) {
        System.out.println("[Notification] To " + student.getName() + ": " + message);
    }
}