package org.example;

import org.example.model.Student;

public class EmailNotificationAdapter extends NotificationService {
    private final ExternalEmailService emailService;
    private final String defaultEmailDomain = "@example.com";

    public EmailNotificationAdapter(ExternalEmailService emailService) {
        this.emailService = emailService;
    }

    public static void notify(Student student, String message) {
        ExternalEmailService emailService = new ExternalEmailService();
        String email = student.getName().toLowerCase() + "@example.com";
        emailService.sendEmail(email, message);
    }
}
