package org.example;

public class GamificationDecorator extends CourseDecorator {
    private final int pointsOnComplete;
    public GamificationDecorator(Course wrapped) { this(wrapped, 100); }
    public GamificationDecorator(Course wrapped, int pointsOnComplete) {
        super(wrapped);
        this.pointsOnComplete = pointsOnComplete;
    }


    @Override public void deliverContent(Student student) {
        super.deliverContent(student);
        awardParticipation(student);
    }


    @Override public void completeCourse(Student student) {
        super.completeCourse(student);
        awardCompletion(student);
    }


    private void awardParticipation(Student student) {
        int pts = pointsOnComplete / 10;
        Leaderboard.addPoints(student, pts);
        System.out.println("[Gamification] " + student.getName() + " gained " + pts + " points for participating in " + wrapped.getName());
    }


    private void awardCompletion(Student student) {
        Leaderboard.addPoints(student, pointsOnComplete);
        System.out.println("[Gamification] " + student.getName() + " gained " + pointsOnComplete + " points for completing " + wrapped.getName());
        NotificationService.notify(student, "You earned " + pointsOnComplete + " points for completing " + wrapped.getName());
    }
}