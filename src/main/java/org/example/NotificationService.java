package org.example;

public class NotificationService {
    public static void notify(Student student, String message) {
        System.out.println("[Notification] To " + student.getName() + ": " + message);
    }
}