package org.example.decorator;

import org.example.NotificationService;
import org.example.model.Course;
import org.example.model.Student;

public class CertificateDecorator extends CourseDecorator {
    public CertificateDecorator(Course wrapped) { super(wrapped); }


    @Override public void completeCourse(Student student) {
        super.completeCourse(student);
        grantCertificate(student);
    }


    private void grantCertificate(Student student) {
        String cert = "Certificate of Completion: " + wrapped.getName();
        System.out.println("[Certificate] Granted to " + student.getName() + " -> " + cert);
        NotificationService.notify(student, "You received a certificate for " + wrapped.getName());
        student.addCertificate(cert);
    }
}