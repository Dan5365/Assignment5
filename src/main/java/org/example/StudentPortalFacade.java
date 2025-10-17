package org.example;

import java.util.*;
public class StudentPortalFacade {
    // enrollment map: studentId -> list of enrolled course instances
    private final Map<java.util.UUID, List<Course>> enrollments = new HashMap<>();


    public void enrollInCourse(Student student, Course course) {
        enrollments.computeIfAbsent(student.getId(), k -> new ArrayList<>()).add(course);
        System.out.println("[Facade] " + student.getName() + " enrolled in " + course.getName());
        NotificationService.notify(student, "You have been enrolled in " + course.getName());
        ProgressTracker.setProgress(student, course.getName(), 0);
    }


    public void startLearning(Student student, Course course) {
        ensureEnrolled(student, course);
        course.startCourse(student);
        ProgressTracker.setProgress(student, course.getName(), 10);
        NotificationService.notify(student, "You started " + course.getName());
    }


    public void deliverLesson(Student student, Course course) {
        ensureEnrolled(student, course);
        course.deliverContent(student);
        int current = ProgressTracker.getProgress(student, course.getName());
        int next = Math.min(100, current + 30);
        ProgressTracker.setProgress(student, course.getName(), next);
        System.out.println("[Facade] Progress for " + student.getName() + " on " + course.getName() + ": " + next + "%");
    }


    public void completeCourse(Student student, Course course) {
        ensureEnrolled(student, course);
        course.completeCourse(student);
        ProgressTracker.setProgress(student, course.getName(), 100);
        NotificationService.notify(student, "Congratulations on completing " + course.getName());
    }


    public void showStudentStatus(Student student) {
        System.out.println("=== Status for " + student.getName() + " ===");
        List<Course> courses = enrollments.getOrDefault(student.getId(), List.of());
        if (courses.isEmpty()) System.out.println("No enrolled courses.");
        for (Course c : courses) {
            System.out.println(c.getName() + " - Progress: " + ProgressTracker.getProgress(student, c.getName()) + "%");
        }
        System.out.println("Certificates: " + student.getCertificates());
        System.out.println("Mentors: " + student.getMentors());
        System.out.println("Points: " + Leaderboard.getPoints(student));
    }


    private void ensureEnrolled(Student student, Course course) {
        List<Course> list = enrollments.get(student.getId());
        if (list == null || !list.contains(course)) {
            throw new IllegalStateException(student.getName() + " is not enrolled in " + course.getName());
        }
    }
}