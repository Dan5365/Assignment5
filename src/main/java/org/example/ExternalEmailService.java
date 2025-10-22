package org.example;

public class ExternalEmailService {
    public void sendEmail(String emailAddress, String content) {
        System.out.println("[ExternalEmailService] Sending email to " + emailAddress + ": " + content);
    }
}
