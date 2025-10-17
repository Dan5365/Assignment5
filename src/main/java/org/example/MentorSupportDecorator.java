package org.example;

public class MentorSupportDecorator extends CourseDecorator {
    private final String mentorName;
    public MentorSupportDecorator(Course wrapped) {
        this(wrapped, "Assigned Mentor");
    }
    public MentorSupportDecorator(Course wrapped, String mentorName) {
        super(wrapped);
        this.mentorName = mentorName;
    }


    @Override public void startCourse(Student student) {
        super.startCourse(student);
        assignMentor(student);
    }


    private void assignMentor(Student student) {
        System.out.println("[Mentor] " + mentorName + " assigned to " + student.getName() + " for course " + wrapped.getName());
        NotificationService.notify(student, "Mentor " + mentorName + " assigned to your course " + wrapped.getName());
        student.setMentor(wrapped.getName(), mentorName);
    }
}